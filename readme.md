# BootVue [![Build Status](https://travis-ci.org/mamunsrdr/bootvue.svg?branch=master)](https://travis-ci.org/mamunsrdr/bootvue)
A **grails 3** and **vuejs 2** starter project<br>
![Build Status](https://i.imgur.com/IgIkC7Pl.png)

### What's included
* grails: 3.3.1
* vue js: 2.5.2
* vuex: 3.0.1
* vue-resource: 1.3.4
* vue-router: 3.0.1
* vuex-router-sync: 5.0.0
### Project structure
Grails `rest-api` profile is used in this project.<br>
Vue app is placed under `src/app` directory with following modification on `config/index.js`:
```
index: path.resolve(__dirname, '../../main/webapp/index.html'),
assetsRoot: path.resolve(__dirname, '../../main/webapp'),
```
### Gradle plugin and tasks
```
buildscript {
    // ... other configs ...
    dependencies {
        // ... other classpath dependencies ...
        classpath "com.moowork.gradle:gradle-node-plugin:1.2.0"
    }
}
// apply plugin
apply plugin: "com.moowork.node"
```
```
node {
    version = '9.1.0'
    npmVersion = '5.5.1'
    yarnVersion = '1.3.2'
    download = true
    distBaseUrl = 'https://nodejs.org/dist'
    nodeModulesDir = file("src/app")
}

task watchApp(type: YarnTask, dependsOn: 'yarn') {
    group = 'application'
    description = 'Build and watch client side assets'
    args = ['run', 'dev']
}

task buildApp(type: YarnTask, dependsOn: 'yarn') {
    group = 'build'
    description = 'Compile client side assets for production'
    args = ['run', 'build']
}

task testApp(type: YarnTask, dependsOn: 'yarn') {
    group = 'verification'
    description = 'Executes client side unit tests'
    args = ['run', 'unit']
}

bootRun.dependsOn(buildApp)

assetCompile.dependsOn(buildApp)

test.dependsOn(testApp)

clean {
    def ft = fileTree('src/main/webapp').exclude(".gitkeep")
    ft.visit { FileVisitDetails fvd ->
        delete fvd.file
    }
}
```


### Sample command
```
//run this watch command first on terminal
# ./gradlew watchApp
// or for win
# gradlew watchApp

// then start grails application
# grails run-app

// build war file as usual
# grails war
```
[Guide followed](http://guides.grails.org/angular2-combined/guide/index.html). Work is still in-progress. Contributions are welcome.

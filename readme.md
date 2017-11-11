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
    download = true
    nodeModulesDir = file("src/app")
}

task buildAppDev(type: NpmTask, dependsOn: 'npmInstall') {
    group = 'build'
    description = 'Compile client side assets for development'
    args = ['run', 'buildDev']
}

task buildAppProd(type: NpmTask, dependsOn: 'npmInstall') {
    group = 'build'
    description = 'Compile client side assets for production'
    args = ['run', 'buildProd']
}

task testApp(type: NpmTask, dependsOn: 'npmInstall') {
    group = 'verification'
    description = 'Executes client side unit tests'
    args = ['run', 'test']
}

bootRun.dependsOn(buildAppDev)

war.dependsOn(buildApp)

test.dependsOn(testApp)

clean {
    def ft = fileTree('src/main/webapp').exclude(".gitkeep")
    ft.visit { FileVisitDetails fvd ->
        delete fvd.file
    }
}
```


### Sample grails command
```
# grails clean-app
# grails run-app
# grails war
```
[Guide followed](http://guides.grails.org/angular2-combined/guide/index.html). Work is still in-progress. Contributions are welcome.

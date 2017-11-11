# BootVue [![Build Status](https://travis-ci.org/mamunsrdr/bootvue.svg?branch=master)](https://travis-ci.org/mamunsrdr/bootvue)
A **grails 3** and **vuejs 2** starter project
### What's included
* grails: 3.3.1
* vue js: 2.5.2
* vuex: 3.0.1
* vue-router: 3.0.1
* vuex-router-sync: 5.0.0
### Project structure
Grails `rest-api` profile used in the project.<br>
Vue app is placed under `src/app` directory with following modification on `config/index.js`:
```
index: path.resolve(__dirname, '../../main/webapp/index.html'),
assetsRoot: path.resolve(__dirname, '../../main/webapp'),
```
### Sample grails command
```
# grails clean-app
# grails run-app
# grails war
```
[Guide followed](http://guides.grails.org/angular2-combined/guide/index.html). Work is still in-progress. Contributions are welcome.

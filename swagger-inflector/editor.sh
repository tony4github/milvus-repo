#!/usr/bin/env bash
#Jetty runner commented out 
#java -Dconfig=editor/inflector.yaml -jar editor/jetty-runner.jar --port 8000 editor/swagger-editor.war

#tomcat v8.5 runner built locally (webapp-runner.jar) - https://github.com/heroku/webapp-runner
#Local ruuner folder '/Users/milvus-workspace/webapp-runner/'
#Local jar folder '/Users/milvus-workspace/swagger.io/swagger-inflector/editor/'
# 'swagger-editor.war' is basically identical to the one from 'https://github.com/swagger-api/swagger-inflector/tree/master/scripts/bin'
air@Tony webapp-runner % pwd
/Users/milvus-workspace/webapp-runner
air@Tony webapp-runner % java -jar assembly/target/webapp-runner.jar /Users/milvus-workspace/swagger.io/swagger-inflector/editor/swagger-editor.war
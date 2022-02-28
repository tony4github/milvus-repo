So far (Jan 2021), i have found 3 approaches to run swagger-inflector executable - swagger-editor.war

1. Jetty runner - Just follow up the instruction from swagger-inflector gitHub repo below. Pls, start with README.md and editor.sh
        swagger inflector repo : https://github.com/swagger-api/swagger-inflector
        
        swagger inflector blog via Swagger.io : https://swagger.io/blog/api-development/writing-apis-with-the-swagger-inflector/

        swagger inflector tutorial (simple and naive) : https://examples.javacodegeeks.com/swagger-inflector-tutorial/

2. Replace Jetty with tomcat runner, which is called 'webapps-runner' 
    webapp-runner (By Jan 2022, tomcat v8.5) : https://github.com/heroku/webapp-runner

    Built a webapp-runner.jar by 'mvn package'
    
    Then, run this. it works
    'java -jar assembly/target/webapp-runner.jar /Users/milvus-workspace/swagger.io/swagger-inflector/editor/swagger-editor.war'

3. Build tomcat runner via a docker image
    From this gitHub repo, Dockerfile can be found as 'Dockerfile-runner'

    The docker image stays in Docker Hub publicly. Pull the image tag of 'tony4docker2msn/inflector-tomcat-runner:latest'. 
    % docker pull tony4docker2msn/inflector-tomcat-runner:latest   
    % docker run -d -p 8080:8080 tony4docker2msn/inflector-tomcat-runner:latest
    Then, visit the url of http://localhost:8080/

Next, i will try the fourth approach that is to pull 'FROM tomcat:9.0-slim' as a base image. 




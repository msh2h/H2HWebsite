# H2HWebsite
This is the demo project for the renovation of H2H SH administration website.

The H2H website contains multiple modules, including volunteer management, school management and cash book etc.

This website is developed and supported by volunteers of H2H SH.

***
##IDE
For local development, the suggested IDE to use is intellij. You can download the newest community version which is free.

***
##Version Control
We use git for version control. Please download git. Fork below repository.

https://github.com/msh2h/H2HWebsite

Then you can clone the source code to local host, and import it into intellij using gradle.

***
##Local Database Setup
We use postgres. We will set up postgres using docker.

###1. initial set up for postgres using docker

`docker run --name h2h-postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine`

`docker ps`

`docker port h2h-postgres`

`docker exec -it b49c60628f18 bin/bash`

`psql -U postgres`

`REATE DATABASE h2hdb;`

`\c h2hdb`

`\q`

`exit`

###2. start existing postgres on docker

`docker ps -a`

`docker start b49c60628f18`

`docker exec -it b49c60628f18 bin/bash`

`psql -U postgres`

`\c h2hdb`

`#\q`

`exit`

###3. database schema and test data
The database schema is defined in resources/db/migration.

Once application is started, the database schema will be automatically built.

Currently a file, resources/testData.sql keeps the test data. Later we will optimize data storage.

Before load data, you may want to install the extension for uuid generator.

`CREATE EXTENSION IF NOT EXISTS "uuid-ossp";`

***
##Cloud Deployment
We use Aliyun for cloud host.

###1. log in to Aliyun
`ssh root@106.14.132.75`

###2. initial setting

####1) java installation
`scp /[jdkPath]/jdk-8u281-linux-x64.tar.gz root@106.14.132.75:/root/sdk`

The above download link could be obtained when you download jdk from Oracle in chrome.

`tar -zxvf /root/sdk/jdk-8u181-linux-x64.tar.gz`

`vi /etc/environment`

add below to the above file

`export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib`

`export JAVA_HOME=/root/sdk/jdk1.8.0_181`

`source /etc/environment`

`vi /etc/profile`

add below to the beginning of above file

`export JAVA_HOME=/root/sdk/jdk1.8.0_181`

`export JRE_HOME=$JAVA_HOME/jre`

`export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$CLASSPATH`

`export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH`

`source /etc/profile`

####2) docker installation
Refer to below guide.

https://docs.docker.com/engine/install/ubuntu/

####3) database setup
After docker is installed, you can use the same way to set up database as is in local.

####4) set security group of cloud host
Allow access to the 8080 port in TCP.

###3. deploy
Currently we package the application in local host. And then deploy it to the cloud host.
####1) package the application
In intellij, use the gradle to package the application. 

`gradle -> tasks -> build -> build jar`

Then you can find the jar file in build/libs
####2) copy to cloud host
`scp /[jarPath]/[jarFileName] root@106.14.132.75:/usr/yuanjz/application/h2h/demo`

####3) start application
Again ssh to the cloud host and cd to the jar file path.

`java -jar [jarFileName]`

####4) check the application process
`ps -aux | grep java`

####5) keep the application running even after close the shell
Kill the application if it is running.

Write a shell script which starts the application using java -jar command. And make it globally executable (chmod 777).

`nohup [shellScript] &`

The application will be up and running.
# Heroku Notes

## Install Heroku Ubuntu
```
sudo snap install --classic heroku
```

## Create named app
heroku create app137

## Deploy
Did not work with gradle plugin
```
./gradlew apps:things:deployHeroku
```

## Install heroku java plugin
```
heroku plugins:install java
```

## Deploy with java plugin
### Build
```
./gradlew apps:things:clean
./gradlew apps:things:build
```
### Deploy
```
heroku deploy:jar apps/things/build/libs/things-0.0.1-SNAPSHOT.jar --app app137
```

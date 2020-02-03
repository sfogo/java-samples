# Heroku Notes
## Install Heroku Ubuntu
```
sudo snap install --classic heroku
```

# Create named app
heroku create app137

# Deploy
# Did not work with gradle
# ./gradlew apps:things:deployHeroku

## Install heroku java plugin
```
heroku plugins:install java
```

# Deploy
```
heroku deploy:jar apps/things/build/libs/things-0.0.1-SNAPSHOT.jar --app app137
```
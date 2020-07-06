# Nami Backend Application

This is a free time project which supposed to do cool stuff utilising ergast RESTful API as a source for Formula One statistic information.

- **Ergast Developer API:** [API Documentation](https://ergast.com/mrd/)

## Project structure

**TODO**

## How to build and execute

### Build and run docker image
To build docker image execute the following in the sub-project service directory:
```
docker build --build-arg version_param=0.1-XXX --tag nami-backend:01.XXX --tag nami-backend:latest .
```
Be aware of the app version here, it should be the same as its of the JAR file in projects `build` directory

In order to execute the previously built image execute the following: 
```
docker run -p 8080:8080 nami-backend:latest
```

Execute `docker-compose up` to start infrastructure containers
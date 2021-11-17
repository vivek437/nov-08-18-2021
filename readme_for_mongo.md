* Save the following yml in a __docker-compose-mongo.yml__ file

``` yml
version: '3.1'

services:

  mongo:
    image: mongo
    restart: always
    ports:
      - '27017:27017'
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: root

  mongo-express:
    image: mongo-express
    restart: always
    ports:
      - '9090:8081'
    environment:
      ME_CONFIG_MONGODB_SERVER: mongo
      ME_CONFIG_MONGODB_PORT: 27017
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: root
      ME_CONFIG_MONGODB_URL: mongodb://root:root@mongo:27017/

```	  

* Run the following command __docker-compose -f docker-compose-mongo.yml up__
* After the services are started, go to __ http://localhost:9090 __  to view the mongo server on the web


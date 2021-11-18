* Create a repo in Git and add application.yml file with a default message

``` yml
welcome: Default welcome
```

#### Setting up Config Server

* Create a new Spring Boot project say, **MyConfigServer**
* Select **Spring Web**, **Spring Boot actuator** and **Config Server** libraries while creating the project
* Add **@EnableConfigServer** annotation to the **MyConfigServerApplication.java**

* Create **application.properties** file in *resources* folder
* Add the following lines 

``` 

spring.application.name=my-config-server
server.port=8888
management.endpoints.web.exposure.include=*
spring.cloud.config.server.git.uri=https://github.com/prabhu-sunderaraman/my_config_repo.git
spring.cloud.config.server.git.default-label=main

```

* Run http://localhost:8888/application to check

#### Setting up Config Client

* Create a new SpringBoot project __MyConfigClientApp__
* Select _Spring web_, **Spring Boot actuator** and _Config Client_ dependencies
* Add the following line in application.properties

```
spring.application.name=hello-service
spring.config.import=optional:configserver:http://localhost:8888/
management.endpoints.web.exposure.include=*
```

* Create a __HelloController__ class with __@RefreshScope__ and __@RestController__ annotations
* In the __HelloController__ class add the following

```java
	@Value("${welcome: default}")
	private String welcome;
	
	@GetMapping("/hello")
	public String index() {
		return welcome;
	}
```

* Run http://localhost:8080/ and observe the message you get
* Change welcome value to Default welcome message in the config repo and push it
* Run curl -XPOST 'http://localhost:9000/actuator/refresh'
* Run http://localhost:8080/ and observe the message you get


* Now add **hello-service.yml** file to the repo
* Add **welcome: Welcome from server** in this file
* Commit and push

* Run curl -XPOST 'http://localhost:9000/actuator/refresh'
* Run http://localhost:8080/ and observe the message you get


* Now add **hello-service-QA.yml** file to the repo
* Add **welcome: Welcome from QA server** in this file
* Commit and push

* Add __spring.profiles.active=QA__ in application.properties of hello-service
* Restart hello-service and run http://localhost:8080/ and observe the message you get

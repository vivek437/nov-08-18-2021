#### setup kafka in Mac

* brew install kafka
* brew services restart zookeeper
* brew services restart kafka

#### Kafka UI client

* Kafka Tool (Offset Explorer) or Conduktor
* Create a new topic, say __stockbroker__


#### Creating a kafka publisher app

* Create a new Spring boot project __kafka-stock-publisher-app__
* Add __Spring web__, __Spring for Apache Kafka__ dependencies
* Rename __application.properties__ to __application.yml__ file
* Add the following in __application.yml__ file

``` yml
spring:
  kafka:
   bootstrap-servers: localhost:9092
```

* Create __StockSenderController__ class
* Annotate it as __RestController__
* Autowire __KafkaTemplate__ property
* Create an endpoint to accept a stock symbol which sends the symbol to the __stockbroker__ queue

``` java
kafkaTemplate.send("stockbroker", symbol);
```

* Start the server and access the endpoint by passing a symbol say HP, IBM etc.
* Notice the messages in the topic in _conduktor_

#### Creating a kafka consumer app

* Create a new Spring boot project __stock-consumer-app__
* Add __Spring for Apache Kafka__ dependency
* Include the following dependency in pom.xml
``` xml
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-xml</artifactId>
		</dependency>
```

* Rename __application.properties__ to __application.yml__ file
* Add the following in __application.yml__ file


``` yml
spring:
  kafka:
    consumer:
      group-id: consumer-group-training
      auto-offset-reset: earliest
    bootstrap-servers: localhost:9092

```

* Create a class __StockReceiver__
* Create the following method to receive the message and print the stock price (a random number)


``` java

@KafkaListener(topics = "stockbroker")
public void receiveMessage(String symbol) {
	System.out.println("CMP of " + symbol + " is " + (Math.random() * 1000));
}

```


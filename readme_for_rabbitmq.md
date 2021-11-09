# Setting up RabbitMQ

* docker run -d --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
* Go to __http://localhost:15672__
* Login as _guest_, _guest_
* Create a new queue, say __stockbroker__

# Creating a rabbitmq sender app

* Create a new Spring boot project __stock-sender-app__
* Add __Spring web__, __Spring Rabbitmq__ dependencies
* Add the following in __application.properties__

```
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672

```
* Create __StockSenderController__ class
* Annotate it as __RestController__
* Autowire __RabbitTemplate__ property
* Create an endpoint to accept a stock symbol which sends the symbol to the __stockbroker__ queue

``` java
rabbitTemplate.convertAndSend("stockbroker", symbol);
```

* Start the server and access the endpoint by passing a symbol say HP, IBM etc.
* Notice the messages in the queue in RabbitMQ admin console 

# Creating a rabbitmq receiver app

* Create a new Spring boot project __stock-receiver-app__
* Add __Spring Rabbitmq__ dependency
* Add the following in __application.properties__

```
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
```

* Create a class StockReceiver and mark it as a Component
* Create the following method to receive the message and print the stock price (a random number)

``` java
@RabbitListener(queues = "stockbroker")
public void receiveMessage(String symbol) {
	System.out.println("CMP of " + symbol + " is " + (Math.random() * 1000));
}
```

# Exception

* In the receiver app have a condition to check if the stock symbol is say __Polaris__.
* If the symbol is Polaris, throw a custom exception __NotListedException__
* Observe the behavior
* Now add the following in the __application.properties__ and rerun the application and study the behavior

```
spring.rabbitmq.listener.simple.retry.enabled=true
spring.rabbitmq.listener.simple.retry.max-attempts=4
spring.rabbitmq.listener.simple.retry.max-interval=3s

```




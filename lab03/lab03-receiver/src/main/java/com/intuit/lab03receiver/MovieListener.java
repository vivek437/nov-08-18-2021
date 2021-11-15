package com.intuit.lab03receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${omdb.base.url}")
    private String omdbBaseUrl;

    @Value("${movie.exchange}")
    private String movieExchange;

    @Value("${movie.queue-details-routing-key}")
    private String movieQueueDetailsRoutingKey;

    @Value("${movie.queue-error-routing-key}")
    private String movieQueueErrorRoutingKey;

    @RabbitListener(queues = "${movie.queue-input}")
    public void receiveMovieName(String name) {
        String url = omdbBaseUrl + "/" + name;
        ResponseEntity<String> response =  restTemplate.getForEntity(url, String.class);
        //You can add a JSON parser and parse the response
        String body = response.getBody();
        if(body.contains("Movie not found!")) {
            //Pad up the response with more information
            rabbitTemplate.convertAndSend(movieExchange, movieQueueErrorRoutingKey, body);
        } else {
            rabbitTemplate.convertAndSend(movieExchange, movieQueueDetailsRoutingKey, body);
        }

    }


}

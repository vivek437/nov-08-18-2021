package com.intuit.lab03sender;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${movie.exchange}")
    private String movieExchange;

    @Value("${movie.queue-input}")
    private String movieInputQueue;

    @Value("${movie.queue-input-routing-key}")
    private String movieInputQueueRoutingKey;

    private List<String> movieDetailsLst;
    private List<String> errorsLst;

    @PostMapping("/{name}")
    public String postMovieToGetDetails(@PathVariable String name) {
        rabbitTemplate.convertAndSend(movieExchange, movieInputQueueRoutingKey, name);
        return "You'll receive the details for movie " + name + "from /details";
    }

    @GetMapping("/details")
    public List<String> details() {
        return movieDetailsLst;
    }

    @GetMapping("/errors")
    public List<String> errors() {
        return errorsLst;
    }

    //SpEL #{}
    @RabbitListener(queues = "${movie.queue-details}")
    public void receiveMovieDetails(String movieDetails) {
        if(movieDetailsLst == null) {
            movieDetailsLst = new ArrayList<>();
        }
        movieDetailsLst.add(movieDetails);
    }

    @RabbitListener(queues = "${movie.queue-error}")
    public void receiveErrorDetails(String errorDetails) {
        if(errorsLst == null) {
            errorsLst = new ArrayList<>();
        }
        errorsLst.add(errorDetails);
    }
}

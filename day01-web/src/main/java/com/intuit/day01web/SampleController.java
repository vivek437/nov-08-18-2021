package com.intuit.day01web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

@RestController
public class SampleController {

    @GetMapping("/weird")
    public String doSomethingWeird() {
        int i = 10;
        int j = 0;
        int q = i / j;
        return "Cool: " + q;
    }

//    @ExceptionHandler
//    public String handleWeirdException(ArithmeticException ex, WebRequest req) {
//        String message = "Error occured: " + ex.getMessage();
//        return message;
//    }

    @GetMapping("/topics")
    public List<String> getTopicsForTraining() {
        return Arrays.asList("Security", "Messaging", "Cloud config");
    }

    @PostMapping("/info")
    public String submitInfo(@RequestBody TrainingInformation trainingInformation) {
        return trainingInformation.toString();
    }

    @GetMapping("/info")
    public TrainingInformation getInfo() {
        TrainingInformation info = new TrainingInformation();
        info.setName("Spring boot");
        info.setDuration(8);
        info.setTopics(Arrays.asList("Security", "Messaging", "Cloud config"));
        return info;
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Hello!";
    }

    //http://localhost:8080/hi/Sam -> Hi Sam
    @GetMapping("/hi/{name}")
    public String greet(@PathVariable("name") String name) {
        return "Hi " + name;
    }

    @PostMapping("/hello/{name}")
    public String greetWithHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    //http://localhost:8080/bye?name=Ram
    @PutMapping("/bye")
    public String bye(@RequestParam("name") String name) {
        return "Bye bye " + name;
    }

}

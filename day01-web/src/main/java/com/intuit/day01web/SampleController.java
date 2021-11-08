package com.intuit.day01web;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

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

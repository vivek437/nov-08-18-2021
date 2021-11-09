package com.intuit.day02web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class HateoasExampleController {

    @GetMapping("/sum/{num1}/{num2}")
    public HttpEntity<CalcResult> add(@PathVariable int num1, @PathVariable int num2) {
        CalcResult result = new CalcResult();
        result.setResultValue(num1 + num2);
        result.add(linkTo(methodOn(this.getClass()).subtract(num1, num2)).withRel("subtraction"));
        result.add(linkTo(methodOn(this.getClass()).multiply(num1, num2)).withRel("multiplication"));
        result.add(linkTo(methodOn(CalcController.class).divide(num1, num2)).withRel("Division"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/difference/{num1}/{num2}")
    public HttpEntity<CalcResult> subtract(@PathVariable int num1, @PathVariable int num2) {
        CalcResult result = new CalcResult();
        result.setResultValue(num1 - num2);
        result.add(linkTo(methodOn(this.getClass()).add(num1, num2)).withRel("addition"));
        result.add(linkTo(methodOn(this.getClass()).multiply(num1, num2)).withRel("multiplication"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/mul/{num1}/{num2}")
    public HttpEntity<CalcResult> multiply(@PathVariable int num1, @PathVariable int num2) {
        CalcResult result = new CalcResult();
        result.setResultValue(num1 * num2);
        result.add(linkTo(methodOn(this.getClass()).add(num1, num2)).withRel("addition"));
        result.add(linkTo(methodOn(this.getClass()).subtract(num1, num2)).withRel("subtraction"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

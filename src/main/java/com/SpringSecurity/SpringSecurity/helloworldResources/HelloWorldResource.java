package com.SpringSecurity.SpringSecurity.helloworldResources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
    @GetMapping("/hello-world")
    public String hellowrld(){
        return "Hello-world";
    }

}

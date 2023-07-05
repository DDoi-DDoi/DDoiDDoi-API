package com.tpa.toyproject_api.Test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/t1")
    public String test1(){

        return "t1";
    }


}

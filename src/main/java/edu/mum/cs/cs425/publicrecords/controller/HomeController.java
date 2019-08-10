package edu.mum.cs.cs425.publicrecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/publicrecords/home")
    public String displayHomePage(){
        return "home/index";
    }
}

package com.dmz.authing.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/main/index")
    private String main() {
        return "main";
    }
}

package com.Nail.spring_course.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false)String name,
                            @RequestParam(value = "surName", required = false)String surName, Model model) {

        //System.out.println("Hello " + name + " " + surName);

        model.addAttribute("message", "Hello " + " " + name + " " + surName);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/multiplication")
    public String multiply(@RequestParam(value = "a", required = false)int a,
                           @RequestParam(value = "b", required = false)int b, Model model) {
        model.addAttribute("Result " + a * b);
        return "first/multiplication";
    }

    @GetMapping("/addition")
    public String add(@RequestParam(value = "a", required = false)int a,
                      @RequestParam(value = "b", required = false)int b, Model model) {
        model.addAttribute("Result " + a + b);
        return "first/addition";
    }

    @GetMapping("/substraction")
    public String substract(@RequestParam(value = "a", required = false)int a,
                            @RequestParam(value = "b", required = false)int b, Model model) {
        model.addAttribute("Result " + (a - b));
        return "first/substraction";
    }

    @GetMapping("/division")
    public String divide(@RequestParam(value = "a", required = false)int a,
                         @RequestParam(value = "b", required = false)int b, Model model) {
        model.addAttribute("Result " + a / b);
        return "first/division";
    }

    @GetMapping("/calculator")
    public String divide(@RequestParam(value = "a", required = false)int a,
                         @RequestParam(value = "b", required = false)int b, @RequestParam(value = "action", required = false) String action, Model model) {
        int result = 0;
        switch(action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "substraction":
                result = a - b;
                break;
            case "division":
                result = a / b;

        }

        model.addAttribute("message", "Result " + action + " = " + result);
        return "first/calculator";
    }

}

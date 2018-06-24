package com.odde.guess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @GetMapping
    public ModelAndView rooms(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @GetMapping("/create")
    public String createRoom() {
        return "/rooms/create";
    }

    @PostMapping("/create")
    public String submitCreateRoom() {
        return "redirect:/rooms/show";
    }

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("/rooms/show");
        modelAndView.addObject("message","");
        return modelAndView;
    }

    @PostMapping("/show")
    public ModelAndView guess() {
        ModelAndView modelAndView = new ModelAndView("/rooms/show");
        modelAndView.addObject("message","You Win!");
        return modelAndView;

    }
}

package com.odde.guess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RoomController {
    @GetMapping("/")
    public ModelAndView rooms(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/rooms/index");
        return view;
    }

    @GetMapping("/rooms/create")
    public String createRoom() {
        return "rooms/create";
    }

    @PostMapping("/rooms/create")
    public String submitCreateRoom() {
        return "redirect:/rooms/show";
    }

    @GetMapping("/rooms/show")
    public String show() {
        return "/rooms/show";
    }

}

package com.odde.guess.controller;

import com.odde.guess.model.Room;
import com.odde.guess.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private static final String WIN_MESSAGE = "You Win!";
    private final RoomRepository repo;

    @Autowired
    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ModelAndView rooms(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/rooms/index");
        return view;
    }

    @GetMapping("/create")
    public String createRoom() {
        return "/rooms/create";
    }

    @PostMapping("/create")
    public String submitCreateRoom(String secret) {
        Room room = repo.save(new Room(secret));
        return "redirect:/rooms/show/" + room.getId();
    }


    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable("id") String id) {
        return showMessage(emptyList());
    }

    @PostMapping("/show/{id}")
    public ModelAndView guess(@PathVariable("id") long id, String guess) {
        Room room = repo.findById(id);
        boolean win = room.isWin(guess);
        List<String> logs = new ArrayList<>(room.getLogs());
        if (win) {
            logs.add(WIN_MESSAGE);
        }
        repo.save(room);
        return showMessage(logs);
    }

    private ModelAndView showMessage(List<String> logs) {
        ModelAndView modelAndView = new ModelAndView("/rooms/show");
        Collections.reverse(logs);
        modelAndView.addObject("message", logs);
        return modelAndView;
    }
}

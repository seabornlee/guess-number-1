package com.odde.guess.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

public class RoomControllerTest {

    @Test
    public void rooms_should_go_to_index_page() {
        RoomController controller = new RoomController();

        ModelAndView view = controller.rooms();

        assertThat(view.getViewName()).isEqualTo("/rooms/index");
    }

}
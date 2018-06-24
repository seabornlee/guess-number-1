package com.odde.guess.controller;

import com.odde.guess.repo.Room;
import com.odde.guess.repo.RoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class RoomControllerTest {
    private RoomRepository repo = Mockito.mock(RoomRepository.class);
    private RoomController controller = new RoomController(repo);

    @Test
    public void rooms_should_go_to_index_page() {
        ModelAndView view = controller.rooms();
        assertThat(view.getViewName()).isEqualTo("/rooms/index");
    }

    @Test
    public void create_room(){
        String secret = "1234";
        controller.submitCreateRoom(secret);
        ArgumentCaptor<Room> captor = ArgumentCaptor.forClass(Room.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().getSecret()).isEqualTo(secret);
    }

}
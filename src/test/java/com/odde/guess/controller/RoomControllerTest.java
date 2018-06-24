package com.odde.guess.controller;

import com.odde.guess.repo.Room;
import com.odde.guess.repo.RoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoomControllerTest {
    private RoomRepository repo = Mockito.mock(RoomRepository.class);
    private RoomController controller = new RoomController(repo);

    @Test
    public void rooms_should_go_to_index_page() {
        ModelAndView view = controller.rooms();
        assertThat(view.getViewName()).isEqualTo("/rooms/index");
    }

    private void willReturnSavedRoomWithId(final int id) {
        when(repo.save(any(Room.class))).thenReturn(new Room("1234") {{setId(id);}});
    }

    @Test
    public void create_room(){
        willReturnSavedRoomWithId(1);

        controller.submitCreateRoom("1234");

        ArgumentCaptor<Room> captor = ArgumentCaptor.forClass(Room.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().getSecret()).isEqualTo("1234");
    }

    @Test
    void show_room_after_creation() {
        willReturnSavedRoomWithId(1);

        String view = controller.submitCreateRoom("1234");

        assertThat(view).isEqualToIgnoringCase("redirect:/rooms/1");

    }
}
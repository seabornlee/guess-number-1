package com.odde.guess.controller;

import com.odde.guess.model.Room;
import com.odde.guess.repo.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class RoomControllerTest {
    private RoomRepository repo = mock(RoomRepository.class);
    private RoomController controller = new RoomController(repo);
    private Room room = mock(Room.class);

    @Test
    public void rooms_should_go_to_index_page() {
        ModelAndView view = controller.rooms();
        assertThat(view.getViewName()).isEqualTo("/rooms/index");
    }

    @Test
    public void create_room() {
        willReturnSavedRoomWithId(1);

        controller.submitCreateRoom("1234");

        verify(repo).save(argThat(room -> "1234".equals(room.getSecret())));
    }

    @Test
    public void show_room_after_creation() {
        willReturnSavedRoomWithId(1);

        String view = controller.submitCreateRoom("1234");

        assertThat(view).isEqualToIgnoringCase("redirect:/rooms/show/1");
    }

    @Test
    public void show_result() {
        when(repo.findById(1)).thenReturn(room);
        when(room.verify(anyString())).thenReturn("Result");


        ModelAndView view = controller.guess(1, "5678");

        assertThat(view.getModelMap().get("message")).isEqualTo("Result");
    }

    @Test
    void show_win_result() {

        when(repo.findById(1)).thenReturn(room);
        when(room.verify(anyString())).thenReturn("4A0B");

        ModelAndView view = controller.guess(1, "5678");

        assertThat(view.getModelMap().get("message")).isEqualTo("You Win!");
    }

    private void willReturnSavedRoomWithId(int id) {
        when(repo.save(any(Room.class))).thenReturn(new Room("1234") {{
            setId(id);
        }});
    }
}
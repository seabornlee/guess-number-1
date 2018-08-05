package com.odde.guess.service;

import com.odde.guess.repo.Room;
import com.odde.guess.repo.RoomRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VerifyServiceTest {

    RoomRepository repo = mock(RoomRepository.class);
    VerifyService verifyService = new VerifyService(repo);

    @Test
    public void guess_win() {
        verifyGuess("4A0B", "1234", "1234");
    }

    @Test
    public void guess_wrong() {
        verifyGuess("0A0B", "1234", "5678");
    }

    private void verifyGuess(String expectResult, String secret, String guess) {
        when(repo.findById(1)).thenReturn(new Room(secret));

        String result = verifyService.verify(1, guess);

        assertThat(result).isEqualTo(expectResult);
    }

}
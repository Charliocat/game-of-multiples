package com.charliocat.game.server;

import com.charliocat.game.core.GameEngine;
import com.charliocat.game.io.IOConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MultiplesGameServiceTest {

    @Mock
    private IOConsole console;

    @Mock
    private GameEngine gameEngine;

    private MultiplesGameService multiplesGameService;

    @Captor
    private ArgumentCaptor<String> output;

    @BeforeEach
    void setUp() {
        when(gameEngine.isRunning()).thenAnswer(new Answer<Boolean>() {
            private int count = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) {
                return count++ == 0;
            }
        });

        multiplesGameService = MultiplesGameService.builder()
                .withGameEngine(gameEngine)
                .withConsole(console)
                .build();
    }

    @Test
    void exitCommandExitsGame() {
        when(gameEngine.isRunning()).thenReturn(true);
        when(console.readNext()).thenReturn("exit");

        multiplesGameService.run();
        verify(console, times(5)).write(output.capture());

        assertEquals(output.getValue(), "Thanks for playing!");
    }

    @Test
    void hintCommandPrintsGameValues() {
        int[] gameValues = new int[]{1, 5, 7};
        when(gameEngine.getGameValues()).thenReturn(gameValues);
        when(console.readNext()).thenReturn("hint");

        multiplesGameService.run();
        verify(console, times(5)).write(output.capture());

        assertEquals(output.getValue(), Arrays.toString(gameValues));
    }

    @Test
    void playAndWinGame() {
        when(console.readNext()).thenReturn("1");
        when(gameEngine.play("1")).thenReturn("win");

        multiplesGameService.run();
        verify(console, times(5)).write(output.capture());

        assertEquals(output.getValue(), "win");
    }

    @Test
    void writeErrorWhenNotAValidInput() {
        when(console.readNext()).thenReturn("invalidInput");
        when(gameEngine.play("invalidInput")).thenThrow(new RuntimeException("Invalid input"));

        multiplesGameService.run();
        verify(console, times(5)).write(output.capture());

        assertEquals(output.getValue(), "Invalid input");
    }

}

package com.shridhar.SpeakingClock.service;


import com.shridhar.SpeakingClock.exceptions.InvalidTimeFormatException;
import com.shridhar.SpeakingClock.proccessor.Speakingclock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SpeakingclockServiceTest {

    @Mock
    private Speakingclock speakingclock;

    @InjectMocks
    private SpeakingclockService speakingclockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void timeINWords() {
        String time = "00:00";
        when(speakingclock.currentTime()).thenReturn(time);
        String response = speakingclockService.timeINWords();
        assertEquals("It's Zero Hours and Zero Minutes It's Midnight",response);
    }
    @Test
    void timeINWords1() {
        String time = "12:00";
        when(speakingclock.currentTime()).thenReturn(time);
        String response = speakingclockService.timeINWords();
        assertEquals("It's Twelve Zero It's MidNoon",response);
    }
    @Test
    void timeINWords2() {
        String time = "13:20";
        when(speakingclock.currentTime()).thenReturn(time);
        String response = speakingclockService.timeINWords();
        assertEquals("It's thirteen twenty",response);
    }
    @Test
    void timeINWords3() {
        String time = "23:11:55";
        when(speakingclock.currentTime()).thenReturn(time);
        assertThrows(InvalidTimeFormatException.class,()->{
              speakingclockService.timeINWords();
        });
    }

    @Test
    void convertToWords() {
        String response = speakingclockService.convertToWords("40");
        assertEquals("forty",response);
    }
    @Test
    void convertToWords1() {
        String response = speakingclockService.convertToWords("15");
        assertEquals("fifteen",response);
    }
    @Test
    void convertToWords2() {
        String response = speakingclockService.convertToWords("3");
        assertEquals("three",response);
    }

    @Test
    void proccessor() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(4);
        ArrayList<Integer> response = speakingclockService.proccessor("34");
        assertEquals(integers,response);
    }

    @Test
    void proccessor1() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(5);
        ArrayList<Integer> response = speakingclockService.proccessor("55");
        assertEquals(integers,response);
    }
}
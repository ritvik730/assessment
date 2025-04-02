package com.wisdomleaf.assessment.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TimeToWordsServiceTest {
    
    private TimeToWordsService timeToWordsService;

    @BeforeEach
    void setUp() {
        timeToWordsService = new TimeToWordsService();
    }

    @Test
    void testMidnight() {
        assertEquals("It's Midnight", timeToWordsService.convertTimeToWords("00:00"));
    }

    @Test
    void testMidday() {
        assertEquals("It's Midday", timeToWordsService.convertTimeToWords("12:00"));
    }

    @Test
    void testExactHour() {
        assertEquals("It's eight o'clock", timeToWordsService.convertTimeToWords("08:00"));
    }

    @Test
    void testThirtyMinutes() {
        assertEquals("It's eight thirty", timeToWordsService.convertTimeToWords("08:30"));
    }

    @Test
    void testMinutesBelowThirty() {
        assertEquals("It's nine fifteen", timeToWordsService.convertTimeToWords("09:15"));
    }

    @Test
    void testMinutesAboveThirty() {
        assertEquals("It's ten forty five", timeToWordsService.convertTimeToWords("10:45"));
    }

    @Test
    void testInvalidTimeFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            timeToWordsService.convertTimeToWords("25:00");
        });
        assertEquals("Invalid hour value. Hour should be between 00 and 23.", exception.getMessage());
    }

    @Test
    void testInvalidCharactersInTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            timeToWordsService.convertTimeToWords("abcd");
        });
        assertEquals("Invalid time format. Expected HH:mm", exception.getMessage());
    }

    @Test
    void testInvalidMinuteValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            timeToWordsService.convertTimeToWords("11:62");
        });
        assertEquals("Invalid minute value. Minutes should be between 00 and 59.", exception.getMessage());
    }

}

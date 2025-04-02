package com.wisdomleaf.assessment.service;

import org.springframework.stereotype.Service;

@Service
public class TimeToWordsService {
    private static final String[] HOURS = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
    private static final String[] MINUTES = {"o'clock", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};

    public String convertTimeToWords(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid time format. Expected HH:mm");
        }
    
        String[] parts = time.split(":");
        int hour;
        try {
            hour = Integer.parseInt(parts[0]);
            if (hour < 0 || hour > 23) {
                throw new IllegalArgumentException("Invalid hour value. Hour should be between 00 and 23.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid hour format. Expected a number between 00-23.");
        }
        int minute;
        try {
            minute = Integer.parseInt(parts[1]);
            if (minute < 0 || minute > 59) {
                throw new IllegalArgumentException("Invalid minute value. Minutes should be between 00 and 59.");
            }
            
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid minute format. Expected a number between 00-59.");
        }
    
        if (hour == 0 && minute == 0) return "It's Midnight";
        if (hour == 12 && minute == 0) return "It's Midday";
    
        String hourInWords = HOURS[hour % 12];
        String minuteInWords;
    
        if (minute == 0) {
            minuteInWords = "o'clock";
        } else if (minute < 30) {
            minuteInWords = MINUTES[minute];
        } else if (minute == 30) {
            minuteInWords = "thirty";
        } else {
            // For minutes between 31-59, get correct word mapping
            String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty"};
            int tens = minute / 10;
            int ones = minute % 10;
    
            String tensWord = TENS[tens];
            String onesWord = MINUTES[ones];
    
            minuteInWords = tensWord + " " + onesWord;
        }
    
        return "It's " + hourInWords + " " + minuteInWords;
    }
    
}
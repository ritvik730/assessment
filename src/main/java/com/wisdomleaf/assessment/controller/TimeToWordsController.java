package com.wisdomleaf.assessment.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.wisdomleaf.assessment.service.TimeToWordsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
@Tag(name = "Time Conversion API", description = "Convert 24-hour time format into words")
//@Api(value = "Time Conversion API", tags = "Time Converter")
class TimeToWordsController {
    private final TimeToWordsService timeToWordsService;

    public TimeToWordsController(TimeToWordsService timeToWordsService) {
        this.timeToWordsService = timeToWordsService;
    }

    @GetMapping("/current")
    @Operation(summary = "Get current time in words")
    public ResponseEntity<String> getCurrentTimeInWords() {
        String timeInWords = timeToWordsService.convertTimeToWords(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        return ResponseEntity.ok(timeInWords);
    }

    @GetMapping("/convert/{time}")
    @Operation(summary = "Convert user-provided time to words")
    public ResponseEntity<String> convertTime(@PathVariable String time) {
        return ResponseEntity.ok(timeToWordsService.convertTimeToWords(time));
    }
}
package com.wellsfargo.pronounce.web.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.pronounce.core.service.ITextToSpeechService;

@CrossOrigin
@RestController
@RequestMapping("text-to-speech")
public class TextToSpeechController {

    @Autowired
    private ITextToSpeechService textToSpeechService;

    @GetMapping("/{inputText}")
    public void getVoiceOutput(@PathVariable("inputText") final String inputText) {
        textToSpeechService.getVoiceOutput(inputText);

    }

}
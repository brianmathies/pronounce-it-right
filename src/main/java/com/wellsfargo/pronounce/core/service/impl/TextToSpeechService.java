package com.wellsfargo.pronounce.core.service.impl;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.springframework.stereotype.Service;

import com.wellsfargo.pronounce.core.service.ITextToSpeechService;

@Service
public class TextToSpeechService implements ITextToSpeechService {

    @Override
    public void getVoiceOutput(String inputText) {
        try {

            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText(inputText, null);

        }

        catch (EngineException ee) {
            // TODO - Add logger
        } catch (AudioException ae) {
            // TODO - Add logger
        }

    }

}
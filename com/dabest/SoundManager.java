package com.dabest;
import java.io.File;
import javax.sound.sampled.*;

public class SoundManager {
    
    public void playButton() {
        PlayMusic("src/sounds/buttonpress.wav");
    }

    public void PlayMusic(String FilePath) {
        try {
            File musicPath = new File(FilePath);

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File cannot be found");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
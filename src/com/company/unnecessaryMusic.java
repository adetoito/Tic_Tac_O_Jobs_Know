package com.company;

import sun.audio.*;
import java.io.*;

public class unnecessaryMusic {

    // Because why not.

    public static void totallyUnnecessaryMusicPlayingInTheBackgroundBecauseIFeltLikeIt () {

        AudioPlayer player = AudioPlayer.player;
        AudioStream stream;
        InputStream input;
        try {
            input = new FileInputStream("Machinimasound - Escape from the Temple.wav");
            stream = new AudioStream(input);
            player.start(stream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

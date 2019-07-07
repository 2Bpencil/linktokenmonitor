package com.tyf.linktokenmonitor.code.utils;


import javazoom.jl.player.Player;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class MusicUtil {
    private Player player;
    public  void play() {
        Resource resource =  new ClassPathResource("static/assets/music/apple.mp3");
        try {
            InputStream is = resource.getInputStream();
            BufferedInputStream buffer = new BufferedInputStream(is);
            player = new Player(buffer);
            player.play();

        } catch (Exception e) {
            System.out.println(e);
        }
    }




}

package com.Nail.spring_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        TypeMusic[] types = TypeMusic.values();
        int type = (int)(Math.floor(Math.random() * 3));
        return "Computer{" +
                "id=" + id + ", musicType=" + types[type] + ", musicPlayer=" + musicPlayer.playMusic(types[type]) +
                '}';
    }
}

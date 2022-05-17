package com.Nail.spring_course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
            //Music music = context.getBean("musicBean", Music.class);

            //MusicPlayer player = new MusicPlayer(music);

            MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);

            player.playMusic();
        }
    }
}

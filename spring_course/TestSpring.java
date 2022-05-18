package com.Nail.spring_course;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {

//            Music rockMusic = context.getBean("rockMusic", Music.class);
//            MusicPlayer rockMusicPlayer = new MusicPlayer(rockMusic);
//            rockMusicPlayer.playMusic();
//
//            Music rapMusic = context.getBean("rapMusic", Music.class);
//            MusicPlayer rapMusicPlayer = new MusicPlayer(rapMusic);
//            rapMusicPlayer.playMusic();

//            Music classicalMusic = context.getBean("classicalMusic", Music.class);
//            MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//            musicPlayer.playMusic();

//            Computer computer = context.getBean("computer", Computer.class);
//            System.out.println(computer);
//            Computer computer = context.getBean("computer", Computer.class);
//            System.out.println(computer.toString());

            MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);

            System.out.println(player.getName());
            System.out.println(player.getVolume());

            ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
//            ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);


        }
    }
}

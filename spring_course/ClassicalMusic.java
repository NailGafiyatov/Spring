package com.Nail.spring_course;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private List<String> songList = new ArrayList<String>();

    {
        songList.add("Eine kleine Nachtmusik");
        songList.add("Für Elise");
        songList.add("O mio babbino caro' from Gianni Schicchi");
    }

    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    @PostConstruct
    public void doMyInIt() {
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return songList.get((int)(Math.floor(Math.random() * 3)));
    }
}

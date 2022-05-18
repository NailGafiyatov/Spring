package com.Nail.spring_course;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music {
    private List<String> songList = new ArrayList<String>();

    {
        songList.add("Wind cries Mary");
        songList.add("Rock With you");
        songList.add("Rock you Like a Hurricane");
    }

    @Override
    public String getSong() {
        return songList.get((int)(Math.floor(Math.random() * 3)));
    }
}

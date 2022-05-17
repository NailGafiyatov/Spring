package com.Nail.spring_course;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RapMusic implements Music {
    private List<String> songList = new ArrayList<String>();

    {
        songList.add("Cars With the Boom");
        songList.add("Get Low");
        songList.add("Paper Planes");
    }
    @Override
    public String getSong() {
        return songList.get((int)(Math.floor(Math.random() * 3)));
    }
}

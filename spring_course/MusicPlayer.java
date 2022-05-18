package com.Nail.spring_course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private Music classicalMusic;
    private Music rockMusic;
    private Music rapMusic;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic, @Qualifier("rockMusic") Music rockMusic,@Qualifier("rapMusic") Music rapMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.rapMusic = rapMusic;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic(Enum e) {
        if (TypeMusic.CLASSICAL.equals(e)) {
            return "Playing " + classicalMusic.getSong();
        } else if (TypeMusic.RAP.equals(e)) {
            return "Playing " + rapMusic.getSong();
        } else if (TypeMusic.ROCK.equals(e)) {
            return "Playing " + rockMusic.getSong();
        }
        return null;
    }
}

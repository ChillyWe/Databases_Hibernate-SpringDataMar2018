package p11;

import java.util.ArrayList;
import java.util.List;

public class Radio {
    private List<Song> songs;
    private int time;

    public Radio() {
        this.songs = new ArrayList<>();
        this.time = 0;
    }

    public String addSongs(Song song) {
        this.songs.add(song);
        this.setTime(song.getMin(), song.getSec());
        return "Song added.";
    }

    private void setTime(int min, int sec) {
        this.time += (min * 60);
        this.time += sec;
    }

    public int getTime() {
        return this.time;
    }

    public int getSongsSize() {
        return this.songs.size();
    }
}
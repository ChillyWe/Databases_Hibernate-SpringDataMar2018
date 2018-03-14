package p11;

import p11.exceptions.*;

import java.util.Arrays;

public class Song {
    private String artistName;
    private String name;
    private String length;
    private int min;
    private int sec;

    public Song(String artistName, String name, String length) throws InvalidSongException {
        this.setArtistName(artistName);
        this.setName(name);
        this.setLength(length);
    }

    public int getMin() {
        return this.min;
    }

    public int getSec() {
        return this.sec;
    }

    private void setName(String name) throws InvalidSongNameException {
        if (name.length() <= 3 || name.length() >= 30) {
            throw new InvalidSongNameException();
        }
        this.name = name;
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() <= 3 || artistName.length() >= 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private void setMin(int min) throws InvalidSongMinutesException {
        if (min < 0 || min > 14) {
            throw new InvalidSongMinutesException();
        }
        this.min = min;
    }

    private void setSec(int sec) throws InvalidSongSecondsException {
        if (sec < 0 || sec > 59) {
            throw new InvalidSongSecondsException();
        }
        this.sec = sec;
    }

    private void setLength(String length) throws InvalidSongLengthException {
        int[] timeTokens = Arrays.stream(length.split(":")).mapToInt(Integer::parseInt).toArray();

        this.setMin(timeTokens[0]);
        this.setSec(timeTokens[1]);

        this.length = length;
    }
}
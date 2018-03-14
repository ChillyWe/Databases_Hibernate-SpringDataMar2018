package p11;

import p11.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Radio radio = new Radio();

        int numberOfSongs = Integer.parseInt(reader.readLine());


            for (int i = 0; i < numberOfSongs; i++) {
                try {
                    String[] tokens = reader.readLine().split(";");
                    Song song = new Song(tokens[0], tokens[1], tokens[2]);
                    System.out.println(radio.addSongs(song));
                } catch (InvalidSongException ise) {
                    System.out.println(ise.getMessage());
                }
            }
        System.out.println(String.format("Songs added: %d", radio.getSongsSize()));
        System.out.println(String.format("Playlist length: %dh %dm %ds", (radio.getTime()/ 60) / 60,
                (radio.getTime() / 60) % 60 , radio.getTime() % 60));
    }
}
package p11.exceptions;

public class InvalidSongException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid song.";
    }
}
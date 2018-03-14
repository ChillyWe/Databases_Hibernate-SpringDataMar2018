package p11.exceptions;

public class InvalidSongNameException extends InvalidSongException {
    @Override
    public String getMessage() {
        return "Song name should be between 3 and 30 symbols.";
    }
}
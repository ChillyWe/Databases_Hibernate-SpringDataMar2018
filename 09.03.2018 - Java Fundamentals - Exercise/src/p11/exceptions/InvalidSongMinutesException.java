package p11.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    @Override
    public String getMessage() {
        return "Song minutes should be between 0 and 14.";
    }
}
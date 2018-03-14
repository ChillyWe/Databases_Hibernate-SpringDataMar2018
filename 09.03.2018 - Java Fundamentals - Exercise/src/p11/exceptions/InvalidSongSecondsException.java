package p11.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    @Override
    public String getMessage() {
        return "Song seconds should be between 0 and 59.";
    }
}
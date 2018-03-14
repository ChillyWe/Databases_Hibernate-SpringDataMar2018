package p11.exceptions;

public class InvalidSongLengthException extends InvalidSongException {
    @Override
    public String getMessage() {
        return "Invalid song length.";
    }
}
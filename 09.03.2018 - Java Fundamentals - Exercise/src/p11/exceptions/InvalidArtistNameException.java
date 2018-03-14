package p11.exceptions;

public class InvalidArtistNameException extends InvalidSongException {
    @Override
    public String getMessage() {
        return "Artist name should be between 3 and 20 symbols.";
    }
}
package dev.rishit.vibecoder.exceptions;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super("User Not Found. Email: " + message);
    }
}

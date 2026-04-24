package dev.rishit.vibecoder.exceptions;

public class ProjectNotFoundException extends NotFoundException {
    public ProjectNotFoundException(String message) {
        super("Project Not Found. Project ID: " + message);
    }
}

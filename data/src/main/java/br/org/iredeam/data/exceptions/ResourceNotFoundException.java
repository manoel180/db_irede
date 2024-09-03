package br.org.iredeam.data.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id, String resourceName) {
        super(String.format("Resource not found! Id: %s, Type: %s", id, resourceName));
    }

    public ResourceNotFoundException() {
    }
}
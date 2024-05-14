package com.blogapplication.app.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String resourceField;
    Long resourceId;

    public ResourceNotFoundException(String resourceName, String resourceField, Long resourceId) {
        super(String.format("%s does not exist with %s as %s",resourceName,resourceField,resourceId));
        this.resourceName = resourceName;
        this.resourceField = resourceField;
        this.resourceId = resourceId;
    }
}

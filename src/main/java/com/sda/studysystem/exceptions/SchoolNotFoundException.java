package com.sda.studysystem.exceptions;

import java.util.UUID;

/**
 * Exception for the school not found by ID
 *
 * @author Marek Uibo
 */
public class SchoolNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public SchoolNotFoundException(UUID id) {
        super(String.format("School not found for id: %s", id));
    }

    public SchoolNotFoundException(String name) {
        super(String.format("School not found for name: %s", name));
    }
}


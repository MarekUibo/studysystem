package com.sda.studysystem.exceptions;

import java.util.UUID;

public class TeacherNotFoundException extends Throwable {
    public TeacherNotFoundException(UUID id){
        super(String.format("Teacher not found for id : %d", id));
    }
}

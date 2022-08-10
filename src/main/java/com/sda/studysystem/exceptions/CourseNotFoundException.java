package com.sda.studysystem.exceptions;

import java.util.UUID;

public class CourseNotFoundException extends Exception{

    public CourseNotFoundException(UUID id){
        super(String.format("Course not found for id :%d", id));
    }
}

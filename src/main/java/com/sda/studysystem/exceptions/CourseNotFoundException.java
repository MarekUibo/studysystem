package com.sda.studysystem.exceptions;

public class CourseNotFoundException extends Exception{

    public CourseNotFoundException(Long id){
        super(String.format("Course not found for id :%d", id));
    }
}

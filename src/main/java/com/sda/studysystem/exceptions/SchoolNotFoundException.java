package com.sda.studysystem.exceptions;

import com.sda.studysystem.models.School;

public class SchoolNotFoundException extends Exception{
    public SchoolNotFoundException(Long id){
        super(String.format("School not found for id : %d", id));
    }
}

package com.sda.studysystem.services;


import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;

import java.util.List;

/**
 * School service
 */
public interface SchoolService {

    void createSchool(School school);

    School findSchoolById(Long id) throws SchoolNotFoundException;

    List<School> findAllSchools();

    void updateSchool(School school) throws SchoolNotFoundException;

    void deleteSchoolById(Long id) throws SchoolNotFoundException;

    void restoreSchoolById(Long id) throws SchoolNotFoundException;

}

package com.sda.studysystem.services;


import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Teacher;

import java.util.List;

public interface TeacherService {
    void createTeacher(Teacher teacher);

    Teacher findTeacherById(Long id) throws TeacherNotFoundException;

    List<Teacher>findAllTeachers();

    void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

    void deleteTeacherById(Long Id) throws TeacherNotFoundException;

    void restoreTeacherById(Long Id) throws TeacherNotFoundException;


}

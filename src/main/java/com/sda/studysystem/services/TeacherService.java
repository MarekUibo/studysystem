package com.sda.studysystem.services;


import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    void createTeacher(Teacher teacher);

    Teacher findTeacherById(UUID id) throws TeacherNotFoundException;

    Teacher findTeacherByIdCode(String idCode) throws TeacherNotFoundException;

    List<Teacher>findAllTeachers();

    void updateTeacher(Teacher teacher) throws TeacherNotFoundException;

    void deleteTeacherById(UUID id) throws TeacherNotFoundException;

    void restoreTeacherById(UUID id) throws TeacherNotFoundException;


}

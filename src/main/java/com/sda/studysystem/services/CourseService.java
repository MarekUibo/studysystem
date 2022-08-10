package com.sda.studysystem.services;


import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.models.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    void createCourse(Course course);

    Course findCourseById(UUID id) throws CourseNotFoundException;

    List<Course> findAllCourses();

    void updateCourse(Course course) throws CourseNotFoundException;

    void deleteCourseById(UUID id) throws CourseNotFoundException;

    void restoreCourseById(UUID id) throws CourseNotFoundException;
}

package com.sda.studysystem.services;


import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.models.Course;

import java.util.List;

public interface CourseService {
    void createCourse(Course course);

    Course findCourseById(Long id) throws CourseNotFoundException;

    List<Course> findAllCourses();

    void updateCourse(Course course) throws CourseNotFoundException;

    void deleteCourseById(Long id) throws CourseNotFoundException;

    void restoreCourseById(Long id) throws CourseNotFoundException;
}

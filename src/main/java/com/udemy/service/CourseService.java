package com.udemy.service;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

import java.util.List;

/**
 * Created by Jorge on 3/1/17.
 */
public interface CourseService {

    public abstract List<CourseModel> listAllCourses();
    public abstract CourseModel addCourse(CourseModel courseModel);
    public abstract int removeCourse(CourseModel courseModel);
    public abstract CourseModel updateCourse(CourseModel courseModel);

}

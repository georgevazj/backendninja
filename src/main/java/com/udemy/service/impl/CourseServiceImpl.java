package com.udemy.service.impl;

import com.udemy.controller.CourseController;
import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jorge on 3/1/17.
 */

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);


    @Override
    public List<Course> listAllCourses() {
        LOG.info("Call: " + "listAllCourses() ");
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: " + "addCourse() ");
        return courseJpaRepository.save(course);
    }

    @Override
    public int removeCourse(int id) {
        courseJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Course updateCourse(Course course) {
        //Si esta creado el registro con un ID lo sustituye con el nuevo
        return courseJpaRepository.save(course);
    }
}

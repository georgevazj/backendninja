package com.udemy.service.impl;

import com.udemy.controller.CourseController;
import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 3/1/17.
 */

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    @Autowired
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);


    @Override
    public List<CourseModel> listAllCourses() {
        LOG.info("Call: " + "listAllCourses() ");
        List<CourseModel> courseModels = new ArrayList<>();
        for (Course course:courseJpaRepository.findAll()){
            CourseModel courseModel = courseConverter.entity2model(course);
            courseModels.add(courseModel);
        }
        return courseModels;
    }

    @Override
    public CourseModel addCourse(CourseModel courseModel) {
        LOG.info("Service: " + "addCourse() ");
        Course course = courseConverter.model2entity(courseModel);
        LOG.info("Course to add -- " + course.toString());
        courseJpaRepository.save(course);
        return courseConverter.entity2model(course);
    }

    @Override
    public int removeCourse(CourseModel courseModel) {
        LOG.info("Service: " + "removeCourse() ");
        Course course = courseConverter.model2entity(courseModel);
        course.setId(courseJpaRepository.findByName(courseModel.getName()).getId());
        LOG.info("Course content -- " + course.toString());
        courseJpaRepository.delete(course.getId());
        return 0;
    }

    @Override
    public CourseModel updateCourse(CourseModel courseModel) {
        //Si esta creado el registro con un ID lo sustituye con el nuevo
        LOG.info("Service: " + "updateCourse() -- PARAM: " + courseModel.toString());
        Course course = courseConverter.model2entity(courseModel);
        course.setId(courseJpaRepository.findByName(courseModel.getName()).getId());
        LOG.info("Course -- PARAM: " + course.toString());
        courseJpaRepository.save(course);
        return courseModel;
    }
}

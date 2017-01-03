package com.udemy.controller;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Jorge on 3/1/17.
 */

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final String COURSES_VIEW = "courses";
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses(){
        LOG.info("Call: " + "listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/addcourse")
    public RedirectView addCourse(@ModelAttribute("course") Course course){
        LOG.info("Call: " + "addCourse() -- PARAM: " + course.toString());
        courseService.addCourse(course);
        return new RedirectView("/course/listcourses");
    }
}

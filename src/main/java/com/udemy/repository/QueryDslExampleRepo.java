package com.udemy.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Jorge on 3/1/17.
 */

@Repository("queryExampleRepo")
public class QueryDslExampleRepo {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager entityManager;

    public Course find(boolean exists){
        JPAQuery<Course> query = new JPAQuery<Course>(entityManager);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if(exists){
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        }else{
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }
        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
    }


}

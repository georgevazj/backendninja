package com.udemy.service.impl;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 2/1/17.
 */

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jorge",29));
        people.add(new Person("Miry",26));
        people.add(new Person("Siso",26));
        people.add(new Person("Peke",25));
        LOG.info("Hello from service!");
        return people;
    }
}

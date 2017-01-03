package com.udemy.component;

import com.udemy.repository.CourseJpaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Jorge on 2/1/17.
 */

@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

    public void sayHello(){
        LOG.info("Hello from ExampleComponent!");
    }
}

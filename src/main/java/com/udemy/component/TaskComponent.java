package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jorge on 9/01/17.
 */

@Component("taskComponent")
public class TaskComponent {

    private static final Log LOG = LogFactory.getLog(TaskComponent.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask(){
        LOG.info("TIME IS: " + new Date());
    }


}

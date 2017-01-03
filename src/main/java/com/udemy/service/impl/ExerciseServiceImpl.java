package com.udemy.service.impl;

import com.udemy.controller.ExerciseController;
import com.udemy.service.ExerciseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Jorge on 2/1/17.
 */

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    private static final Log LOG = LogFactory.getLog(ExerciseServiceImpl.class);


    @Override
    public String getMessage() {
        String logMessage = "Mensaje desde el Servicio.";
        LOG.info(logMessage);
        return logMessage;
    }
}

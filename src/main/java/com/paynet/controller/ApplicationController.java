package com.paynet.controller;

import com.paynet.entity.Application;
import com.paynet.model.ApplicationRequest;
import com.paynet.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public List<Application> getApplications(){
        return applicationService.getApplications();
    }

    @RequestMapping(value = "/applications", method = RequestMethod.POST)
    public Application saveApplication(@RequestBody ApplicationRequest request){
        return applicationService.save(request.toApplication());
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.POST)
    public Application updateApplication(@RequestBody ApplicationRequest request){
        return applicationService.update(request.toApplication());
    }

}

package com.paynet.controller;

import com.paynet.entity.Application;
import com.paynet.model.ApplicationRequest;
import com.paynet.service.ApplicationService;
import com.paynet.validator.ApplicationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ApplicationValidator());
    }

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public List<Application> getApplications(){
        return applicationService.getApplications();
    }

    @RequestMapping(value = "/applications", method = RequestMethod.POST)
    public Application saveApplication(@RequestBody @Valid ApplicationRequest request){
        return applicationService.save(request.toApplication());
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.PATCH)
    public Application updateApplication(@RequestBody ApplicationRequest request){
        return applicationService.update(request.toApplication());
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.POST)
    public Application findApplication(@RequestBody ApplicationRequest request, @PathVariable Integer id){
        return applicationService.find(request.toApplication(id));
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteApplication(@RequestBody ApplicationRequest request, @PathVariable Integer id){
        applicationService.delete(request.toApplication(id));
        return ResponseEntity.ok().build();
    }
}

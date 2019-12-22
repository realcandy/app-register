package com.paynet.service;

import com.paynet.entity.Application;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
//TODO add transactional to composite insert methods
public interface ApplicationService {
    List<Application> getApplications();

    Application save(Application application);

    Application update(Application application);

    Application find(Application application);

    void delete(Application application);
}

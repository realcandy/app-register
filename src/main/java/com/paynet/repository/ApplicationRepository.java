package com.paynet.repository;

import com.paynet.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Mapper
public interface ApplicationRepository{
    @Select("SELECT id as id, title as title, text as text from applications")
    List<Application> getApplications();
}

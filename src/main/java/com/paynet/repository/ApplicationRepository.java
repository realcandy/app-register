package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.repository.providers.ApplicationUpdateProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Mapper
public interface ApplicationRepository{
    @Select("SELECT id as id, title as title, text as text from applications")
    List<Application> getApplications();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "text", column = "text")
    })
    @Select("select * from applications where id = #{id}")
    Application findApplication(Application application);

    @Insert("insert into applications (title, text) values (#{title}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertApplication(Application application);

    @UpdateProvider(ApplicationUpdateProvider.class)
    int updateApplication(Application application);
}

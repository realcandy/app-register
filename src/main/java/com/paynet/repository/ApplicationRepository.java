package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import com.paynet.repository.providers.ApplicationUpdateProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Mapper
public interface ApplicationRepository{
    @Select("SELECT id as id, title as title, text as text from applications")
    List<Application> findAll();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "text", column = "text"),
            @Result(property = "comments", javaType = List.class, column = "comment_id", many = @Many(select = "findCommentsByApplication"))
    })
    @Select("select * from applications where id = #{id}")
    Application findOne(Application application);

    @Insert("insert into applications (title, text) values (#{title}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Application application);

    @UpdateProvider(ApplicationUpdateProvider.class)
    int update(Application application);

    @Results({
            @Result(property = "id", column = "c.id"),
            @Result(property = "text", column = "c.text")
    })
    @Select("select * from applications_comments a, comments c where a.comment_id = c.id and a.application_id = #{id}")
    List<Comment> findCommentsByApplication(Application application);
}

package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import com.paynet.repository.providers.ApplicationUpdateProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Dev1 on 20.12.2019.
 */
public interface ApplicationRepository{
    @Select("SELECT id as id, title as title, text as text from applications order by date_create")
    List<Application> findAll();


    @Select("select * from applications a, applications_users u where a.id = u.application_id and id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "text", column = "text"),
            @Result(property = "dateCreate", column = "date_create"),
            @Result(property = "comments", javaType = List.class, column = "a.comment_id", many = @Many(select = "findCommentsByApplication"))
    })
    Application findOne(Application application);

    @Insert("insert into applications (title, text, date_create) values (#{title}, #{text}, #{dateCreate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Application application);

    @Insert("insert into applications_users (application_id, user_id) values (#{id}, #{user.id})")
    void insertApplicationUser(Application application);

    @UpdateProvider(ApplicationUpdateProvider.class)
    int update(Application application);

    @Delete("delete from applications where id = #{id}")
    void delete(Application application);

    @Results({
            @Result(property = "id", column = "c.id"),
            @Result(property = "text", column = "c.text")
    })
    @Select("select * from applications_comments a, comments c where a.comment_id = c.id and a.application_id = #{id}")
    List<Comment> findCommentsByApplication(Application application);
}

package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentRepository {

    @Insert("insert into comments (text) values (#{text})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Comment comment);

    @Insert("insert into applications_comments (application_id, comment_id) values (#{application.id}, #{comment.id})")
    void insertCommentApplication(@Param("application") Application application, @Param("comment") Comment comment);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text")
    })
    @Select("select * from comments where id = #{id}")
    Comment find(Comment comment);
}

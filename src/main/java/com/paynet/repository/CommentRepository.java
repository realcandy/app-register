package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentRepository {

    @Insert("insert into comments (text) values (#{text})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Comment comment);

    @Insert("insert into applications_comments (application_id, comment_id) values (#{application.id}, #{comment.id})")
    void insertCommentApplication(@Param("comment") Comment comment, @Param("application") Application application);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text")
    })
    @Select("select * from comments where id = #{id}")
    Comment find(Comment comment);
}

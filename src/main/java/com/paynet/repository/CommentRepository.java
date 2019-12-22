package com.paynet.repository;

import com.paynet.entity.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentRepository {

    @Insert("insert into comments (text) values (#{text})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Comment comment);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "text", column = "text")
    })
    @Select("select * from comments where id = #{id}")
    Comment find(Comment comment);
}

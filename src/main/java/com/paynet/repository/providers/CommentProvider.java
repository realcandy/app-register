package com.paynet.repository.providers;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;

public class CommentProvider implements ProviderMethodResolver{

    public static String insert(Application application){
        List<SQL> command = new ArrayList<>();
        for (Comment comment : application.getComments()) {
            new SQL(){

            };
        };

        return new SQL() {
            {
                for(Comment comment : application.getComments()){
                    INSERT_INTO("comments");
                    VALUES("(text)","#{text}" );
                }
            }
        }.toString();
    }
}

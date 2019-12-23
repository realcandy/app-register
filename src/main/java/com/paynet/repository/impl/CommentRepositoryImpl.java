package com.paynet.repository.impl;

import com.paynet.entity.Application;
import com.paynet.entity.Comment;
import com.paynet.repository.CommentRepository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Created by Dev1 on 23.12.2019.
 */
@Repository
@Primary
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void insert(Comment comment) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            getMapper(session).insert(comment);
        }
    }

    @Override
    public void insertCommentApplication(@Param("comment") Comment comment, @Param("application") Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            getMapper(session).insertCommentApplication(comment, application);
        }
    }

    @Override
    public Comment find(Comment comment) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getMapper(session).find(comment);
        }
    }

    private CommentRepository getMapper(SqlSession session) {
        return session.getMapper(CommentRepository.class);
    }
}

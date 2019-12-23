package com.paynet.repository.impl;

import com.paynet.entity.Application;
import com.paynet.entity.ApplicationUser;
import com.paynet.entity.Comment;
import com.paynet.repository.ApplicationRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dev1 on 23.12.2019.
 */
@Repository
@Primary
public class ApplicationRepositoryImpl implements ApplicationRepository {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Application> findAll() {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getMapper(session).findAll();
        }
    }

    @Override
    public Application findOne(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getMapper(session).findOne(application);
        }
    }

    @Override
    public void insert(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            getMapper(session).insert(application);
            getMapper(session).insertApplicationUser(application);
        }
    }

    @Override
    public void insertApplicationUser(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            getMapper(session).insertApplicationUser(application);
        }
    }

    @Override
    public int update(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            return getMapper(session).update(application);
        }
    }

    @Override
    public void delete(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            getMapper(session).delete(application);
        }
    }

    @Override
    public List<Comment> findCommentsByApplication(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            return getMapper(session).findCommentsByApplication(application);
        }
    }

    @Override
    public ApplicationUser findUserByApplication(Application application) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            return getMapper(session).findUserByApplication(application);
        }
    }

    private ApplicationRepository getMapper(SqlSession session){
        return session.getMapper(ApplicationRepository.class);
    }
}

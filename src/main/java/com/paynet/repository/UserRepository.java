package com.paynet.repository;

import com.paynet.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Mapper
public interface UserRepository {
    @Insert("insert into users (login, first_name, last_name, date_birth, address, password) values (#{login}, #{firstName}, #{lastName}, #{dateBirth}, #{address}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(User user);

    @Select("select id as id, login, first_name as firstName, last_name as lastName, date_birth as dateBirth, address, password from users where id = #{id}")
    User findUser(User user);

    @Select("select id as id, login, first_name as firstName, last_name as lastName, date_birth as dateBirth, address, password from users where login = #{login}")
    User findUserByLogin(User user);

    @Update("update users set first_name = #{firstName}, last_name = #{lastName}, address=#{address}, date_birth = #{dateBirth} where id = #{id}")
    void update(User user);
}

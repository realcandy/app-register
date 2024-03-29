package com.paynet.repository;

import com.paynet.entity.Application;
import com.paynet.entity.ApplicationUser;
import com.paynet.repository.providers.ApplicationUserUpdateProvider;
import org.apache.ibatis.annotations.*;

/**
 * Created by Dev1 on 20.12.2019.
 */
@Mapper
public interface UserRepository {
    @Insert("insert into users (username, first_name, last_name, date_birth, address, password) values (#{username}, #{firstName}, #{lastName}, #{dateBirth}, #{address}, #{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(ApplicationUser user);

    @Select("select id as id, username, first_name as firstName, last_name as lastName, date_birth as dateBirth, address, password from users where id = #{id}")
    ApplicationUser findOne(ApplicationUser user);

    @Select("select id as id, username, first_name as firstName, last_name as lastName, date_birth as dateBirth, address, password from users where username = #{username}")
    ApplicationUser findUserByLogin(ApplicationUser user);

    @Select("select a.user_id as id, u.username as username, u.first_name as firstName, u.last_name as lastName, u.date_birth as dateBirth, u.address, u.password from users u, applications_users a where u.id = a.user_id and a.application_id = #{id}")
    ApplicationUser findUserByApplication(Application application);

    @UpdateProvider(ApplicationUserUpdateProvider.class)
    void update(ApplicationUser user);
}

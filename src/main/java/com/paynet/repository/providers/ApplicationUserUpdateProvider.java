package com.paynet.repository.providers;

import com.paynet.entity.ApplicationUser;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ApplicationUserUpdateProvider implements ProviderMethodResolver{
    public static String update(ApplicationUser user) {
        return new SQL() {
            {
                UPDATE("users");
                if (user.getLastName() != null)
                    SET("last_name=#{lastName}");
                if (user.getUsername() != null)
                    SET("username=#{username}");
                if (user.getAddress() != null)
                    SET("address=#{address}");
                if (user.getDateBirth() != null)
                    SET("date_birth=#{dateBirth}");
                if (user.getFirstName() != null)
                    SET("first_name=#{firstName}");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}

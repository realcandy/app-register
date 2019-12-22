package com.paynet.repository.providers;

import com.paynet.entity.Application;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

public class ApplicationUpdateProvider implements ProviderMethodResolver{

    public static String update(Application application) {
        return new SQL() {
            {
                UPDATE("applications");
                if (application.getText() != null)
                    SET("text = #{text}");
                if (application.getTitle() != null)
                    SET("title= #{title}");
                WHERE("id = #{id}");
            }
        }.toString();
    }
}

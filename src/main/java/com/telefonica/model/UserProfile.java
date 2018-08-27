package com.telefonica.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 16:18
 */
@Document(collection = "user_profiles")
public class UserProfile {

    //region ATRIBUTES
    private Integer id;
    private String name;
    //endregion

    //region GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

    //region OVERRIDE

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //endregion
}

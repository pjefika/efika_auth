package com.telefonica.security;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 15/08/18 - 22:26
 */
public class AccountCredentials {

    //region ATRIBUTES
    private String username;
    private String password;
    //endregion

    //region GETTERS AND SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //endregion

    //region OVERRIDE

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountCredentials{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //endregion

}

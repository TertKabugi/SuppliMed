package com.king.myapplication;

public class User {
    String name, email, password, password1, key;

    public User(String name, String email, String idNo, String key) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.password1 = password1;
        this.key = key;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword1() {
        return password1;
    }

    public String getKey() {
        return key;
    }
}


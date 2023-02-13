package com.hb.guillaume_jason.model;

import java.util.ArrayList;
import java.util.List;

public class TwitterUser implements Identifiable{
    private Integer id;
    private String username;
    private String password;
    List<Integer> categoriesId = new ArrayList<>();

    public TwitterUser() {
    }

    public TwitterUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Integer> getCategories() {
        return categoriesId;
    }

    public void setCategories(List<Integer> categories) {
        this.categoriesId = categories;
    }

    public void addCategory(Integer category) {
        if (!categoriesId.contains(category)) {
            categoriesId.add(category);
        }
    }
}

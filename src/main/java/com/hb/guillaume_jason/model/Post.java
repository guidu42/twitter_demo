package com.hb.guillaume_jason.model;

public class Post implements Identifiable {
    private Integer id;
    private String title;
    private String content;
    private Integer categoryId;

    public Post() {

    }

    public Post(String title, String content, Integer categoryId) {
        this.title = title;
        this.categoryId = categoryId;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategory() {
        return categoryId;
    }

    public void setCategory(Integer category) {
        this.categoryId = category;
    }
}

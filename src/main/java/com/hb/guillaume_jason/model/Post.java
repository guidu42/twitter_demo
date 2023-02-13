package com.hb.guillaume_jason.model;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private Category category;

    public Post() {

    }

    public Post(String title, String content, Category category) {
        this.title = title;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

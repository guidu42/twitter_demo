package com.hb.guillaume_jason.model;

public class Category {
    private Integer id;
    private String label;

    public Category() {

    }

    public Category(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

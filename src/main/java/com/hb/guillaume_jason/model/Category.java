package com.hb.guillaume_jason.model;

public class Category implements Identifiable{
    private Integer id;
    private String label;

    public Category() {

    }

    public Category(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

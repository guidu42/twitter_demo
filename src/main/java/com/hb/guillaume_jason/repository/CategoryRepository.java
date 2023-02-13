package com.hb.guillaume_jason.repository;

import com.hb.guillaume_jason.model.Category;

public class CategoryRepository extends AbstractRepository<Category>{

    public CategoryRepository() {
        super("categories.json");
    }
}

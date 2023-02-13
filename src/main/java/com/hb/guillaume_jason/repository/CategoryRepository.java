package com.hb.guillaume_jason.repository;

import com.hb.guillaume_jason.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository extends AbstractRepository<Category>{

    public CategoryRepository() {
        super("categories.json");
    }
}

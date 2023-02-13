package com.hb.guillaume_jason.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.guillaume_jason.model.Category;
import com.hb.guillaume_jason.model.TwitterUser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository<Category>{

    public CategoryRepository() {
        super("categories.json");
    }

    protected List<Category> readFromData() {
        ObjectMapper mapper = new ObjectMapper();
        List<Category> values = new ArrayList<>();
        try {
            File jsonDataFile = new File("src/main/resources/" + this.fileName);
            values = mapper.readValue(
                    jsonDataFile,
                    new TypeReference<List<Category>>() {
                    }
            );
        }catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
}

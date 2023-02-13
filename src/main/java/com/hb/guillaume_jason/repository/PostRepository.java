package com.hb.guillaume_jason.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.guillaume_jason.model.Category;
import com.hb.guillaume_jason.model.Post;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PostRepository extends AbstractRepository<Post> {
    public PostRepository() {
        super("posts.json");
    }

    protected List<Post> readFromData() {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> values = new ArrayList<>();
        try {
            File jsonDataFile = new File("src/main/resources/" + this.fileName);
            values = mapper.readValue(
                    jsonDataFile,
                    new TypeReference<List<Post>>() {
                    }
            );
        }catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }

    public List<Post> findByCategoryIds(List<Integer> categoriesId) {
        List<Post> allPosts = this.getAll();
        List<Post> postFiltered = new ArrayList<>();
        for (Post post : allPosts) {
            for (Integer categoryId : categoriesId) {
                if (post.getCategory().equals(categoryId)) {
                    postFiltered.add(post);
                }
            }
        }
        return postFiltered;
    }
}

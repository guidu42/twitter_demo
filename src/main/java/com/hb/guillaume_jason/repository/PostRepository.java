package com.hb.guillaume_jason.repository;

import com.hb.guillaume_jason.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PostRepository extends AbstractRepository<Post> {
    public PostRepository() {
        super("posts.json");
    }


}

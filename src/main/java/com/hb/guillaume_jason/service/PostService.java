package com.hb.guillaume_jason.service;

import com.hb.guillaume_jason.dto.PostDTO;
import com.hb.guillaume_jason.model.Post;
import com.hb.guillaume_jason.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<PostDTO> findByCategoryIds(List<Integer> categoriesId) {
        List<Post> posts = this.postRepository.findByCategoryIds(categoriesId);
        List<PostDTO> postDTOS = new ArrayList<>();

        for (Post post : posts) {
            postDTOS.add(new PostDTO(post.getTitle(), post.getContent(), post.getCategory()));
        }
        return postDTOS;
    }

    public void add(PostDTO postDTO) {
        this.postRepository.save(new Post(postDTO.title(), postDTO.content(), postDTO.categoryId()));
    }
}

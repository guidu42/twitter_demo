package com.hb.guillaume_jason.controller;

import com.hb.guillaume_jason.configuration.SecurityConfig;
import com.hb.guillaume_jason.dto.CategoryDTO;
import com.hb.guillaume_jason.dto.PostDTO;
import com.hb.guillaume_jason.dto.TwitterUserDTO;
import com.hb.guillaume_jason.service.CategoryService;
import com.hb.guillaume_jason.service.PostService;
import com.hb.guillaume_jason.service.TwitterUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
    private TwitterUserService twitterUserService;
    private CategoryService categoryService;
    private PostService postService;

    public PostController(TwitterUserService twitterUserService, CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.twitterUserService = twitterUserService;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ModelAndView index() {
        TwitterUserDTO userDTO = this.twitterUserService.findByUsername(SecurityConfig.getUserName());

        if (userDTO != null) {
            List<PostDTO> posts = this.postService.findByCategoryIds(userDTO.categoriesId());

            ModelAndView mav = new ModelAndView("/posts");
            mav.addObject("posts", posts);
            return mav;
        }
        return new ModelAndView("redirect:/login");
    }

}

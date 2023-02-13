package com.hb.guillaume_jason.controller;

import com.hb.guillaume_jason.configuration.SecurityConfig;
import com.hb.guillaume_jason.dto.CategoryDTO;
import com.hb.guillaume_jason.dto.TwitterUserDTO;
import com.hb.guillaume_jason.service.CategoryService;
import com.hb.guillaume_jason.service.TwitterUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
    private TwitterUserService twitterUserService;
    private CategoryService categoryService;

    public PostController(TwitterUserService twitterUserService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.twitterUserService = twitterUserService;
    }

    @GetMapping("/posts")
    public ModelAndView index() {
        TwitterUserDTO userDTO = this.twitterUserService.findByUsername(SecurityConfig.getUserName());

        if (userDTO != null) {
            List<CategoryDTO> categories = this.categoryService.findByIds(userDTO.categoriesId());

            ModelAndView mav = new ModelAndView("/posts");
            mav.addObject(categories);
            return mav;
        }
        return new ModelAndView("redirect:/login");
    }
}

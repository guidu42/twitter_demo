package com.hb.guillaume_jason.controller;

import com.hb.guillaume_jason.configuration.SecurityConfig;
import com.hb.guillaume_jason.dto.CategoryDTO;
import com.hb.guillaume_jason.dto.PostDTO;
import com.hb.guillaume_jason.dto.TwitterUserDTO;
import com.hb.guillaume_jason.dto.TwitterUserProfilDTO;
import com.hb.guillaume_jason.service.CategoryService;
import com.hb.guillaume_jason.service.TwitterUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfilController {
    private TwitterUserService twitterUserService;

    private CategoryService categoryService;

    public ProfilController(TwitterUserService twitterUserService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.twitterUserService = twitterUserService;
    }

    @GetMapping("/profil")
    public ModelAndView profil(){
        TwitterUserProfilDTO userDTO = this.twitterUserService.findProfilByUsername(SecurityConfig.getUserName());

        if (userDTO != null) {
            List<CategoryDTO> allCategories = this.categoryService.getAll();
            ModelAndView mav = new ModelAndView("/profil");
            mav.addObject("user", userDTO);
            mav.addObject("allCategories", allCategories);

            return mav;
        }

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/profil")
    public ModelAndView profilAction(@ModelAttribute TwitterUserProfilDTO twitterUserDTO) {
        this.twitterUserService.update(twitterUserDTO);

        return new ModelAndView("redirect:/posts");
    }
}

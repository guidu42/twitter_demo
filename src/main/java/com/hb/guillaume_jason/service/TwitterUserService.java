package com.hb.guillaume_jason.service;

import com.hb.guillaume_jason.dto.TwitterUserDTO;
import com.hb.guillaume_jason.dto.TwitterUserProfilDTO;
import com.hb.guillaume_jason.model.TwitterUser;
import com.hb.guillaume_jason.repository.TwitterUserRepository;
import org.springframework.stereotype.Service;

@Service
public class TwitterUserService {
    private TwitterUserRepository twitterUserRepository;

    public TwitterUserService(TwitterUserRepository twitterUserRepository) {
        this.twitterUserRepository = twitterUserRepository;
    }

    public TwitterUserDTO findById(Integer id) {
        TwitterUser twitterUser = this.twitterUserRepository.findById(id);
        if (twitterUser != null) {
            return new TwitterUserDTO(twitterUser.getUsername(), twitterUser.getPassword(), twitterUser.getCategories());
        }
        return null;
    }

    public TwitterUserDTO findByUsername(String userName) {
        TwitterUser twitterUser = this.twitterUserRepository.getUserByUsername(userName);
        if (twitterUser != null) {
            return new TwitterUserDTO(twitterUser.getUsername(), twitterUser.getPassword(), twitterUser.getCategories());
        }
        return null;
    }

    public TwitterUserProfilDTO findProfilByUsername(String userName) {
        TwitterUser twitterUser = this.twitterUserRepository.getUserByUsername(userName);
        if (twitterUser != null) {
            return new TwitterUserProfilDTO(twitterUser.getUsername(), twitterUser.getCategories());
        }
        return null;
    }

    public void update(TwitterUserProfilDTO twitterUserDTO) {
        TwitterUser twitterUser = this.twitterUserRepository.getUserByUsername(twitterUserDTO.username());
        if (twitterUser != null) {
            twitterUser.setUsername(twitterUserDTO.username());
            twitterUser.setCategories(twitterUserDTO.categoriesId());

            this.twitterUserRepository.save(twitterUser);
        }
    }
}

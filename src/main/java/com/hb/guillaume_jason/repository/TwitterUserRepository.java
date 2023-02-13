package com.hb.guillaume_jason.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.guillaume_jason.model.TwitterUser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class TwitterUserRepository extends AbstractRepository<TwitterUser> {
    public TwitterUserRepository() {
        super("users.json");
    }

    public TwitterUser getUserByUsername(String username) {
		List<TwitterUser> users = getAll();

		for (TwitterUser user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
    
}

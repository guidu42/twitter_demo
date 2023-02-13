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
    
    public List<TwitterUser> getUsers() {
		List<TwitterUser> users = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			File resourceJson = new File("src/main/resources/users.json");
			users = mapper.readValue(resourceJson, new TypeReference<List<TwitterUser>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
    
    public TwitterUser getUserByUsername(String username) {

		List<TwitterUser> users = getUsers();

		for (TwitterUser user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
    
}

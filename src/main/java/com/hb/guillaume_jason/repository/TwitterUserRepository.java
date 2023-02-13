package com.hb.guillaume_jason.repository;

import com.hb.guillaume_jason.model.TwitterUser;
import org.springframework.stereotype.Repository;


@Repository
public class TwitterUserRepository extends AbstractRepository<TwitterUser> {
    public TwitterUserRepository() {
        super("users.json");
    }
}

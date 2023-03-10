package com.hb.guillaume_jason.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hb.guillaume_jason.model.TwitterUser;
import com.hb.guillaume_jason.repository.TwitterUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private TwitterUserRepository twitterUserRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		TwitterUser user = twitterUserRepository.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + " not found");
		}
		
		return new User(user.getUsername(), user.getPassword(), userGrantedAuthority());
	}

	private List<GrantedAuthority> userGrantedAuthority() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER" ));
		return grantedAuthorities;
	}

}

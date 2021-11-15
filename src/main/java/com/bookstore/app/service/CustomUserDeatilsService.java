package com.bookstore.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.UserRepository;

@Service
public class CustomUserDeatilsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(userRepository.findByEmailId(username)!=null){
			UserEntity user=userRepository.findByEmailId(username);
			return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("Not found");
		}
	}
	

}

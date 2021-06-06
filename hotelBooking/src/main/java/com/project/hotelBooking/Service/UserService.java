package com.project.hotelBooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelBooking.Repository.UserRepository;
import com.project.hotelBooking.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
}

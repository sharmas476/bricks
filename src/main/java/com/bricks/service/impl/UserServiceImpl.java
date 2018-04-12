/**
 * 
 */
package com.bricks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bricks.model.UserDetails;
import com.bricks.repository.UserRepository;
import com.bricks.service.UserService;

/**
 * @author shubham
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see com.bricks.service.UserService#getAll()
	 */
	@Override
	public List<UserDetails> getAll() {
		return userRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.bricks.service.UserService#getOne(long)
	 */
	@Override
	public UserDetails getOne(long id) {
		return userRepository.getOne(id);
	}

	/* (non-Javadoc)
	 * @see com.bricks.service.UserService#saveNew(com.bricks.model.UserDetails)
	 */
	@Override
	public void saveNew(UserDetails userDetails) {
		userRepository.save(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.bricks.service.UserService#delete(long)
	 */
	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
	}
}

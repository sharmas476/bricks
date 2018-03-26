/**
 * 
 */
package com.bricks.service;

import java.util.List;

import com.bricks.model.UserDetails;

/**
 * @author subham
 *
 */

public interface UserService {
	
	public List<UserDetails> getAll();
	
	public UserDetails getOne(long id);
	
	public void saveNew(UserDetails userDetails);
	
	public void delete(long id);

}

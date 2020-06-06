/**
 * 
 */
package com.mindtree.shoppingcart.service;

import com.mindtree.shoppingcart.model.User;

/**
 * @author M1023165
 *
 */
public interface UserManagerService {
	
	/**
	 * @param user
	 * @return
	 */
	public User getUserDetails(User user);

	/**
	 * @param user
	 * @return
	 */
	public User saveUserDetails(User user);

}

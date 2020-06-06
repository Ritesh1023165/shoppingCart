/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import com.mindtree.shoppingcart.model.User;

/**
 * @author M1023165
 *
 */
public interface UserManagerDao {
	/**
	 * @param user
	 * @return
	 */
	public User getUser(User user);

	/**
	 * @param user
	 * @return
	 */
	public User saveUser(User user);
}

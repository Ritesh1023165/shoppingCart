/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.dao.repository.UserManagerRepository;
import com.mindtree.shoppingcart.model.User;

/**
 * @author M1023165
 *
 */
@Repository
public class UserManagerDaoImpl implements UserManagerDao {

	/**
	 * userManagerRespository
	 */
	@Resource
	UserManagerRepository userManagerRespository;

	/**
	 *getUser
	 */
	@Override
	public User getUser(User user) {
		List<User> userList = userManagerRespository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return userList.size() > 0 ? userList.get(0) : null;
	}

	/**
	 *saveUser
	 */
	@Override
	public User saveUser(User user) throws RuntimeException {
		return userManagerRespository.save(user);
	}

}

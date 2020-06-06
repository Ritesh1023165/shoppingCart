/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.dao.repository.CartItemManagerRepository;
import com.mindtree.shoppingcart.dao.repository.UserCartManagerRepository;
import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * @author M1023165
 *
 */
@Repository
public class CartManagerDaoImpl implements CartManagerDao {

	/**
	 * userCartRepo
	 */
	@Resource
	UserCartManagerRepository userCartRepo;

	/**
	 * cartItemRepo
	 */
	@Resource
	CartItemManagerRepository cartItemRepo;

	@Override
	public UserCart createUserCart(UserCart userCart) {
		return userCartRepo.save(userCart);
	}

	@Override
	public UserCart retriveUserCart(User user) {
		return userCartRepo.findByUser(user);
	}

	/**
	 * retriveUserCartById
	 */
	@Override
	public Optional<UserCart> retriveUserCartById(UserCart userCart) {
		return userCartRepo.findById(userCart.getCartId());
	}

	/**
	 * addCartItem
	 */
	@Override
	public CartItem addCartItem(CartItem item) {
		return cartItemRepo.save(item);
	}

}

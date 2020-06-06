/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;

/**
 * @author M1023165
 *
 */
@Repository
public interface CartManagerDao {

	/**
	 * @param userCart
	 * @return
	 */
	UserCart createUserCart(UserCart userCart);

	/**
	 * @param user
	 * @return
	 */
	UserCart retriveUserCart(User user);

	/**
	 * @param userCart
	 * @return
	 */
	Optional<UserCart> retriveUserCartById(UserCart userCart);

	/**
	 * @param item
	 * @return
	 */
	CartItem addCartItem(CartItem item);

}

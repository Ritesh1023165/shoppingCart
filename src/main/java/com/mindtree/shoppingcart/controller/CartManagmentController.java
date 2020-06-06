/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcart.model.CartItem;
import com.mindtree.shoppingcart.model.User;
import com.mindtree.shoppingcart.model.UserCart;
import com.mindtree.shoppingcart.service.CartManagerService;

/**
 * @author M1023165
 *
 */
@RestController
public class CartManagmentController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartManagmentController.class);

	/**
	 * cartManagerService
	 */
	@Autowired
	CartManagerService cartManagerService;

	/**
	 * @param cartDetail
	 * @param session
	 * @return success
	 */
	@RequestMapping(value = "/addtoCart", method = RequestMethod.POST)
	public String addtoCart(@RequestBody CartItem cartDetail, HttpSession session) {
		UserCart userCart = null;
		if (session.getAttribute("cartDetail") != null) {
			userCart = (UserCart) session.getAttribute("cartDetail");
		} else {
			User user = (User) session.getAttribute("userDetail");
			userCart = cartManagerService.createUserCart(user);
			session.setAttribute("cartDetail", userCart);
		}
		cartManagerService.addToCartDetails(cartDetail, userCart);
		return "{\"status\":\"success\"}";
	}

	/**
	 * @param cartDetail
	 * @param session
	 * @return success
	 */
	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	public String updateCart(@RequestBody CartItem cartDetail, HttpSession session) {
		UserCart userCart = null;
		if (session.getAttribute("cartDetail") != null) {
			userCart = (UserCart) session.getAttribute("cartDetail");
		} else {
			User user = (User) session.getAttribute("userDetail");
			userCart = cartManagerService.createUserCart(user);
			session.setAttribute("cartDetail", userCart);
		}
		cartManagerService.updateCartDetails(cartDetail, userCart);
		return "{\"status\":\"success\"}";
	}

	/**
	 * @param ex
	 * @return error
	 */
	@ExceptionHandler(DataAccessException.class)
	public String handleConstraintViolationException(DataAccessException ex) {
		LOGGER.error("Error while add/updating cart" + ex.getMessage());
		return "{\"status\":\"error\"}";
	}
}

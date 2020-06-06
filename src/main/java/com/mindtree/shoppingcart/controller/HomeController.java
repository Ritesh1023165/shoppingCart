/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author M1023165 HomeController
 */
@Controller
public class HomeController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	/**
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, ModelMap model) {
		if (session.getAttribute("userDetail") != null) {
			model.addAttribute("userDetail", session.getAttribute("userDetail"));
			LOGGER.info("existing session, user already logged in. redirecting to productSearch page");
			return new ModelAndView("forward:/productSearch", model);
		}
		LOGGER.info("no session exist redirecting to Home page");
		return new ModelAndView("home");
	}

}

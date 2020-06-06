/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.shoppingcart.model.Product;
import com.mindtree.shoppingcart.model.ProductSearch;
import com.mindtree.shoppingcart.service.ProductManagerService;

/**
 * @author M1023165
 *
 */
@Controller
public class ProductSearchController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductSearchController.class);

	/**
	 * cartManagerService
	 */
	@Autowired
	ProductManagerService productManagerService;

	/**
	 * @return list of product type
	 */
	@ModelAttribute(name = "productTypes")
	public List<String> populateProductTypes() {
		List<String> productTypes = productManagerService.fetchProductTypes();
		return productTypes;
	}

	/**
	 * @param productSearch
	 * @param result
	 * @param model
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/productSearch", method = RequestMethod.POST)
	public ModelAndView productSearch(@Valid @ModelAttribute("productSearch") ProductSearch productSearch,
			BindingResult result, ModelMap model) {
		Map<String, List<Product>> products = productManagerService.fetchProductTypesByCriteria(productSearch);
		model.addAttribute("productMapList", products);
		return new ModelAndView("productSearch");
	}

	/**
	 * @param ex
	 * @return error
	 */
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleConstraintViolationException(DataAccessException ex) {
		LOGGER.error("Error while searching product" + ex.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productSearch");
		modelAndView.addObject("exception", "Error while searching product");
		return modelAndView;
	}

}

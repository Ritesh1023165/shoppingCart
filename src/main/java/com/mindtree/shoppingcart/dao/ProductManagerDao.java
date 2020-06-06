/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.model.Product;

/**
 * @author M1023165
 *
 */
@Repository
public interface ProductManagerDao {

	/**
	 * @return
	 */
	List<Product> fetchAllProduct();

	/**
	 * @return
	 */
	List<String> fetchAllProductType();

	/**
	 * @param productId
	 * @return 
	 */
	List<Product> fetchProductById(Integer productId);

	/**
	 * @param productName
	 * @return
	 */
	List<Product> fetchProductByName(String productName);

}

/**
 * 
 */
package com.mindtree.shoppingcart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.dao.repository.ProductManagerRepository;
import com.mindtree.shoppingcart.model.Product;

/**
 * @author M1023165
 *
 */
@Repository
public class ProductManagerDaoImpl implements ProductManagerDao {

	/**
	 * productrepo
	 */
	@Resource
	ProductManagerRepository productrepo;

	/**
	 * fetchAllProduct
	 */
	@Override
	public List<Product> fetchAllProduct() {
		return productrepo.findAll();
	}

	/**
	 * fetchAllProductType
	 */
	@Override
	public List<String> fetchAllProductType() {
		return productrepo.findAllProductType();
	}

	/**
	 * fetchProductById
	 */
	@Override
	public List<Product> fetchProductById(Integer productId) {
		return productrepo.findByProductId(productId);
	}

	/**
	 *fetchProductByName
	 */
	@Override
	public List<Product> fetchProductByName(String productName) {
		return productrepo.findByProdName(productName);
	}

}

/**
 * 
 */
package com.eshop.catalog.admin.controller;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.model.Product;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Inject
	@Named("productService")
	private ProductService productService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public MediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditProductForm(@PathVariable Long id, Model model, HttpServletRequest request) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);

		return "editProduct";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addProduct(@Valid Product product, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		product = productService.addProduct(product);
		model.addAttribute("product", product);
		return "addProductSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable Long id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateProduct(@Valid Product product, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		product = productService.updateProduct(product);
		model.addAttribute("product", product);
		return "editProductSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "deleteProductSuccess";
	}

}

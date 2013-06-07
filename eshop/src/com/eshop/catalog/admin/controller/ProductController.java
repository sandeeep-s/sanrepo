/**
 * 
 */
package com.eshop.catalog.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.catalog.admin.service.BrandService;
import com.eshop.catalog.admin.service.CategoryService;
import com.eshop.catalog.admin.service.DimensionPropertyService;
import com.eshop.catalog.admin.service.PatternService;
import com.eshop.catalog.admin.service.ProductService;
import com.eshop.catalog.admin.service.TechSpecPropertyService;
import com.eshop.catalog.model.Brand;
import com.eshop.catalog.model.CategorizedProduct;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.TechSpecProperty;
import com.eshop.common.service.MediaService;

/**
 * @author ssd1kor
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	@Named("productService")
	private ProductService productService;

	@Inject
	@Named("mediaService")
	private MediaService mediaService;

	@Inject
	@Named("categoryService")
	private CategoryService categoryService;
	@Inject
	@Named("brandService")
	private BrandService brandService;

	@Inject
	@Named("patternService")
	private PatternService patternService;

	@Inject
	@Named("techSpecPropertyService")
	private TechSpecPropertyService techSpecPropertyService;

	@Inject
	@Named("dimensionPropertyService")
	private DimensionPropertyService dimensionPropertyService;

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

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public PatternService getPatternService() {
		return patternService;
	}

	public void setPatternService(PatternService patternService) {
		this.patternService = patternService;
	}

	public TechSpecPropertyService getTechSpecPropertyService() {
		return techSpecPropertyService;
	}

	public void setTechSpecPropertyService(TechSpecPropertyService techSpecPropertyService) {
		this.techSpecPropertyService = techSpecPropertyService;
	}

	public DimensionPropertyService getDimensionPropertyService() {
		return dimensionPropertyService;
	}

	public void setDimensionPropertyService(DimensionPropertyService dimensionPropertyService) {
		this.dimensionPropertyService = dimensionPropertyService;
	}

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	private void addRefDataRequestAttributes(Model model) {
		Set<Category> categories = categoryService.getAllCategorys();
		List<CategorizedProduct> categorizedProducts = new ArrayList<CategorizedProduct>();
		for (Category  category :  categories){
			CategorizedProduct categorizedProduct = new CategorizedProduct();
			categorizedProduct.setCategory(category);
			categorizedProducts.add(categorizedProduct);
		}
		model.addAttribute("categorizedProducts", categorizedProducts);

		Set<Brand> brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);

		Set<Pattern> patterns = patternService.getAllPatterns();
		model.addAttribute("patterns", patterns);

		Set<TechSpecProperty> techSpecProperties = techSpecPropertyService.getAllTechSpecPropertys();
		model.addAttribute("techSpecProperties", techSpecProperties);

		Set<DimensionProperty> dimensionProperties = dimensionPropertyService.getAllDimensionPropertys();
		model.addAttribute("dimensionProperties", dimensionProperties);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddProductForm(Model model) {
		Product product = productService.createProduct();
		model.addAttribute("product", product);

		addRefDataRequestAttributes(model);

		return "addProduct";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String displayEditProductForm(@PathVariable Long id, Model model, HttpServletRequest request) {

		try {
			Product product = productService.getProductById(id);
			model.addAttribute("product", product);

		} catch (ObjectRetrievalFailureException e) {
			logger.error("Product with id " + id + " not found", e);
			model.addAttribute("productId", id);
			return "productNotFound";
		}

		addRefDataRequestAttributes(model);

		return "editProduct";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addProduct(@Valid Product product, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		System.out.println("product Spec product=" + product.getProductSpec().getProduct());
		System.out.println("categorizedProducts = " + product.getCategorizedProducts().size());
		System.out.println("categorizedProducts = " + product.getCategorizedProducts().get(0).getCategory());
		System.out.println("categorizedProducts = " + product.getCategorizedProducts().get(0).getCategory().getId());
		product = productService.addProduct(product);
		model.addAttribute("product", product);
		return "addProductSuccess";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable Long id, Model model) {

		try {
			Product product = productService.getProductById(id);
			model.addAttribute("product", product);
		} catch (ObjectRetrievalFailureException e) {
			logger.error("Product with id " + id + " not found", e);
			model.addAttribute("productId", id);
			return "productNotFound";
		} catch (EmptyResultDataAccessException e) {
			logger.error("Product with id " + id + " not found", e);
			model.addAttribute("productId", id);
			return "productNotFound";
		} 
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
	public String deleteProduct(@PathVariable Long id, Model model) {
		Product product = productService.deleteProduct(id);
		model.addAttribute("product", product);
		return "deleteProductSuccess";
	}

}

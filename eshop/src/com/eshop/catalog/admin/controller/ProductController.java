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
import com.eshop.catalog.model.Dimension;
import com.eshop.catalog.model.DimensionProperty;
import com.eshop.catalog.model.Pattern;
import com.eshop.catalog.model.Product;
import com.eshop.catalog.model.ProductSpec;
import com.eshop.catalog.model.TechSpec;
import com.eshop.catalog.model.TechSpecProperty;
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

	@RequestMapping(method = RequestMethod.GET)
	public String listProducts(Model model) {
		Set<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayAddProductForm(Model model) {
		Product product = new Product();
		ProductSpec productSpec = new ProductSpec();

		List<TechSpec> techSpecList = new ArrayList<TechSpec>();
		TechSpecProperty techSpecProperty = new TechSpecProperty();
		TechSpec techSpec = new TechSpec();
		techSpec.setTechSpecProperty(techSpecProperty);
		techSpecList.add(techSpec);
		productSpec.setTechSpecs(techSpecList);

		List<Dimension> dimensionList = new ArrayList<Dimension>();
		DimensionProperty dimensionProperty = new DimensionProperty();
		Dimension dimension = new Dimension();
		dimension.setDimensionProperty(dimensionProperty);
		dimensionList.add(dimension);
		DimensionProperty dimensionProperty1 = new DimensionProperty();
		Dimension dimension1 = new Dimension();
		dimension.setDimensionProperty(dimensionProperty1);
		dimensionList.add(dimension1);
		productSpec.setDimensions(dimensionList);

		Pattern pattern = new Pattern();
		productSpec.setPattern(pattern);
		product.addProductSpec(productSpec);

		Category category = new Category();
		CategorizedProduct categorizedProduct = new CategorizedProduct(category, product);
		List<CategorizedProduct> categorizedProducts = new ArrayList<CategorizedProduct>();
		categorizedProducts.add(categorizedProduct);
		product.setCategorizedProducts(categorizedProducts);
		model.addAttribute("product", product);

		Set<Category> categories = categoryService.getAllCategorys();
		model.addAttribute("categories", categories);
		
		Set<Brand> brands = brandService.getAllBrands();
		model.addAttribute("brands", brands);

		Set<Pattern> patterns = patternService.getAllPatterns();
		model.addAttribute("patterns", patterns);

		Set<TechSpecProperty> techSpecProperties = techSpecPropertyService.getAllTechSpecPropertys();
		model.addAttribute("techSpecProperties", techSpecProperties);

		Set<DimensionProperty> dimensionProperties = dimensionPropertyService.getAllDimensionPropertys();
		model.addAttribute("dimensionProperties", dimensionProperties);

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

		System.out.println("product Spec product="+product.getProductSpec().getProduct());
		System.out.println("categorizedProducts = " +product.getCategorizedProducts().size());
		System.out.println("categorizedProducts = " +product.getCategorizedProducts().get(0).getCategory());
		System.out.println("categorizedProducts = " +product.getCategorizedProducts().get(0).getCategory().getId());
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

/**
 * 
 */
package com.eshop.catalog.admin.service;

import java.util.Set;

import com.eshop.catalog.model.Category;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
public interface CategoryService {

	public Category addCategory(Category category);

	public Category getCategoryById(Long categoryId);

	public Category updateCategory(Category category);

	public Category deleteCategory(Long categoryId);

	public Set<Category> getAllCategorys();

	public Category createCategory(String categoryName, Media logoImage);

}

/**
 * 
 */
package com.eshop.catalog.admin.service.impl;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.catalog.admin.service.CategoryService;
import com.eshop.catalog.model.Category;
import com.eshop.catalog.persistence.CategoryDAO;
import com.eshop.common.model.Media;

/**
 * @author ssd1kor
 * 
 */
@Service("categoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Inject
	private CategoryDAO categoryDAO = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.etyre.vehicle.service.VehicleService#addCategory(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Category addCategory(Category category) {
		return categoryDAO.makePersistent(category);
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return categoryDAO.findById(categoryId);
	}

	/**
	 * Good way to update as its causes First Commit Wins scenario. But the
	 * vehiclemake should be a detached object with proper version number
	 */
	@Override
	public Category updateCategory(Category category) {
		return categoryDAO.saveOrUpdate(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = categoryDAO.getReference(categoryId);
		categoryDAO.delete(category);
	}

	@Override
	public Set<Category> getAllCategorys() {
		return categoryDAO.findAllUnique();
	}

	@Override
	public Category createCategory(String name, Media logoImage) {
		Category category = new Category();
		return category;
	}

}

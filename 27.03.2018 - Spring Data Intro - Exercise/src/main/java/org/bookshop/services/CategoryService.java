package org.bookshop.services;

import org.bookshop.models.entity.Category;

import java.util.List;

public interface CategoryService {

    public void saveCategory(Category category);

    public void saveAllCategories(List<Category> categories);

    List<Category> getAllCategories();
}
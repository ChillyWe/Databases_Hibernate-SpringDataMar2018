package org.bookshop.services;

import org.bookshop.models.entity.Category;
import org.bookshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public void saveAllCategories(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
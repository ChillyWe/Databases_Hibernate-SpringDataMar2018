package soft_unibg.spring_advanced_query.services;

import soft_unibg.spring_advanced_query.models.entity.Category;

import java.util.List;

public interface CategoryService {

    public void saveCategory(Category category);

    public void saveAllCategories(List<Category> categories);

    List<Category> getAllCategories();
}
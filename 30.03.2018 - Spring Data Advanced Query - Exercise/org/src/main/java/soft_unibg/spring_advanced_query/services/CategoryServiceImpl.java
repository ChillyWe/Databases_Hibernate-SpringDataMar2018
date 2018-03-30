package soft_unibg.spring_advanced_query.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_unibg.spring_advanced_query.models.entity.Category;
import soft_unibg.spring_advanced_query.repositories.CategoryRepository;

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
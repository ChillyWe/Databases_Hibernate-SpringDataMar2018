package soft_uni.product_shop.services.category;

import soft_uni.product_shop.models.dtos.binding.category.CategoryCreateBindingModel;
import soft_uni.product_shop.models.entity.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    void saveCategories(Collection<CategoryCreateBindingModel> models);

    List<Category> getCategories();

    Category getCategory(Integer category_id);
}
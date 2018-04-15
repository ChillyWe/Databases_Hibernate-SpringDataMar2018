package soft_uni.product_shop.services.category;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.product_shop.models.dtos.binding.category.CategoryCreateBindingModel;
import soft_uni.product_shop.models.entity.Category;
import soft_uni.product_shop.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = modelMapper;
    }

    @Override
    public void saveCategories(Collection<CategoryCreateBindingModel> models) {
        Type listType = new TypeToken<List<Category>>() {
        }.getType();
        List<Category> categories = this.mapper.map(models, listType);
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer category_id) {
        return this.categoryRepository.getOne(category_id.longValue());
    }
}
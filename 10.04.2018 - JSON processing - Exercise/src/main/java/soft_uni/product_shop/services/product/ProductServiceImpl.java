package soft_uni.product_shop.services.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.product_shop.models.dtos.binding.product.ProductCreateBindingModel;
import soft_uni.product_shop.models.dtos.views.ProductInRangeViewModel;
import soft_uni.product_shop.models.entity.Category;
import soft_uni.product_shop.models.entity.Product;
import soft_uni.product_shop.repositories.ProductRepository;
import soft_uni.product_shop.services.category.CategoryService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper mapper,
                              CategoryService categoryService) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Override
    public void save(Collection<ProductCreateBindingModel> models) {
        List<Product> products = models.stream().map(m -> this.mapper.map(m,Product.class)).collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }

    @Override
    public void seedCategories() {
        Random random = new Random();

        this.productRepository.findAll().forEach(p -> {
            int categoryCount = random.nextInt(3);
            Set<Category> categories = new HashSet<>();
            if(categoryCount > 0) {
                for (int i = 0; i < categoryCount; i++) {

                    int category = random.nextInt(this.categoryService.getCategories().size());
                    if (category > 1) {
                        categories.add(this.categoryService.getCategories().get(category));
                        this.categoryService.getCategory(category).addProduct(p);
                    } else {
                        i--;
                    }
                }
            }
            p.setCategories(categories);
        });
    }

    @Override
    public List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to) {
        return this.productRepository.getAllByRangeWithoutBuyer(new BigDecimal(from),new BigDecimal(to));
    }
}
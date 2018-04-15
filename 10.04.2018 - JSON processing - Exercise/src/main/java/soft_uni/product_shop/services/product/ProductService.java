package soft_uni.product_shop.services.product;

import soft_uni.product_shop.models.dtos.binding.product.ProductCreateBindingModel;

import java.util.Collection;

public interface ProductService {

    void save(Collection<ProductCreateBindingModel> models);

    void seedCategories();
}
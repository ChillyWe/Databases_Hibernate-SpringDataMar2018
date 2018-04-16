package soft_uni.product_shop.services.product;

import soft_uni.product_shop.models.dtos.binding.product.ProductCreateBindingModel;
import soft_uni.product_shop.models.dtos.views.ProductInRangeViewModel;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    void save(Collection<ProductCreateBindingModel> models);

    void seedCategories();

    List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to);
}
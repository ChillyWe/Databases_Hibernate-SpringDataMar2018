package soft_uni.product_shop.utills.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import soft_uni.product_shop.models.dtos.binding.product.ProductCreateBindingModel;
import soft_uni.product_shop.models.entity.Product;
import soft_uni.product_shop.services.user.UserService;

@Configuration
public class ModelMapperConfig {

    private final ModelMapper mapper;
    private final UserService userService;

    @Autowired
    public ModelMapperConfig(ModelMapper mapper,
                             UserService userService) {
        this.mapper = mapper;
        this.userService = userService;

        this.init();
    }

    private void init() {
        this.productCreateBindingConfiguration();
    }

    private void productCreateBindingConfiguration() {
        Converter<ProductCreateBindingModel, Product> con = new AbstractConverter<ProductCreateBindingModel, Product>() {
            @Override
            protected Product convert(ProductCreateBindingModel src) {
                Product p = new Product();
                Integer buyer = src.getBuyer();
                if (buyer != null) {
                    p.setBuyer(userService.findUser(buyer));
                }
                p.setSeller(userService.findUser(src.getSeller()));
                p.setName(src.getName());
                p.setPrice(src.getPrice());
                return p;
            }
        };
        this.mapper.addConverter(con);
    }
}
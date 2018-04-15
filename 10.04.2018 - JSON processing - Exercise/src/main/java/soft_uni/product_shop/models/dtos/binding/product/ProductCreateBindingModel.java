package soft_uni.product_shop.models.dtos.binding.product;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductCreateBindingModel implements Serializable {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    private Integer buyer;
    private Integer seller;

    public ProductCreateBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }
}
package p06;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> bagOfProducts;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new LinkedList<>();
    }

    private void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.money -= product.getCost();
            bagOfProducts.add(product);
            return String.format("%s bought %s", this.name, product.getName());
        } else {
            return String.format("%s can't afford %s", this.name, product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ");
        if (this.bagOfProducts.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            for (int i = 0; i < this.bagOfProducts.size() - 1; i++) {
                sb.append(this.bagOfProducts.get(i).getName()).append(", ");
            }
            sb.append(this.bagOfProducts.get(this.bagOfProducts.size()- 1).getName());
        }
        return sb.toString();
    }
}
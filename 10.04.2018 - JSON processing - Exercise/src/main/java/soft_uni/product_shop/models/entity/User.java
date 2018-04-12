package soft_uni.product_shop.models.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static soft_uni.product_shop.default_values.constants.DEFAULT_USER_NAME_MIN_LENGTH;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    private Set<User> friends;
    private Set<Product> soldProducts;
    private Set<Product> buyedProducts;

    public User() {
        this.friends = new HashSet<>();
        this.soldProducts = new HashSet<>();
        this.buyedProducts = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Length(min = DEFAULT_USER_NAME_MIN_LENGTH)
    @Column(name="last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "seller")
    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    @OneToMany(mappedBy = "buyer")
    public Set<Product> getBuyedProducts() {
        return buyedProducts;
    }

    public void setBuyedProducts(Set<Product> buyedProducts) {
        this.buyedProducts = buyedProducts;
    }
}
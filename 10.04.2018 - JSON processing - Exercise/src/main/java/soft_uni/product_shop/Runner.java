package soft_uni.product_shop;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.product_shop.io.reader.MyFileReader;
import soft_uni.product_shop.models.dtos.binding.category.CategoryCreateBindingModel;
import soft_uni.product_shop.models.dtos.binding.product.ProductCreateBindingModel;
import soft_uni.product_shop.models.dtos.binding.user.UserCreateBindingModel;
import soft_uni.product_shop.models.dtos.views.ProductInRangeViewModel;
import soft_uni.product_shop.services.category.CategoryService;
import soft_uni.product_shop.services.product.ProductService;
import soft_uni.product_shop.services.user.UserService;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

import static soft_uni.product_shop.default_values.constants.*;

@Component
@Transactional
public class Runner implements CommandLineRunner {

    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private MyFileReader fileReader;
    private Gson gson;

    @Autowired
    public Runner(UserService userService,
                  ProductService productService,
                  CategoryService categoryService,
                  MyFileReader fileReader,
                  Gson gson) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.fileReader = fileReader;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedUsers();
//        this.seedProducts();
//        this.seedCategories();
//        this.seedCategoriesInProducts();

        List<ProductInRangeViewModel> viewModels = this.productService.getAllByRangeWithoutBuyer(500, 1000);
        String toJson = this.gson.toJson(viewModels);
        this.writeToFile("/outputJson/products-in-range.json",toJson);

    }

    private void writeToFile(String fileName, String src) {
        try {
            String mainPath = System.getProperty("user.dir") + "/src/main/resources";
            FileWriter writer = new FileWriter(new File(mainPath + fileName));
            writer.write(src);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void seedCategoriesInProducts() {
        this.productService.seedCategories();
    }

    private void seedCategories() throws IOException {
        String categoriesJSON = fileReader.readFile(JSON_CATEGORIES_INPUT);

        Type listType = new TypeToken<List<CategoryCreateBindingModel>>() {
        }.getType();
        List<CategoryCreateBindingModel> categories = this.gson.fromJson(categoriesJSON, listType);

        this.categoryService.saveCategories(categories);
    }

    private void seedProducts() throws IOException {
        String productJSON = fileReader.readFile(JSON_PRODUCTS_INPUT);

        Type listType = new TypeToken<List<ProductCreateBindingModel>>() {
        }.getType();
        List<ProductCreateBindingModel> products = this.gson.fromJson(productJSON, listType);
        products.forEach(this::randomizeDataForProduct);
        this.productService.save(products);
    }

    private void randomizeDataForProduct(ProductCreateBindingModel model) {
        Random random = new Random();
        int buyer = random.nextInt(69);
        if (buyer <= 57) model.setBuyer(buyer);
        int seller = 0;
        do {
            seller = random.nextInt(57);
            model.setSeller(seller);
        } while (seller == buyer);
    }

    private void seedUsers() throws IOException {
        String usersJSON = fileReader.readFile(JSON_USERS_INPUT);

        Type listType = new TypeToken<List<UserCreateBindingModel>>() {
        }.getType();
        List<UserCreateBindingModel> users = this.gson.fromJson(usersJSON, listType);
        this.userService.saveUsers(users);
    }
}
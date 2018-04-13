package soft_uni.product_shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.product_shop.io.FileReaderMy;
import soft_uni.product_shop.io.FileWriterMy;
import soft_uni.product_shop.services.category.CategoryService;
import soft_uni.product_shop.services.product.ProductService;
import soft_uni.product_shop.services.user.UserService;

import javax.transaction.Transactional;
import java.io.IOException;

import static soft_uni.product_shop.default_values.constants.JSON_USERS_INPUT;

@Component
@Transactional
public class Runner implements CommandLineRunner {


    private UserService userService;
    private ProductService productService;
    private CategoryService categoryService;
    private FileReaderMy fileReader;
    private FileWriterMy fileWriter;

    @Autowired
    public Runner(UserService userService,
                  ProductService productService,
                  CategoryService categoryService,
                  FileReaderMy fileReader,
                  FileWriterMy fileWriter) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedUsers();

    }

    private void seedUsers() throws IOException {
        String s = fileReader.readFile(JSON_USERS_INPUT);
        String debug = "";
    }
}
package soft_uni.product_shop.io.reader;

import java.io.IOException;

public interface MyFileReader {

    String readFile(String fileName) throws IOException;
}
package soft_uni.product_shop.io.writer;

import java.io.IOException;

public interface MyFileWriter {
    void writeFile(String content, String fileName) throws IOException;
}

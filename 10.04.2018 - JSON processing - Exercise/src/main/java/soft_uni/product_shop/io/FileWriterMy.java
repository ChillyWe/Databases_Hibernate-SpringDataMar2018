package soft_uni.product_shop.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileWriterMy {

    public void writeFile (String content, String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(content);
            writer.flush();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //log here...
            }
        }
    }
}
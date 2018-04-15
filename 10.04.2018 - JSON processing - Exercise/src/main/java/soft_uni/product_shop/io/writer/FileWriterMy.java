package soft_uni.product_shop.io.writer;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileWriterMy implements MyFileWriter {

    @Override
    public void writeFile(String content, String fileName) throws IOException {
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
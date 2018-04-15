package soft_uni.product_shop.io.reader;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class FileReaderMy implements MyFileReader {

    @Override
    public String readFile (String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //Log here..
            }
        }
        return builder.toString();
    }
}
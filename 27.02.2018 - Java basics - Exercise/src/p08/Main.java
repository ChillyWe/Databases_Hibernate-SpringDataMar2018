package p08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> originalNumbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();
        int counter = 1;
        int maxCounter = 1;
        resultList.add(originalNumbers.get(0));

        for (int i = 0; i < originalNumbers.size() - 1; i++) {
            if (originalNumbers.get(i) < originalNumbers.get(i + 1)) {
                counter++;
                resultList.add(originalNumbers.get(i + 1));
            } else {
                counter = 1;
                resultList.clear();
                resultList.add(originalNumbers.get(i + 1));
            }
            if (counter > maxCounter) {
                finalList.clear();
                maxCounter = counter;
                finalList.addAll(resultList);
            }
        }
        if (maxCounter == 1) {
            System.out.println(originalNumbers.get(0));
            return;
        }
        System.out.println(String.join(" ", finalList.toString()
                .replace("[", "").replace(",", "").replace("]", "")));
    }
}
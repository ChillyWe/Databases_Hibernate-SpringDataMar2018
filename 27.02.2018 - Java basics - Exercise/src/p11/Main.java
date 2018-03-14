package p11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> intArray = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for(int i = 0; i < intArray.size(); i++) {
            int leftSum = 0;
            int rightSum = 0;
            for(int j = 0; j < i; j++) {
                leftSum += intArray.get(j);
            }
            for(int j = i + 1; j < intArray.size(); j++) {
                rightSum += intArray.get(j);
            }
            if(leftSum == rightSum) {
                System.out.print(i);
                return;
            }
        }
        System.out.print("no");
    }
}
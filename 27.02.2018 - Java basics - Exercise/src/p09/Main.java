package p09;

import java.util.Scanner;

/**
 * Created by Chilly on 09.04.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array = scanner.nextLine().split(" ");
        int length = array.length;

        int [] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        int longest = 0;
        int number = 0;

        for (int i = 0; i < length; i++) {
            int currentNumber = intArray[i];
            int count = 0;
            for (int j = i; j < length; j++) {
                if (currentNumber == intArray[j]) {
                    count++;
                }
                if (count > longest) {
                    longest = count;
                    number = currentNumber;
                }
            }
        }
        System.out.print(number);
    }
}
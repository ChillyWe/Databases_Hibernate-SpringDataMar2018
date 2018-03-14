package p07;

import java.util.Scanner;

/**
 * Created by Chilly on 08.04.2017 г..
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
        int bestStart = 0;
        int bestLen = 0;
        int start = intArray[0];
        int len = 0;
        for (int i = 0; i < length - 1; i++) {
            if (intArray[i] == intArray[i + 1]) {
                len++;
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = intArray[i];
                }
            } else if (intArray [i] != intArray[i + 1]) {
                start = intArray[i + 1];
                len = 0;
            }
        }
        for (int i = 0; i <= bestLen; i++) {
            System.out.print(bestStart + " ");
        }
    }
}
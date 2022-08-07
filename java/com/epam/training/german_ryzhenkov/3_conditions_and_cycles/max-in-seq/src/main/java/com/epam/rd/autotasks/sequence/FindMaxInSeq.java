package com.epam.rd.autotasks.sequence;
import java.util.*;

public class FindMaxInSeq {
    public static int max() {
        try (Scanner scanner = new Scanner(System.in)){
            int maxNumber = Integer.MIN_VALUE;
            int nextNumber;
            while (scanner.hasNextInt()) {
                nextNumber = scanner.nextInt();
                if (nextNumber == 0) break;
                if (nextNumber > maxNumber) {
                    maxNumber = nextNumber;
                }
            }
            return maxNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println(max());
    }
}

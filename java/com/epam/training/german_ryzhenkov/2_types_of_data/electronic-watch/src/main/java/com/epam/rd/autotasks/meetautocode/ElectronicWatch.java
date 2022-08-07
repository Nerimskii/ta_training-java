package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        int inputSeconds = new Scanner(System.in).nextInt();

        System.out.println(
                convertHours(inputSeconds / 60 / 60) +
                        ":" +
                        convertMinutesOrSeconds(inputSeconds / 60 % 60) +
                        ":" +
                        convertMinutesOrSeconds(inputSeconds % 60));
    }

    private static String convertHours(int hours) {
        return hours == 24 ? "0" : String.valueOf(hours);
    }
    private static String convertMinutesOrSeconds(int minutesOrSeconds) {
        return minutesOrSeconds < 10 ? "0" + minutesOrSeconds : "" + minutesOrSeconds;
    }
}


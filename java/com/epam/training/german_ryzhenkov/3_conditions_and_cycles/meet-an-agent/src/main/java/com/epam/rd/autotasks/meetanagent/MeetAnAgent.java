package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976;

    public static void main(String[] args) {
        System.out.println(new Scanner(System.in).nextInt() == PASSWORD ?
                "Hello, Agent" : "Access denied");
    }
}

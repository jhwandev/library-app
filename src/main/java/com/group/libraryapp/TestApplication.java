package com.group.libraryapp;

import java.util.Arrays;
import java.util.Scanner;

public class TestApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("input dice number");
        int diceNumber = scanner.nextInt();

        Dice dice = new Dice(diceNumber);
        System.out.println("created Dice - " + dice.getNumber());


        System.out.println("input roll count");
        int rollCount = scanner.nextInt();

        int[] result = dice.roll(rollCount);
        System.out.println("result - " + Arrays.toString(result));


    }
}


class Dice {
    private int number;

    public int getNumber() {
        return number;
    }

    public Dice(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("number is negative");
        }
        this.number = number; // 주사위 면 개수
    }

    // 주사위 굴리기
    int[] roll(int count) {
        int[] result = new int[number];
        for (int i = 0; i < count; i++) {
            double d = Math.random() * number;
            int num = (int) Math.floor(d);
            result[num]++;
        }
        return result;
    }
}


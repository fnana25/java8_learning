package com.test.enums;

import com.test.enums.enums.Coin;

public class ShowEnumDemo {

    public static void main(String[] args) {
        compareEnum(Coin.valueOf("dime"));
        System.out.println("--------------");
        show();
    }

    private static void compareEnum(Coin coin) {

        System.out.println(coin);

        for (Coin c : Coin.values()) {
            System.out.println(c.compareTo(coin));
        }
    }

    private static void show() {
        for (Coin c : Coin.values()) {
            System.out.printf("%d,%s,%n", c.ordinal(), c);
        }
    }
}

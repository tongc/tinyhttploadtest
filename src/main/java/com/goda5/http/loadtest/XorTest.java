package com.goda5.http.loadtest;

import com.google.common.collect.Maps;

import java.util.Map;

public class XorTest {
    private static Map<String, String> result = Maps.newHashMap();
    public static void main(String[] args) {
        result.put("a", "b");
        result.put("c", "d");

        Map<String, String> result2 = Maps.newHashMap(result);
        result2.put("f", "g");

        System.out.println("xor" + (0b111 ^ 0b101));
        System.out.println("xor" + (1 ^ 2));
        System.out.println("xor" + (100 ^ 200));
        System.out.println("xor" + (32 ^ 64));
        System.out.println("xor" + (64 ^ 32));
        System.out.println("xor" + (8 ^ 16));
        System.out.println("xor" + (96 ^ 32));
        System.out.println("xor" + (0b1100000 ^ 0b100000));
    }
}

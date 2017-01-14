package com.goda5.http.loadtest;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by tong on 14/01/2017.
 */
public class SmallRange {
    static final List<List<Integer>> numbers = Lists.newArrayList(
            Lists.newArrayList(1,2,3),
            Lists.newArrayList(2,3,4),
            Lists.newArrayList(3,4,5));
    public static void main(String[] args) {
        final List<Integer> positions = Lists.newArrayList();
        IntStream.range(0, numbers.size()).forEach(value -> positions.add(0));
        List<List<Integer>> result = Lists.newArrayList();
        int location = 0;
        while(true) {
            if(numbers.get(numbers.size() - 1).size()-1 == positions.get(positions.size() - 1)) {
                break;
            }
            List<Integer> eachResult = Lists.newArrayList();
            for(int i=0;i<positions.size();i++) {
                eachResult.add(numbers.get(i).get(positions.get(i)));
            }
            if(positions.get(location) == numbers.get(location).size() - 1) {
                ++location;
                for(int i=0;i<positions.size() - 1;i++) {
                    positions.set(i, 0);
                }
            }
            positions.set(location, positions.get(location) + 1);
            System.out.println(positions);
            result.add(eachResult);
        }
        System.out.println(result);
    }
}
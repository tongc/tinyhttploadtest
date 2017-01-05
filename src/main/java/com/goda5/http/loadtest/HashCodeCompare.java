package com.goda5.http.loadtest;

import com.google.common.collect.Maps;

import java.util.Map;

public class HashCodeCompare {

    class A {
        int a;
        public A(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a1 = (A) o;

            return a == a1.a;
        }

        @Override
        public int hashCode() {
            return a;
        }
    }

    class B {
        private final int a;

        public B(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        HashCodeCompare.A a = new HashCodeCompare().new A(1);
        HashCodeCompare.A b = new HashCodeCompare().new A(2);
        HashCodeCompare.A c = new HashCodeCompare().new A(3);

        Map<HashCodeCompare.A, String> hashMap = Maps.newHashMap();
        hashMap.put(a, "a");
        hashMap.put(b, "b");
        hashMap.put(c, "c");

        System.out.println(hashMap.get(a));
        a.a = 33333;
        System.out.println(hashMap.get(a));
    }

}

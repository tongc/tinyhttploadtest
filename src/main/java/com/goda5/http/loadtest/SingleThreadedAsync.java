package com.goda5.http.loadtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class SingleThreadedAsync {
    private final List<Function> tasks = new ArrayList<>();
    private volatile boolean change = false;
    private volatile int count = 0;

    public static void main(String[] args) {
        final SingleThreadedAsync object = new SingleThreadedAsync();
        object.tasks.add(new Function() {
            @Override
            public Object apply(Object o) {

                while (!object.change && object.count++ < 5) {
                    System.out.println("task " + object.tasks.indexOf(this) + " executing by thread " + Thread.currentThread().getName() + " @ " + new Date());
                }
                if (object.change && object.count++ == 6) {
                    System.out.println("task " + object.tasks.indexOf(this) + " executing by thread " + Thread.currentThread().getName() + " @ " + new Date());
                }
                return null;
            }
        });
        object.tasks.add(new Function() {
            @Override
            public Object apply(Object o) {
                if (!object.change) {
                    System.out.println("task " + object.tasks.indexOf(this) + " executing by thread " + Thread.currentThread().getName() + " @ " + new Date());
                    object.change = true;
                }
                return null;
            }
        });

        object.tasks.forEach(function -> function.apply(null));
        object.tasks.forEach(function -> function.apply(null));
        object.tasks.forEach(function -> function.apply(null));
        object.tasks.forEach(function -> function.apply(null));
        object.tasks.forEach(function -> function.apply(null));
        object.tasks.forEach(function -> function.apply(null));
    }
}

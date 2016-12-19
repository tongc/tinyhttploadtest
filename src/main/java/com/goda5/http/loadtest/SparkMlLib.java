package com.goda5.http.loadtest;

import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;

public class SparkMlLib {
    public static void main(String[] args) {
        Vector dense = Vectors.dense(1.0, 2.0, 3.0, 0.0, 0.0, 0.0);
        System.out.println(dense);
        System.out.println(dense.toSparse());
        dense = Vectors.dense(0.0, 2.0, 3.0);
        System.out.println(dense.toSparse());
        dense = Vectors.dense(1.0, 1.0, 0.0, 2.0, 3.0, 0.0, 0.0, 0.0, 8.0);
        System.out.println(dense.toSparse());
    }
}

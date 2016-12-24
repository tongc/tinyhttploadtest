package com.goda5.http.loadtest;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.mllib.stat.Statistics;

import java.util.List;

public class SparkMlLib {
    public static void main(String[] args) throws InterruptedException {
        sparseAndDenseArray();
        statistics();
    }

    private static void sparseAndDenseArray() {
        Vector dense = Vectors.dense(1.0, 2.0, 3.0, 0.0, 0.0, 0.0);
        System.out.println(dense);
        System.out.println(dense.toSparse());
        dense = Vectors.dense(0.0, 2.0, 3.0);
        System.out.println(dense.toSparse());
        dense = Vectors.dense(1.0, 1.0, 0.0, 2.0, 3.0, 0.0, 0.0, 0.0, 8.0);
        System.out.println(dense.toSparse());
    }

    private static void statistics() throws InterruptedException {
        SparkConf conf = new SparkConf()
                .setAppName("Spark Example")
                .setMaster("local[2]")
                .set("spark.executor.memory", "1G");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        List<Double> es = Lists.newArrayList(1.1, 2.2, 3.3, 4.4, 5.5);
        JavaDoubleRDD rdd1 = sparkContext.parallelizeDoubles(es);
        List<Double> es1 = Lists.newArrayList(2.1, 3.2, 4.3, 5.4, 6.5);
        JavaDoubleRDD rdd2 = sparkContext.parallelizeDoubles(es1);
        double dataSetCompare = Statistics.corr(rdd1.srdd(), rdd2.srdd(), "dataSetCompare");
        System.out.println("outoutout" + dataSetCompare);
    }
}

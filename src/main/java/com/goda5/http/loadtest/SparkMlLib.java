package com.goda5.http.loadtest;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.mllib.stat.Statistics;

import java.io.IOException;
import java.util.List;

public class SparkMlLib {
    public static void main(String[] args) throws InterruptedException, IOException {
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

    private static void statistics() throws InterruptedException, IOException {
        SparkConf conf = new SparkConf()
                .setAppName("Spark Example")
                .setMaster("local[2]")
                .set("spark.executor.memory", "1G");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
        List<Double> es = Lists.newArrayList(1.1, 2.2);
        JavaDoubleRDD rdd1 = sparkContext.parallelizeDoubles(es);
        List<Double> es1 = Lists.newArrayList(3.1, 4.2);
        JavaDoubleRDD rdd2 = sparkContext.parallelizeDoubles(es1);
        double dataSetCompare = Statistics.corr(rdd1.srdd(), rdd2.srdd(), "pearson");
        System.err.println("pearson coefficient" + dataSetCompare);
        dataSetCompare = Statistics.corr(rdd1.srdd(), rdd2.srdd(), "spearman");
        System.err.println("spearman coefficient" + dataSetCompare);
        System.in.read();
    }
}

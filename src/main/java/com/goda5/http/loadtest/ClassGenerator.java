package com.goda5.http.loadtest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 10/12/2016.
 * out of memory when compressed class space exceeded.
 * <img src="https://raw.githubusercontent.com/tongc/tinyhttploadtest/master/src/main/resources/compressedspaceoom.png"/>
 * out of memory when entire metaspace is filled up.
 * <img src="https://raw.githubusercontent.com/tongc/tinyhttploadtest/master/src/main/resources/metaspacefilledup.png"/>
 */
public class ClassGenerator {
    private static final int BUFFER = 1024;
    private List<Class<?>> classList = new ArrayList<Class<?>>();

    public static void main(String[] args) {
        ClassGenerator classGenerator = new ClassGenerator();
        // Load just some class with class loaders until perm gen space fills.
        // before metaspace is all filled up, the compressed space will be filled up first
        //-XX: CompressedClassSpaceSize=4g, exceeds acceptable bounds will result in a message such as
        //CompressedClassSpaceSize of 4294967296 is invalid; must be between 1048576 and 3221225472.
        //to disable compressed class space, use -XX:-UseCompressedClassPointers
        while (true) {
            classGenerator.classLoader();
        }
    }

    private void classLoader() {
        ClassLoader classLoader = new ClassLoader() {
            public Class<?> loadClass(String classNameWithPackage)
                    throws ClassNotFoundException {
                if (!classNameWithPackage.contains("DummyClass")) {
                    return super.loadClass(classNameWithPackage);
                }
                String className = classNameWithPackage.replace('.', '/')
                        + ".class";
                byte[] classData = null;
                InputStream inputStream = null;
                try {
                    inputStream = getResourceAsStream(className);
                    byte[] buffer = new byte[BUFFER];
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer, 0, BUFFER)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    classData = outputStream.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                Class<?> c = defineClass(classNameWithPackage, classData, 0,
                        classData.length);
                resolveClass(c);
                //dont print so it fill up the memory faster
//                System.out.println("Steve I am loading another copy of Dummy class. Soon Permgen will fill.");
                classList.add(c);
                return c;
            }
        };

        try {
            Class.forName("com.goda5.http.loadtest.DummyClass", true, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
package com.goda5.http.loadtest;

public class Test {
    /**
     * Run javap -v Test i receive the following
     *
     C:\Users\tong\git\tinyhttploadtest\target\classes\com\goda5\http\loadtest>javap -v Test
     Warning: Binary file Test contains com.goda5.http.loadtest.Test
     Classfile /C:/Users/tong/git/tinyhttploadtest/target/classes/com/goda5/http/loadtest/Test.class
     Last modified 10-Dec-2016; size 561 bytes
     MD5 checksum d8d7c6cce1ed3906fab218238a1fe730
     Compiled from "Test.java"
     public class com.goda5.http.loadtest.Test
     minor version: 0
     major version: 52
     flags: ACC_PUBLIC, ACC_SUPER
     Constant pool:
     #1 = Methodref          #6.#20         // java/lang/Object."<init>":()V
     #2 = Fieldref           #21.#22        // java/lang/System.out:Ljava/io/PrintStream;
     #3 = String             #23            // testhello
     #4 = Methodref          #24.#25        // java/io/PrintStream.println:(Ljava/lang/String;)V
     #5 = Class              #26            // com/goda5/http/loadtest/Test
     #6 = Class              #27            // java/lang/Object
     #7 = Utf8               <init>
     #8 = Utf8               ()V
     #9 = Utf8               Code
     #10 = Utf8               LineNumberTable
     #11 = Utf8               LocalVariableTable
     #12 = Utf8               this
     #13 = Utf8               Lcom/goda5/http/loadtest/Test;
     #14 = Utf8               main
     #15 = Utf8               ([Ljava/lang/String;)V
     #16 = Utf8               args
     #17 = Utf8               [Ljava/lang/String;
     #18 = Utf8               SourceFile
     #19 = Utf8               Test.java
     #20 = NameAndType        #7:#8          // "<init>":()V
     #21 = Class              #28            // java/lang/System
     #22 = NameAndType        #29:#30        // out:Ljava/io/PrintStream;
     #23 = Utf8               testhello
     #24 = Class              #31            // java/io/PrintStream
     #25 = NameAndType        #32:#33        // println:(Ljava/lang/String;)V
     #26 = Utf8               com/goda5/http/loadtest/Test
     #27 = Utf8               java/lang/Object
     #28 = Utf8               java/lang/System
     #29 = Utf8               out
     #30 = Utf8               Ljava/io/PrintStream;
     #31 = Utf8               java/io/PrintStream
     #32 = Utf8               println
     #33 = Utf8               (Ljava/lang/String;)V
     {
     public com.goda5.http.loadtest.Test();
     descriptor: ()V
     flags: ACC_PUBLIC
     Code:
     stack=1, locals=1, args_size=1
     0: aload_0
     1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     4: return
     LineNumberTable:
     line 3: 0
     LocalVariableTable:
     Start  Length  Slot  Name   Signature
     0       5     0  this   Lcom/goda5/http/loadtest/Test;

     public static void main(java.lang.String[]);
     descriptor: ([Ljava/lang/String;)V
     flags: ACC_PUBLIC, ACC_STATIC
     Code:
     stack=2, locals=1, args_size=1
     0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     3: ldc           #3                  // String testhello
     5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     8: return
     LineNumberTable:
     line 5: 0
     line 6: 8
     LocalVariableTable:
     Start  Length  Slot  Name   Signature
     0       9     0  args   [Ljava/lang/String;
     }
     SourceFile: "Test.java"

     * @param args
     */
    public static void main(String[] args) {
        System.out.println("testhello");
    }
}

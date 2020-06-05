package club.justwrite.java;

import club.justwrite.java.io.Printer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.*;

public class Temp {

    public static void main(String[] args) {

//        ExecutorService executors = Executors.newCachedThreadPool();
//        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(3000);
//                return "Complete";
//            }
//        }){
//            @Override
//            protected void done() {
//                super.done();
//                Printer.print("done");
//            }
//        };
//        executors.execute(futureTask);
//        try {
//            Printer.print(futureTask.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        Printer.print("come");
//        executors.shutdownNow();
        String str1 = "Hello World!";
        String str2 = "Hello World!";
        String str3 = new String("Hello World!");
        Printer.print(str1==str2);
        Printer.print(str1 == str3.intern());
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1", "hello");
        linkedHashMap.put("2", "你好");
        linkedHashMap.put("3", "你好ma");
        Printer.print(linkedHashMap);
    }

    public <T extends Parent> T print(int id){
        return (T) new Child();
    }

    private void test(){
        Child parent = print(0);
    }

    private void test2(){
        Parent parent = print(0);
    }

    enum Type{
        INT,
        FLOAT,
        DOUBLE,
        STRING
    }

    private class Parent {

    }

    private class Child extends Parent{

    }
}

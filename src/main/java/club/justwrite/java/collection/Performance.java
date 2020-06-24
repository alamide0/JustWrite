package club.justwrite.java.collection;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/15
 **/
public class Performance {


    public static void main(String[] args) {
        Performance performance = new Performance();
        int loops = 1000;
        int size =1000000;
        List<Integer> arrayList = performance.arrayList(size);
        List<Integer> linkedList = performance.linkedList(size);


        int max = 0;


        long start = System.nanoTime();

        for(int i=0; i < loops; i++){
            for (Integer in : arrayList) {
                int tmp = in;
                if(tmp > max){
                    max = tmp;
                }
            }
        }



        Printer.print((System.nanoTime() - start)/loops);

        max = 0;

        long t = System.nanoTime();

        for(int j=0; j < loops; j++){
            for (int i = 0; i < arrayList.size(); i++) {
                int tmp = arrayList.get(i);
                if(tmp > max){
                    max = tmp;
                }
            }
        }


        Printer.print((System.nanoTime() - t)/loops);




    }


    public List<Integer> arrayList(int size) {
        List<Integer> res = new ArrayList<>(size);
        fillList(res, size);
        return res;
    }

    private void fillList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public List<Integer> linkedList(int size) {
        List<Integer> res = new LinkedList<>();
        fillList(res, size);
        return res;
    }
}

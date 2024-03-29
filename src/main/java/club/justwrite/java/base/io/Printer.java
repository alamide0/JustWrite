package club.justwrite.java.base.io;

import java.util.Arrays;

public class Printer {
    public static void print(Object info) {
        if(info == null) {
            System.out.println("info = " + null);
            return;
        }
        if (info.getClass().isArray()) {
            Class cls = info.getClass().getComponentType();
            if (cls == String.class) {
                String[] strings = (String[]) info;
                for (String string : strings) {
                    System.out.println(string);
                }
            } else if (cls == int.class) {
                System.out.println(Arrays.toString((int[]) info));
            } else if (cls == int[].class) {
                int[][] ints = (int[][]) info;
                for (int[] i : ints) {
                    Printer.print(i);
                }
            }else if(cls == char.class) {
                System.out.println(Arrays.toString((char[]) info));
            } else {
                System.out.println(Arrays.toString((Object[]) info));
            }
        } else {
            System.out.println(info.toString());
        }


    }



    public static void printDivider(String divider, int dividerLength) {
        if (dividerLength <= 0) return;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < dividerLength; i++) {
            builder.append(divider);
        }

        Printer.print(builder.toString());
    }

    public static void printDivider() {
        printDivider("=", 30);
    }

}

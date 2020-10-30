package club.justwrite.java;

import club.justwrite.java.io.Printer;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.*;

public class Temp {


    public static void main(String[] args) {

        int a = 1 << 3;

        int b = 1 << 3 | 1 << 4 | 1 << 2 | 1 << 1;

        Printer.print(a + ", " + b);
        Printer.print(Integer.toBinaryString(a));
        Printer.print(Integer.toBinaryString(b));

        Printer.print((a & b) == a);
        Printer.print( Integer.toBinaryString(a ^ b));
        Printer.print(a ^ b);
    }


}




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

        long t = System.currentTimeMillis();


        Printer.print(TimeZone.getDefault().getOffset(new Date().getTime())/1000/3600);
        Printer.print(new Date());
        Printer.print(t - t % (3600 * 24 * 1000) + 3600 * 24 * 1000 - TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }


}




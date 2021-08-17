package club.justwrite.java;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Temp {


    public static void main(String[] args) throws IOException, URISyntaxException {
        Date date = new Date();
        System.out.println("date = " + date);
        System.out.println("date.getYear() = " + date.getYear());
        System.out.println(date.toGMTString());
        System.out.println(date.toLocaleString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss W w yyy D d a K S z Z X F E u M MM MMM MMMM");
        System.out.println(simpleDateFormat.format(date));

        LocalDate d = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("d = " + d);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println(date.getMonth());
        System.out.println(localDateTime.getMonthValue());

        LocalDateTime localDateTime1 = LocalDateTime.parse("1999-01-01T08:08:08");
        System.out.println("localDateTime1 = " + localDateTime1);


    }




}




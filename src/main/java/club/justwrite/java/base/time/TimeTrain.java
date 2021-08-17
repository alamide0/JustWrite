package club.justwrite.java.base.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TimeTrain {
    public static void main(String[] args) {

    }

    @Test
    public void testLocalDateTime() {
        LocalDate localDate = LocalDate.of(2021, 7, 8);
        System.out.println("localDate = " + localDate);

        LocalTime localTime = LocalTime.of(1, 1);
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));

        final LocalDateTime parse = LocalDateTime.parse("2021-10-10 14:14:13", dateTimeFormatter);
        System.out.println("parse = " + parse);

        final LocalDateTime localDateTime1 = localDateTime.plusDays(3).minusHours(10);
        System.out.println("localDateTime1 = " + localDateTime1);

        final LocalDateTime localDateTime2 = localDateTime1.minusMonths(1);
        System.out.println("localDateTime2 = " + localDateTime2);

        final LocalDateTime localDateTime3 = localDateTime2.withHour(10);
        System.out.println("localDateTime3 = " + localDateTime3);

        final LocalDateTime localDateTime4 = localDateTime3.withDayOfMonth(30);
        System.out.println("localDateTime4 = " + localDateTime4);

        final LocalDateTime localDateTime5 = localDateTime4.withMonth(2);
        System.out.println("localDateTime5 = " + localDateTime5);

        LocalDateTime localDateTime6 = LocalDate.now().withDayOfMonth(1).atStartOfDay();

        System.out.println("localDateTime6 = " + localDateTime6);

        final LocalDate with = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("with = " + with);

        final LocalDate with1 = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("with1 = " + with1);

        final LocalDate with2 = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("with2 = " + with2);

        final LocalDateTime now = LocalDateTime.now();

        final LocalDateTime localDateTime8 = LocalDate.now().minusMonths(1).atStartOfDay();

        System.out.println(now.isAfter(localDateTime8));
        System.out.println(now.isBefore(localDateTime8));
    }

    @Test
    public void testDuration() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 6, 7, 8, 8);
        final LocalDateTime now = LocalDateTime.now();

        final Duration between = Duration.between(localDateTime, now);
        System.out.println(between.toString());

        final Period between1 = Period.between(localDateTime.toLocalDate(), now.toLocalDate());
        System.out.println("between1 = " + between1.getDays());
    }

    @Test
    public void testZonedDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);

        final ZonedDateTime zonedDateTime3 = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("zonedDateTime3 = " + zonedDateTime3);

        final LocalDateTime localDateTime = zonedDateTime3.toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);

        final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("now = " + now);

        LocalDateTime ldt = LocalDateTime.of(2021, 7,7,7,7,7);
        final ZonedDateTime zonedDateTime1 = ldt.atZone(ZoneId.systemDefault());
        final ZonedDateTime zonedDateTime2 = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);
        System.out.println("zonedDateTime2 = " + zonedDateTime2);

        System.out.println(calculateArrivalAtNY(zonedDateTime.toLocalDateTime(), 13,20));
    }

    LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {

        final ZonedDateTime zonedDateTime = bj.plusHours(h).plusMinutes(m).atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("zonedDateTime = " + zonedDateTime.toLocalDateTime());

        final LocalTime from = LocalTime.from(bj.plusHours(h).plusMinutes(m).atZone(ZoneId.of("America/New_York")));
        System.out.println("from = " + from);

        return bj.plusHours(h).plusMinutes(m).atZone(ZoneId.of("America/New_York")).toLocalDateTime();
    }

    @Test
    public void testDateTimeFormatter(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE ZZZZ", Locale.US);
        ZonedDateTime localDateTime = ZonedDateTime.now();
        System.out.println(dateTimeFormatter.format(localDateTime));

        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));

        System.out.println(Instant.now().getEpochSecond());
        System.out.println(System.currentTimeMillis());

        final ZonedDateTime zonedDateTime = Instant.ofEpochSecond(1625747611).atZone(ZoneId.systemDefault());
        System.out.println("zonedDateTime = " + zonedDateTime);
    }
}

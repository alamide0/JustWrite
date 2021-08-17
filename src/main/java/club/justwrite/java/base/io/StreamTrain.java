package club.justwrite.java.base.io;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTrain {
    public static void main(String[] args) {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());

        natual.limit(0).forEach(System.out::println);

        Pattern pattern = Pattern.compile("\\s+");
        final Stream<String> stream = pattern.splitAsStream("zhe shi yi ge ren ya ");

        stream.forEach(System.out::println);

        System.out.println("-=------");

        IntStream fib = IntStream.generate(new FibonacciStream());

        fib.limit(20).forEach(System.out::println);

        final List<String> collect = Stream.of(" Apple ", " pear", " ORANGE", " BaNaNa")
                .map(String::trim)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("collect = " + Arrays.toString(collect.stream().toArray(String[]::new)));

        Stream.of("2019 -10-10", "2020-01-01", "2021-1 2-1 2 ")
                .map(s -> s.replace(" ", ""))
                .map(LocalDate::parse)
                .forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        int sum = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        int s = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(1, (acc, n) -> acc * n);

        System.out.println("s = " + s);

        final Map<String, String> collect1 = Stream.of("name:zhaosiyuan", "age:23", "address:nanjing")
                .collect(Collectors.toMap(
                        ss -> ss.substring(0, ss.indexOf(":")),
                        ss -> ss.substring(ss.indexOf(":") + 1)
                ));
        System.out.println("collect1 = " + collect1);

        final Map<String, List<String>> collect2 = Stream.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots")
                .collect(Collectors.groupingBy(ss -> ss.substring(0, 1), Collectors.toList()));
        System.out.println("collect2 = " + collect2);

        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        IntStream intStream2 = IntStream.of(10,12,3,4,5,6,666);

        final boolean b = IntStream.concat(intStream1, intStream2)
                .distinct()
                .parallel()
                .anyMatch(n -> n > 100);
        System.out.println("max = " + b);
    }

    public static class Person {

        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class NatualSupplier implements Supplier<Integer> {

        int n = 0;

        @Override
        public Integer get() {
            n++;
            return n;
        }
    }

    public static class FibonacciStream implements IntSupplier {

        int n1 = 1;
        int n2 = 1;

        @Override
        public int getAsInt() {
            int tmp = n1;
            n1 = n2;
            n2 = tmp + n2;
            return tmp;
        }
    }
}

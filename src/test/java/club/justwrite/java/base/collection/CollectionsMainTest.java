package club.justwrite.java.base.collection;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.*;

public class CollectionsMainTest {
    @Test
    public void testEnumMap() {
        Map<DayOfWeek, String> map = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println("map = " + map);
        System.out.println("map.get(DayOfWeek.FRIDAY) = " + map.get(DayOfWeek.FRIDAY));
    }

    @Test
    public void testTreeMap(){
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key: map.keySet()){
            System.out.println("key = " + key);
        }

        Map<Student, Integer> treeMap = new TreeMap<>();
        treeMap.put(new Student(90, "lucy", 16), 22);
        treeMap.put(new Student(99, "simon", 16), 222);
        treeMap.put(new Student(89, "tom", 16), 2222);
        System.out.println("treeMap = " + treeMap);

        final Integer lucy = treeMap.get(new Student(992, "sssssss", 16));
        System.out.println(new Student(99, "lucy", 16).hashCode());
        System.out.println(new Student(99, "simon", 16).hashCode());
        System.out.println(new Student(99, "simon", 16).equals(new Student(99, "lucy", 16)));
        System.out.println("lucy = " + lucy);
    }

    @Test
    public void testProperties() throws IOException {
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        assert is != null;
        properties.load(new InputStreamReader(is, StandardCharsets.UTF_8.name()));
        final String name = properties.getProperty("name");
        System.out.println("name = " + name);

        String settings = "# this is a comment\ndebug=true\n username=alamide";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(settings.getBytes(StandardCharsets.UTF_8));
        properties.load(byteArrayInputStream);
        final String username = properties.getProperty("username");
        System.out.println("username = " + username);

        properties.setProperty("name", "alamide");
        properties.store(new FileOutputStream("out.properties"), "this is a comment");
    }

    @Test
    public void testSet(){
        Set<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("0");
        strings.add("122330");
        strings.remove("3");
        System.out.println("strings = " + strings);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("abcd");
        treeSet.add("ssddsdsd");
        System.out.println("treeSet = " + treeSet);
    }

    @Test
    public void testQueue(){
        Queue<Student> studentQueue = new LinkedList<>();
        studentQueue.offer(new Student(90, "lucy", 16));
        studentQueue.offer(new Student(98, "simon", 18));
        studentQueue.offer(new Student(89, "dark", 19));
        final Student poll = studentQueue.poll();
        System.out.println("poll = " + poll);
    }

    @Test
    public void testPriorityQueue(){
        Queue<Student> studentQueue = new PriorityQueue<>();
        studentQueue.offer(new Student(90, "lucy", 16));
        studentQueue.offer(new Student(98, "simon", 18));
        studentQueue.offer(new Student(89, "dark", 19));

        System.out.println("studentQueue = " + studentQueue);
    }

    @Test
    public void testStack(){
        Deque<String> stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println("stack = " + stack);
        final String s = stack.pop();
        System.out.println("s = " + s);
        System.out.println("stack = " + stack);
    }
}
package club.justwrite.java.base.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {
    private int score;
    private String name;
    private int age;


    @Override
    public int compareTo(@NotNull Student o) {
        return o.score - score;
    }
}

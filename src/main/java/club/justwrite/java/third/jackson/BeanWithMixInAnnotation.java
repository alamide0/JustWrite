package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class BeanWithMixInAnnotation {
    public int id;
    public String name;
    public User user;

    public BeanWithMixInAnnotation(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    @JsonIgnoreType
    public static class MyMixInForIgnoreType {

    }

}

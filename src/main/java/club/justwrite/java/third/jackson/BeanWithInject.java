package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonSetter;

public class BeanWithInject {
//    @JacksonInject
    public int id;

    private String name;

    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanWithInject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

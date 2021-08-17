package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"name", "id"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MyBean {
    private String name;

    @JsonProperty("aId")
    public int id;

    public MyBean() {
    }

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

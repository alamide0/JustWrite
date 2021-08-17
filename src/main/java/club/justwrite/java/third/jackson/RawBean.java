package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {
    public String name;

    @JsonRawValue(value = false)
    public String json;

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }
}

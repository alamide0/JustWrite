package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {
    public String name;
    public Map<String, String> properties = new HashMap<>();


    @JsonAnyGetter(enabled = true)
    public Map<String, String> getProperties() {
        return properties;
    }


    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String toString() {
        return "ExtendableBean{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}

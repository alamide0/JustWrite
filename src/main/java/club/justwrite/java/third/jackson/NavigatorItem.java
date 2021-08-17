package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NavigatorItem {
    public String desc;
    public String path;

    @JsonProperty("target_class_path")
    public String targetClasspath;
}

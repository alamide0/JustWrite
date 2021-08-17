package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class UserWithRef {
    public int id;
    public String name;

    public UserWithRef(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonBackReference
    public List<ItemWithRef> userItems = new ArrayList<>();
}

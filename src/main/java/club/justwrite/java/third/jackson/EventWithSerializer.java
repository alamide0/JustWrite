package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class EventWithSerializer {
    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

    public EventWithSerializer() {
    }

    public EventWithSerializer(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "EventWithSerializer{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}

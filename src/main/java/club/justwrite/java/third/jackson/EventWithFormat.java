package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EventWithFormat {
    public String name;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd hh:mm:ss"
    )
    public Date eventDate;

    public EventWithFormat() {
    }

    public EventWithFormat(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}

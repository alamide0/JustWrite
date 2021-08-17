package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomCarDeserializer extends StdDeserializer<Car> {
    public CustomCarDeserializer() {
        this(null);
    }

    protected CustomCarDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Car deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Car car = new Car();
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);

        JsonNode colorNode = node.get("color");
        String color = colorNode.asText();
        car.color = color;
        return car;
    }
}

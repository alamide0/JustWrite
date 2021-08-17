package club.justwrite.java.base.serialize.gson;

import club.justwrite.java.base.processor.Execute;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

import static club.justwrite.java.base.io.Printer.print;

@Execute
public class GsonTrain {

    //    @Execute
    private static void primitive() {

        Gson gson = new Gson();
        print(gson.toJson(1));
        print(gson.toJson(3.4f));
        print(gson.toJson("hello gson"));
        int[] ints = {1, 2, 3};
        print(gson.toJson(ints));

        print(gson.fromJson("1", int.class));
        print(gson.fromJson("123", String.class));
        print(gson.fromJson("[1,2,3]", String[].class));
    }

    //    @Execute
    private static void obj() {
        Person person = new Person();
        Gson gson = new Gson();
        print(gson.toJson(person));
    }

    //    @Execute
    private static void array() {
        Gson gson = new Gson();
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        String json = gson.toJson(integerList);


        print(json);

        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> list = gson.fromJson(json, listType);
        print(list);
    }

    //    @Execute
    private static void generic() {
        Holder<Person> personHolder = new Holder<>();
        personHolder.t = new Person();

        Gson gson = new Gson();


        Type type = new TypeToken<Holder<Person>>() {
        }.getType();

        String json = gson.toJson(personHolder, type);
        print(json);

        Holder<Person> holder = gson.fromJson(json, type);

        print(holder.t.name);
    }

    //    @Execute
    private static void customSerialize() {
        Gson gson = new Gson();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateSerialize());
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserialize());

        print(gson.toJson(new Date()));

        gson = gsonBuilder.create();
        String time = gson.toJson(new Date());
        print(time);
        Date date = gson.fromJson(time, Date.class);
        print(date.getYear());
    }

    @Execute
    private static void typeAdapter() {
        Container container = new Container();
        container.name = "dajiahao";
        container.hashMap.put("$name", "zhaoxiaosi");
        Gson gson = new Gson();
        print(gson.toJson(container));
    }

    private static class Person {
        private String name = "zhaoxiaosi";
        private int age = 26;
        private transient int sex = 1;
        private AddressInfo addressInfo = new AddressInfo();

        static class AddressInfo {
            private String country = "中国";
        }
    }

    private static class Holder<T> {
        T t;
    }


    private static class Container {
        public String name;
        HashMap<String, String> hashMap = new HashMap<>();
    }

    private static class DateSerialize implements JsonSerializer<Date> {

        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(date.getTime());
        }
    }

    private static class DateDeserialize implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

            return new Date(jsonElement.getAsLong());

        }
    }


}

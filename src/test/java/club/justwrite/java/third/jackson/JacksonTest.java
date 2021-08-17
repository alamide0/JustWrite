package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonTest {
    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean extendableBean = new ExtendableBean();
        extendableBean.getProperties().put("attr1", "val1");
        extendableBean.getProperties().put("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(extendableBean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonGetter() throws JsonProcessingException {
//        MyBean bean = new MyBean(1, "my bean");
//        String result = new ObjectMapper().writeValueAsString(bean);
//        System.out.println("result = " + result);
    }

    @Test
    public void testJsonValue() throws JsonProcessingException {
        String enumString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println("enumString = " + enumString);
    }

    @Test
    public void testJsonRawValue() throws JsonProcessingException {
        RawBean rawBean = new RawBean("my bean", "{\"attr\":false}");
        final String result = new ObjectMapper().writeValueAsString(rawBean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonRootName() throws JsonProcessingException {
        UserWithRoot user = new UserWithRoot(1, "alamide");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        final String result = objectMapper.writeValueAsString(user);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonSerialize() throws JsonProcessingException {
        EventWithSerializer eventWithSerializer = new EventWithSerializer("test", new Date());
        final String result = new ObjectMapper().writeValueAsString(eventWithSerializer);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonCreator() throws JsonProcessingException {
        String json = "{\"id\":1,\"theName\": \"alamide\"}";
        final BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
        System.out.println("bean = " + bean);
    }

    @Test
    public void testJacksonInject() throws JsonProcessingException {
        String json = "{\"name\": \"alamide\", \"id\": 3}";
        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
        final BeanWithInject beanWithInject = new ObjectMapper().reader(inject).forType(BeanWithInject.class).readValue(json);
        System.out.println("beanWithInject = " + beanWithInject);
    }

    @Test
    public void testJsonAnySetter() throws JsonProcessingException {
        String json = "{ \"attr1\":\"val1\", \"name\":\"My bean\",\"attr2\":\"val2\",\"name2\":\"My bean\"}";
        ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);
        System.out.println("bean = " + bean);
    }

    @Test
    public void testJsonSetter() throws JsonProcessingException {
        String json = "{\"id\":1, \"name\":\"alamide\"}";
        final BeanWithInject myBean = new ObjectMapper().readerFor(BeanWithInject.class).readValue(json);
        System.out.println("myBean = " + myBean);
    }

    @Test
    public void testDeserializer() throws JsonProcessingException {
        String json = "{\"name\":\"study\",\"eventDate\":\"2021-07-15 20:11:11\"}";
        final EventWithSerializer event = new ObjectMapper().readerFor(EventWithSerializer.class).readValue(json);
        System.out.println("event = " + event);
    }

    @Test
    public void testJsonAlias() throws JsonProcessingException {
        String json = "{\"first_name\":\"zhao\",\"lastName\":\"siyuan\"}";
        final AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
        System.out.println("aliasBean = " + aliasBean);
    }

    @Test
    public void testJsonIgnoreProperties() throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "ignore");
        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonIgnoreType() throws JsonProcessingException {
        User.Name name = new User.Name("zhao", "siyuan");
        User user = new User(1, name);
        final String result = new ObjectMapper().writeValueAsString(user);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonInclude() throws JsonProcessingException {
        MyBean bean = new MyBean(0, null);
        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonAutoDetect() throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "alamide");
        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonPolymorphic() throws JsonProcessingException {
//        Zoo.Dog dog = new Zoo.Dog(100, "lucy");
//        Zoo zoo = new Zoo(dog);
//        final String result = new ObjectMapper().writeValueAsString(zoo);
//        System.out.println("result = " + result);
        String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}}";
//        String json = "{\"animal\":{\"name\":\"lucy\",\"type\":\"cat\"}}";
        Zoo cat = new ObjectMapper().readerFor(Zoo.class).readValue(json);
        System.out.println("cat = " + cat.animal.getClass());
    }

    @Test
    public void testJsonProperty() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "bean");
        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);

        final MyBean myBean = new ObjectMapper().readerFor(MyBean.class).readValue(result);
        System.out.println("myBean = " + myBean);
    }

    @Test
    public void testJsonFormat() throws ParseException, JsonProcessingException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = "2021-07-16 08:08:08";

        EventWithFormat eventWithFormat = new EventWithFormat("jsonFormat", simpleDateFormat.parse(date));
        final String result = new ObjectMapper().writeValueAsString(eventWithFormat);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonUnwrapped() throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("zhao", "xiaosi");
        UnwrappedUser user = new UnwrappedUser(1, name);
        final String result = new ObjectMapper().writeValueAsString(user);
        System.out.println("result = " + result);
    }

    @Test
    public void testJsonView() throws JsonProcessingException {
        Item item = new Item(1, "itemName", "ownerName");
        final String result = new ObjectMapper().writerWithView(Views.Public.class).writeValueAsString(item);
        System.out.println("result = " + result);
    }

    @Test
    public void testReference() throws JsonProcessingException {
        UserWithRef user = new UserWithRef(1, "john");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        user.userItems.add(item);
        final String result = new ObjectMapper().writeValueAsString(item);
        System.out.println("result = " + result);

        ItemWithRef itemWithRef = new ObjectMapper().readerFor(ItemWithRef.class).readValue(result);
        System.out.println("itemWithRef = " + itemWithRef);
    }

    @Test
    public void testJsonIdentityInfo() throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        user.userItems = new ArrayList<>();
        user.userItems.add(item);

        final String result = new ObjectMapper().writeValueAsString(item);
        System.out.println("result = " + result);

        final Object o = new ObjectMapper().readerFor(ItemWithIdentity.class).readValue(result);
        System.out.println("o = " + o);
    }

    @Test
    public void testJsonFilter() throws JsonProcessingException {
        BeanWithFilter bean = new BeanWithFilter(1, "filter");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));
        final String result = new ObjectMapper().writer(filterProvider).writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testJacksonAnnotation() throws JsonProcessingException {
        BeanWithCustomAnnotation bean = new BeanWithCustomAnnotation(1, "bean", null);
        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testMixInAnnotation() throws JsonProcessingException {
        BeanWithMixInAnnotation bean = new BeanWithMixInAnnotation(1, "mixin", null);
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println("result = " + result);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(User.class, BeanWithMixInAnnotation.MyMixInForIgnoreType.class);
        result = objectMapper.writeValueAsString(bean);
        System.out.println("result = " + result);
    }

    @Test
    public void testDisableJacksonAnnotation() throws JsonProcessingException {
        MyBean myBean = new MyBean(1, null);
        String result = new ObjectMapper().writeValueAsString(myBean);
        System.out.println("result = " + result);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
        result = objectMapper.writeValueAsString(myBean);
        System.out.println("result = " + result);
    }

    @Test
    public void testSerialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("target/car.json"), car);
        final String result = objectMapper.writeValueAsString(car);
        car = objectMapper.readValue(result, Car.class);
        System.out.println("car = " + car);
    }

    @Test
    public void testSerializeFromFile() throws IOException {
        final Car car = new ObjectMapper().readValue(new URL("file:target/car.json"), Car.class);
        System.out.println("car = " + car);
    }

    @Test
    public void testJsonNode() throws JsonProcessingException {
        String json = "{\"color\":\"Black\",\"type\":\"FIAT\"}";
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        String color = jsonNode.get("color").asText();
        System.out.println("color = " + color);
    }

    @Test
    public void testCreateJavaList() throws JsonProcessingException {
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = new ObjectMapper().readValue(jsonCarArray, new TypeReference<List<Car>>() {
        });
        System.out.println("listCar = " + listCar);
    }

    @Test
    public void testCreateJavaMap() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

        final Map<String, Object> stringObjectMap = new ObjectMapper().readValue(json, new TypeReference<Map<String, Object>>() {
        });

        System.out.println("stringObjectMap = " + stringObjectMap);
    }

    @Test
    public void testReadJsonFromFile() {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("tools_config.json")) {
            final JsonNode jsonNode = new ObjectMapper().readTree(is);
            final String navigator = jsonNode.get("navigator").textValue();
            System.out.println("navigator = " + navigator);
            final List<NavigatorItem> navigatorItems = new ObjectMapper().readValue(jsonNode.get("navigator").textValue(), new TypeReference<List<NavigatorItem>>() {
            });
//
//            System.out.println("navigatorItems = " + navigatorItems.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonHasNewFields() throws JsonProcessingException {
        String jsonString
                = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Car car = objectMapper.readValue(jsonString, Car.class);
        System.out.println("car = " + car);
    }

    @Test
    public void testCustomSD() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
        simpleModule.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(simpleModule);
        final String result = mapper.writeValueAsString(new Car("yellow", "renault"));
        System.out.println("result = " + result);

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        SimpleModule deModule = new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        deModule.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(deModule);
        final Car car = mapper.readValue(json, Car.class);
        System.out.println("car = " + car);
    }

    @Test
    public void testDateFormat() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a z");
        mapper.setDateFormat(format);
        Request request = new Request(new Car("yellow", "bw"), new Date());
        final String result = mapper.writeValueAsString(request);
        System.out.println("result = " + result);
    }

    @Test
    public void testCollections() throws JsonProcessingException {
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//        Car[] cars = mapper.readValue(jsonCarArray, Car[].class);
//
//        System.out.println("cars = " + Arrays.toString(cars));
        final Car[] cars1 = mapper.readValue(jsonCarArray, new TypeReference<Car[]>() {
        });
        System.out.println("cars1 = " + Arrays.toString(cars1));
    }
}
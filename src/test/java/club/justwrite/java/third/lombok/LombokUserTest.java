package club.justwrite.java.third.lombok;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Arrays;

public class LombokUserTest {
    @Test
    public void testLombok(){
        final Constructor<?>[] constructors = LombokUser.class.getConstructors();
//        System.out.println("lombokUser = " + lombokUser);
        System.out.println("constructors = " + Arrays.toString(constructors));
        final Type[] genericParameterTypes = constructors[0].getGenericParameterTypes();
        System.out.println("genericParameterTypes = " + Arrays.toString(genericParameterTypes));
//        LombokUser lombokUser = new LombokUser();
    }
}
package club.justwrite.java.base.generic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

class PairTest {
    @Test
    public void testPair(){
       IntPair intPair = new IntPair();

        Type genericSuperclass = intPair.getClass().getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = pt.getActualTypeArguments();
            System.out.println(Arrays.toString(actualTypeArguments));
        }
    }
}
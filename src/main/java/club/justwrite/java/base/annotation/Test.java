package club.justwrite.java.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

@Version2
public class Test {
    public static void main(String[] args) {
        final Annotation[] annotations = Test.class.getAnnotations();
        System.out.println("annotations = " + Arrays.toString(annotations));
        Annotation[] v2 = Test.class.getDeclaredAnnotations();
        System.out.println("v2 = " + Arrays.toString(v2));
        final Annotation[] annotations1 = Version2.class.getAnnotations();
        System.out.println("annotations = " + Arrays.toString(annotations1));
    }
}

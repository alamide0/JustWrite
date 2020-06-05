package club.justwrite.java.run;

import club.justwrite.java.processor.Execute;
import club.justwrite.java.io.ClassUtils;
import club.justwrite.java.io.IFindClasses;
import club.justwrite.java.io.Printer;
import club.justwrite.java.proxy.CostTimeProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Run {

    @Execute
    public static void main(String[] args) {
        try {
            IFindClasses iFindClasses = (IFindClasses) CostTimeProxy.proxy(new ClassUtils());
            Class[] classes = iFindClasses.findAnnotatedClass(Execute.class);
            for (Class cls : classes) {
                test(cls);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private static void test(Class clazz) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            Annotation annotation = method.getAnnotation(Execute.class);
            if (annotation != null) {
                long startMills = System.currentTimeMillis();
                method.invoke(null, (Object[]) null);
                Printer.print("Method " + method.getName() + " cost " + (System.currentTimeMillis() - startMills) + " ms");
            }
        }

    }


}

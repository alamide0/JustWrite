package club.justwrite.java.io;

public interface IFindClasses {
    Class[] findAnnotatedClass(Class annotationType) throws ClassNotFoundException;
}

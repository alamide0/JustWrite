package club.justwrite.java.base.io;

public interface IFindClasses {
    Class[] findAnnotatedClass(Class annotationType) throws ClassNotFoundException;
}

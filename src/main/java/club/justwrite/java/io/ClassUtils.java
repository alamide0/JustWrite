package club.justwrite.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static club.justwrite.java.io.Printer.print;

//Information:java: /Users/zhaoxiaosi/Documents/Private/Train/JustWrite/src/main/resources/route.json
public class ClassUtils implements IFindClasses {
    public static void main(String[] args) {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        print(path);
//        try {
//            Class[] classes = new ClassUtils().findAnnotatedClass(Execute.class);
//            print(classes.length + "");
//            print(classes[0].getCanonicalName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Class[] findAnnotatedClass(Class annotationType) throws ClassNotFoundException {

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        File file = new File(path);

        List<String> list = new LinkedList<>();

        FileUtils.findFileNames(file, list, ".class");

        String[] paths = list.toArray(new String[]{});


        for (int i = 0; i < paths.length; i++) {
            paths[i] = paths[i].substring(path.length());
            paths[i] = paths[i].substring(0, paths[i].length() - ".class".length());
            paths[i] = paths[i].replace("/", ".");
        }

        List<Class> res = new ArrayList<>(paths.length);

        for (String classPath : paths) {
            Class clazz = Class.forName(classPath);
            if (clazz.isAnnotationPresent(annotationType)) {
                res.add(clazz);
            }
        }

        return res.toArray(new Class[]{});
    }
}

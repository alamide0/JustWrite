package club.justwrite.android;

import club.justwrite.android.router.Router;
import club.justwrite.java.io.IFindClasses;

/**
 * @author ACC
 * @desc
 * @create 2020/5/9 3:41 PM
 **/
@Router(path = "/app/home/main", description = "主界面", needLogin = true)
public class MainActivity {



    IFindClasses iFindClasses = new IFindClasses() {
        @Override
        public Class[] findAnnotatedClass(Class annotationType) throws ClassNotFoundException {
            return new Class[0];
        }
    };
}

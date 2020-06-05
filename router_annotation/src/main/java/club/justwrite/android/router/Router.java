package club.justwrite.android.router;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ACC
 * @desc
 * @create 2020/5/9 10:27 AM
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Router {

    boolean needLogin() default false;

    String path();

    String description() default "";
}

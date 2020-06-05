package club.justwrite.java.performance;


import club.justwrite.java.io.Printer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ACC
 * @desc
 * @create 2020/5/21 1:57 PM
 **/
@Aspect
public class CostTime {

    @Around("execution(* club.justwrite.java.array.*.*(..))")
    public Object cost(ProceedingJoinPoint pjp) {
        Object result = null;

        String methodName = pjp.getSignature().getName();

        long startMills = System.currentTimeMillis();

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            Printer.print("method " + methodName + " cost " + (System.currentTimeMillis() - startMills) + "ms");
        }

        return result;
    }
}

package club.justwrite.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CostTimeProxy implements InvocationHandler {

    private Object proxyObj;

    private CostTimeProxy(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    public static Object proxy(Object obj) {
        CostTimeProxy costTimeProxy = new CostTimeProxy(obj);
        return Proxy.newProxyInstance(costTimeProxy.getClass().getClassLoader(), obj.getClass().getInterfaces(), costTimeProxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startMills = System.currentTimeMillis();

        Object obj = method.invoke(proxyObj, args);

        long costMills = System.currentTimeMillis() - startMills;

        System.out.println("Method " + method.getName() + " cost " + costMills + " ms");

        return obj;
    }
}

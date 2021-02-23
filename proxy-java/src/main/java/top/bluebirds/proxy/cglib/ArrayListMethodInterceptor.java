package top.bluebirds.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ArrayListMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param realObject 原始对象
     * @param method 原始对象被调用方法
     * @param args 参数
     * @param methodProxy cglib
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object realObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行"+method.getName());
        System.out.println("开始");
        //反射执行原对象中方法
        Object object = methodProxy.invokeSuper(realObject, args);
        System.out.println("结束");
        return object;
    }
}

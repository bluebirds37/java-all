package top.bluebirds.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ArrayListMethodInterceptorTest {

    public static void main(String[] args) {
        List<String> realObject = new ArrayList<>();
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(realObject.getClass());
        // 设置方法拦截器
        enhancer.setCallback(new ArrayListMethodInterceptor());
        // 创建代理类
        List<String> proxyObject = (List<String>)enhancer.create();
        System.out.println(proxyObject.getClass().getName());
        boolean test = proxyObject.add("test");
        System.out.println(test);

        List<String> proxy = (List<String>)CglibProxyFactory.getProxy(ArrayList.class);
        proxy.add("test");

    }

}

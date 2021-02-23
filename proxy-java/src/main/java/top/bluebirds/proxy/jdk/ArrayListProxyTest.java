package top.bluebirds.proxy.jdk;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListProxyTest {

    public static void main(String[] args) {
        //创建原对象
        List<String> realObject = new ArrayList<>();
        //创建代理对象
        //设置代理对象中的原对象
        ArrayListProxy proxy = new ArrayListProxy(realObject);
        //三要素 类加载器 接口 代理对象s
        List<String> proxyList = (List<String>) Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(), proxy);
        System.out.println(proxy.getClass().getName());
        //执行代理对象
        boolean user = proxyList.add("user");
        System.out.println(user);


        List<String> proxy1 = (List<String>) JdkProxyFactory.getProxy(realObject);
        proxy1.add("user");
    }

}

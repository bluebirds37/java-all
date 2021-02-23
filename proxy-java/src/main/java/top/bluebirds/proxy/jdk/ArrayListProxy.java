package top.bluebirds.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ArrayListProxy implements InvocationHandler {

    //原对象
    private Object realObject;

    public ArrayListProxy(Object realObject) {
        this.realObject = realObject;
    }

    public void setRealObject(Object realObject) {
        this.realObject = realObject;
    }

    /**
     *
     * @param proxy 产生的代理对象s
     * @param method 执行方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象类型"+proxy.getClass().getName());
        System.out.println("执行"+method.getName());
        System.out.println("开始");
        //反射执行原对象中方法
        Object invoke = method.invoke(realObject, args);
        System.out.println("结束");
        return invoke;
    }
}

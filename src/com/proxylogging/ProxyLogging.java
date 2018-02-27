package com.proxylogging;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.ProxyLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyLogging {
    private IEasyCalc easyCalc ;

    public ProxyLogging(IEasyCalc easyCalc) {
        this.easyCalc = easyCalc;
    }

    public IEasyCalc createProxy(){
        IEasyCalc proxy= null;
        //获取类 被哪个类加载器加载.
        ClassLoader loader = easyCalc.getClass().getClassLoader();
        //声明代理对象的类型.
        Class [] interfaces = new Class [] {IEasyCalc.class};
        //代理对象 执行的操作.
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---执行后");
                int result = (int) method.invoke(easyCalc,args);
                System.out.println("---执行后");
                return result;
            }
        };
        //创建代理对象,.
        proxy = (IEasyCalc) Proxy.newProxyInstance(loader,interfaces,h);
       return proxy;
    }

}

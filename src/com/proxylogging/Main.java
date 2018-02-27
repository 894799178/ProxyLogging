package com.proxylogging;

public class Main {
    /**
     * 利用动态代理实现aop 来对方法的前后执行插入其他的执行方法.
     * @param args
     */
    public static void main(String[] args) {
        IEasyCalc easyCalc = new EasyCalc();
        ProxyLogging  proxy = new ProxyLogging(easyCalc);
        easyCalc= proxy.createProxy();
        System.out.println(easyCalc.sub(1,2));
    }
}

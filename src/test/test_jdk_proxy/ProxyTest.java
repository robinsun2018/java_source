package test.test_jdk_proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CustomInvocationHandler handler = new CustomInvocationHandler(new HelloworldImpl());
        Helloworld proxy = (Helloworld)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[]{Helloworld.class},
                handler);
        proxy.sayHello("suncs");
    }
}

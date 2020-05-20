package test.test_jdk_proxy;

public class HelloworldImpl implements Helloworld {
    @Override
    public void sayHello(String name) {
        System.out.println("hello :"+ name);
    }
}

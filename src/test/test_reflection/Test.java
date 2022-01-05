package test.test_reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception{
        A a = new A();
        B b = new B();
        System.out.println(b);
        Class<? extends A> clazz = a.getClass();
        Field bField = clazz.getDeclaredField("b");
        bField.setAccessible(true);
        String name = bField.getName();
        name = name.substring(0,1).toUpperCase()+ name.substring(1,name.length());
        String setMethodName = "set"+ name;
        Method method = clazz.getMethod(setMethodName, B.class);
        method.invoke(a,b);
        System.out.println(a.getB());


    }
}

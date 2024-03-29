package test.test_classloader_order;

public class Child extends Parent {
    {
        System.out.println("子类非静态初始化块");
    }
    static
    {
        System.out.println("子类静态初始化块");
    }
    public Child()
    {
        System.out.println("子类的构造方法");
    }
    public static int childStaticMethod()
    {
        System.out.println("子类的静态方法");
        return 1000;
    }
    @Override
    protected void finalize() throws Throwable
    {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("销毁子类");
    }

}

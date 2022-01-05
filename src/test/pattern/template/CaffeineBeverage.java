package test.pattern.template;

public abstract class CaffeineBeverage {
    /**
     * 现在用同一个prepareRecipe()方法处理茶和咖啡。
     * 声明为final的原因是我们不希望子类覆盖这个方法!
     **/
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments())
            addCondiments();
    }
    /**
     * 咖啡和茶处理这些方法不同，因此这两个方法必须被声明为抽象，留给子类实现
     **/
    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("将水煮沸");
    }
    void pourInCup() {
        System.out.println("把饮料倒进杯子中");
    }
    boolean customerWantsCondiments() {
        return true;
    }
}

package test.pattern.template;

import java.util.Scanner;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("泡咖啡");

    }

    @Override
    void addCondiments() {
        System.out.println("加牛奶");

    }

    /**
     * 子类覆写了钩子函数，实现自定义功能
     **/
    boolean customerWantsCondiments() {
        String result = getUserInput();
        if(result.equals("y"))
            return true;
        else
            return false;
    }
    private String getUserInput() {
        System.out.println("您想要在咖啡中加入牛奶或糖吗（y/n）？");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();



    }
}

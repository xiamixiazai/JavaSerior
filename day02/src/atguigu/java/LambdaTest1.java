package atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xjm
 * @create 2022/7/4-22:46
 */
public class LambdaTest1{
    @Test
    public void test1(){
        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("***************************");

        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };

        r2.run();
    }

    //情况二 ，lambda需要一个入参，但没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("***********************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，另一个是说的人当真了");


    }

    //类型推断
    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList<>();

        int[] arr = {1,2,3};

    }

    //语法格式五，lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12,21));

        System.out.println("****************************");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12,6));

    }

    @Test
    public void test6(){
        Consumer<String> con1 = s -> System.out.println(s);

        con1.accept("入参为一个，且执行语句只为一句");

    }




}

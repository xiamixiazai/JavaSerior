package atguigu.exer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author xjm
 * @create 2022/6/19-23:03
 */
public class CollectionTest {
    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"aa");
        Person p2 = new Person(1002,"bb");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "cc";
        set.remove(p1);
        System.out.println(set);

        set.add(new Person(1001,"cc"));
        System.out.println(set);

        set.add(new Person(1001,"aa"));
        System.out.println(set);


    }
}

package day03;

import org.junit.Test;

import java.util.Arrays;

public class CompareTest {
    /*
        String实现了Comparable接口，重写了CompareTo(obj)方法
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","ZZ","MM","DD","JJ"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenvonMouse",34);
        arr[1] = new Goods("dellMouse",12);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}

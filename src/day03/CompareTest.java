package day03;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

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

    //Comparable接口的使用  自然排序
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

    //Comparator接口使用，定制排序
    /*
        当前元素的类型没有实现Comparable接口而又不方便修改代码，
        或者实现了Comparable接口的，但排序规则不适合当前的操作，
        则使用Comparator的对象来排序
     */
    @Test
    public void test3(){

        String[] arr = new String[]{"AA","CC","ZZ","MM","DD","JJ"};

        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}

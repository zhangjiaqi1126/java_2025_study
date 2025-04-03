package com.itheima.mycollectiondemo1;

import java.util.ArrayList;
import java.util.Iterator;

public class MyCollectonDemo8 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("小皮同学",23);
        Student s2 = new Student("小路同学",31);
        Student s3 = new Student("小贾同学",33);

        list.add(s1);
        list.add(s2);
        list.add(s3);


        //迭代器的方式进行遍历
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student s = it.next();
            System.out.println(s);
        }

        System.out.println("-------------------------");
        //增强for
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

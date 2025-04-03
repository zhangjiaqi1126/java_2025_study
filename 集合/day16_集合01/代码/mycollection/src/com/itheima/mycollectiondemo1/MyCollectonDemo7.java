package com.itheima.mycollectiondemo1;

import java.util.ArrayList;

public class MyCollectonDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

//
//        for(String str : list){
//            str = "q";
//            System.out.println(str);
//        }
        for (String s : list) {
            System.out.println(s);
        }

        //System.out.println(list);
    }
}

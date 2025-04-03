package com.itheima.variableparameter;

/**
 * 需求：定义一个方法求N个数的和
 * 可变参数实现
 */
public class MyVariableParameter3 {
    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5};
//        System.out.println(arr);
        int sum1 = getSum(1, 2, 3, 4, 5);
        System.out.println(sum1);
    }

    public static int getSum(int number,int... arr) {
        //System.out.println(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}

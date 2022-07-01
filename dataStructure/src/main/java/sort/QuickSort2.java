package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort2 {
    public static void main(String[] args) {

//        int[] ints = {3, 2, 5, 6, 4, 9, 1, 8, 7};
//        sort(ints,0,ints.length-1);
//        System.out.println(Arrays.toString(ints));


        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        sort(arr,0,arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);


    }

    public static void sort(int[] ints,int left,int right) {

        int l = left;
        int r = right;
        int mid = ints[(l+r)/2];
        int temp = 0;

        while (l<r){

            while (ints[l] < mid){
                l += 1;
            }

            while (ints[r] > mid){
                r -= 1;
            }

            if( l >= r) {
                break;
            }

            temp = ints[l];
            ints[l] = ints[r];
            ints[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(ints[l] == mid) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(ints[r] == mid) {
                l += 1;
            }

        }

        if (l == r){
            l +=1;
            r -=1;
        }

        //向左递归
        if(left < r) {
            sort(ints, left, r);
        }
        //向右递归
        if(right > l) {
            sort(ints, l, right);
        }



    }

}

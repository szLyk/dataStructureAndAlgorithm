package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        int[] ints = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(ints);
        System.out.println(Arrays.toString(ints));

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
//        }
//
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        sort(arr);
//
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void sort(int[] ints) {

//        int step = ints.length/2;
//        int temp = 0;
//        temp = ints[0];
//        if (ints[step] < ints[0]){
//            ints[0] = ints[step];
//            ints[step] = temp;
//        }
//
//        temp = ints[1];
//        if (ints[step+1] < ints[1]){
//            ints[1] = ints[step+1];
//            ints[step+1] = temp;
//        }
//
//        temp = ints[2];
//        if (ints[step+2] < ints[2]){
//            ints[2] = ints[step+2];
//            ints[step+2] = temp;
//        }


//        for (int i = 0;i<=step;i++){
//            temp = ints[i];
//            if (ints[step+i] < ints[i]){
//                ints[i] = ints[step+i];
//                ints[step+i] = temp;
//            }
//        }
//
//        System.out.println(Arrays.toString(ints));
//
//        int step1 = ints.length/2/2;
//
//        for (int i = 0;i<=step1;i++){
//            temp = ints[i];
//            if (ints[step1+i] < ints[i]){
//                ints[i] = ints[step1+i];
//                ints[step1+i] = temp;
//            }
//        }
//
//        System.out.println(Arrays.toString(ints));
//
//        int step2 = ints.length/2/2/2;
//
//        for (int i = 0;i<=step2;i++){
//            temp = ints[i];
//            if (ints[step2+i] < ints[i]){
//                ints[i] = ints[step2+i];
//                ints[step2+i] = temp;
//            }
//        }

        // 增量gap, 并逐步地缩小增量
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            // 从第gap个元素，逐个对其所在的组进行直接插入排序
//            for (int i = gap; i < arr.length; i++) {
//                int j = i;
//                int temp = arr[j];
//                if (arr[j] < arr[j - gap]) {
//                    while (j - gap >= 0 && temp < arr[j - gap]) {
//                        //移动
//                        arr[j] = arr[j - gap];
//                        j -= gap;
//                    }
//                    //当退出while后，就给temp找到插入的位置
//                    arr[j] = temp;
//                }
//
//            }
//        }

        int temp = 0;

        int a = 11 / 2;


        for (int i = 5; i < ints.length; i++) {

            for (int j = i - 5; j >= 0; j -= 5) {

                if (ints[j] > ints[j + 5]) {
                    temp = ints[j];
                    ints[j] = ints[j + 5];
                    ints[j + 5] = temp;
                }

            }
        }

        System.out.println(Arrays.toString(ints));

        int b = (11 / 2) / 2;

        for (int i = 2; i < ints.length; i++) {

            for (int j = i -2; j >= 0; j -= 2) {
                if (ints[j] > ints[j + 2]) {
                    temp = ints[j];
                    ints[j] = ints[j + 2];
                    ints[j + 2] = temp;
                }

            }
        }


    }
}

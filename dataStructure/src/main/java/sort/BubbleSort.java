package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//冒泡排序的速度O(n^2)
public class BubbleSort {

    public static void main(String[] args) {

//        int[] ints = new int[]{99,8,6,9,22,11,3,2,1};
//        sort(ints);
//        System.out.println(Arrays.toString(ints));


        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        sort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);


    }

    public static void sort(int[] ints){

        boolean flag = false; // 标识变量，表示是否进行过交换
        int temp = 0;
        for (int j = ints.length-1;j>=0;j--){

            for (int i=0;i<j;i++){

                if (ints[i+1] < ints[i]){
                    flag = true;
                    temp =ints[i];
                    ints[i] = ints[i+1];
                    ints[i+1] = temp;
                }

            }
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }

        }

    }

}

package sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序
public class SelectSort {

    public static void main(String[] args) {
//                int[] ints = new int[]{99,8,6,9,88,22,11,3,2,1,-22};
//                sort(ints);
//                System.out.println(Arrays.toString(ints));


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
        int temp = 0;

        for (int j = 0;j< ints.length;j++){

            for (int i = j+1; i < ints.length; i++) {
                temp = ints[i];
                if (temp < ints[j]){

                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }

        }


    }
}

package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
//        int[] ints = new int[]{99, 8, 6, 9, 88, 22, 7, 3, 2, 1, -22};
//        sort(ints);
//        System.out.println(Arrays.toString(ints));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        sort(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
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

        int temp = 0;
        for (int j = ints.length/2;j>0;j/=2){
            for (int i = 0;i<=j;i++){
                temp = ints[i];
                if (ints[j+i] < ints[i]){
                    ints[i] = ints[j+i];
                    ints[j+i] = temp;
                }
            }
        }


        int indexValue = 0;
        int j = 0;

        //第一、二个数

//        for (int i = 1; i < ints.length; i++) {
//
//            indexValue = ints[i];
//
//
//            for (j = i-1;j>=0;j--){
//
//                if (indexValue<ints[j]){
//                    ints[i] = ints[j];
//                }else {
//                    break;
//                }
//
//            }
//
//            ints[j+1] = indexValue;
//
//        }


//        temp = ints[1];
//        if (temp<ints[0]){
//            ints[0] = ints[1];
//        }
//        temp = ints[2];
//        if (temp<ints[1]){
//            ints[2] = ints[1];
//        }
//        if (temp<ints[1]){
//            ints[1] = ints[0];
//        }
//        ints[0] = temp;


    }
}

package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {


        int[] ints = new int[]{4,2,3,1};
        sort1(ints);
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
//        sort1(arr);

        //测试冒泡排序
//        sort1(arr);
//        排序前的时间是=2022-06-28 15:52:02
//        排序后的时间是=2022-06-28 15:52:05

//          insertSort(arr);
//        排序前的时间是=2022-06-28 15:56:27
//        排序后的时间是=2022-06-28 15:56:28

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序后的时间是=" + date2Str);

    }

    public static void sort1(int[] ints) {


        int right = 0;
        int temp = 0;

        //重写
        int i, j;
        for (i = 1; i < ints.length; i++) {
            int tmp = ints[i];
            for (j = i - 1; j >= 0; j--) {//注意这个循环
                if (tmp < ints[j]) {//一边比较一边后移
                    ints[j + 1] = ints[j];
                } else {
                    break;
                }
            }
            ints[j + 1] = tmp;
        }
//        for (int k = 0; k < ints.length; k++) {
//            System.out.print(ints[k] + " ");
//        }


//        for (int i = 1; i < ints.length; i++) {
//
//            temp = ints[i];
//            right++;
//
//            //慢的原因 多了交换！
//
//            for (int j = 0; j < right; j++) {
//
//                if (ints[j] > temp) {
//
//                    ints[i] = ints[j];
//                    ints[j] = temp;
//                    temp = ints[i];
//
//                }
//
//            }
//        }

    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
        }
    }

    public static void sort2(int[] ints){

        int indexValue = 0;
        int j = 0;

        //第一、二个数

        for (int i = 1; i < ints.length; i++) {

            indexValue = ints[i];


            for (j = i-1;j>=0;j--){

                if (indexValue<ints[j]){
                    ints[i] = ints[j];
                }else {
                    break;
                }

            }

            ints[j+1] = indexValue;

        }


//        for (int i = 1; i < ints.length; i++) {
//            indexValue =  ints[1];
//
//            if (indexValue<ints[0]){
//                ints[1] = ints[0];
//            }
//
//            ints[0] = indexValue;
//
//
//            indexValue = ints[2];
//
//            if (indexValue < ints[1]){
//                ints[2] = ints[1];
//            }
//
//            ints[1] = indexValue;
//
//        }
    }

}

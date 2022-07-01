package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort1 {
    public static void main(String[] args) {
//        int[] array = {4,7,2,1,5,3,8,6};
//        int[] array = {3,1,2,5,4};

        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
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

    public static void sort(int[] arr, int left, int right) {

    }

    private static void quicksort(int[] array, int low, int high) {
        if(low < high){
            int pivot = partition(array,low,high);
            quicksort(array,low,pivot-1);
            quicksort(array,pivot+1,high);
        }
    }

    //划分操作
    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high){
            //因为我们让low作为pivot，所以要从high开始。
            while (low < high && array[high] >= pivot) high--;//定位到比pivot小的位置
            array[low] = array[high];
            while (low < high && array[low] <= pivot) low++;
            array[high] = array[low];
        }
        array[low] =pivot;
        return low;
    }

}

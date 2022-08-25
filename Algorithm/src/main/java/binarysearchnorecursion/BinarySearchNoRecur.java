package binarysearchnorecursion;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] ints = {1,5,6,8,7,15,20};
        System.out.println(binarySearch(ints, 6));

    }

    //二分查找的非递归实现
    /**
     *
     * @param arr 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int mid ;

        while (left <= right){
            mid =  (left+right)/2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid +1;
            }else {
                right = mid-1;
            }
        }


        return -1;
    }
}

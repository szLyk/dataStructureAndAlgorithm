package sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 1;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int high = chessArr1.length;
        int length = chessArr1[0].length;

        int count = 0;

        for (int i = 0; i < high; i++) {

            for (int j = 0; j < length; j++) {
                int i1 = chessArr1[i][j];

                if (i1 != 0){
                    count ++;
                }
            }
        }



        int[][] ints = new int[count][2];
        ints[0][0] = high;
        ints[0][1] = length;
        ints[0][2] = count;


        for (int i = 0; i < high; i++) {

            for (int j = 0; j < length; j++) {
                int i1 = chessArr1[i][j];

                if (i1 != 0){

                }
            }
        }


    }
}

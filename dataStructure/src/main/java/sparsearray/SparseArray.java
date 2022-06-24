package sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 1;
        chessArr1[7][6] = 2;
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

                if (i1 != 0) {
                    count++;
                }
            }
        }

        //建立稀疏数组，存数据情况
        int[][] ints = new int[count + 1][3];
        ints[0][0] = high;
        ints[0][1] = length;
        ints[0][2] = count;

        int a = 0;


        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {

                if (chessArr1[i][j] != 0) {
                    a++;
                    ints[a][0] =  i;
                    ints[a][1] =  j;
                    ints[a][2] = chessArr1[i][j];
                }
            }
        }
        //展示
        System.out.println();
        System.out.println("稀疏数组");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] +"\t");
            }
            System.out.println();
        }
        System.out.println("*******************");

        //解析稀疏数组

        int newArrayHigh = ints[0][0];
        int newArrayLength = ints[0][1];
        int nu= ints[0][2] ;

        int[][] newArray = new int[newArrayHigh][newArrayLength];

        for (int i = 1; i < ints.length; i++) {

           int nuHigh = ints[i][0];
           int nuLength = ints[i][1];
           newArray[nuHigh][nuLength] = ints[i][2];
        }
        System.out.println("还原数组~");
        for (int[] ints1 : newArray) {
            for (int i : ints1) {
                System.out.print(i+"\t");
            }
            System.out.println();
        }


    }
}

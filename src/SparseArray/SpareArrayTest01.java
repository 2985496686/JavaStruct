package SparseArray;

public class SpareArrayTest01 {
    public static void main(String[] args) {
        //创建一个原始二维数组
        int chessArray1[][] = new int[11][11];
        chessArray1[2][3] = 1;
        chessArray1[1][2] = 2;
        chessArray1[4][4] = 5;
        chessArray1[5][2] = 2;
        chessArray1[3][4] = 5;
        chessArray1[2][2] = 2;
        chessArray1[1][4] = 5;
        for(int[] row : chessArray1){
            System.out.println();
            for(int data:row){
                System.out.print(data + "\t");
            }
        }

        //原始数组转换为稀疏数组
        //统计非0元素个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if(chessArray1[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int chessArray2[][] = new int[sum+1][3];
        chessArray2[0][0] = 11;
        chessArray2[0][1] = 11;
        chessArray2[0][2] = 0;
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                    if(chessArray1[i][j] != 0){
                        count++;
                        chessArray2[count][0] = i + 1;
                        chessArray2[count][1] = j + 1;
                        chessArray2[count][2] = chessArray1[i][j];
                    }
            }
        }
        for(int[] row:chessArray2){
            System.out.println();
            for(int data:row){
                System.out.print(data + "  ");
            }
        }



        //稀疏数组转换为原始数组
        int [][]chessArray3 = new int[chessArray2[0][0]][chessArray2[0][1]];
        for (int i = 0; i < chessArray2.length; i++) {
            chessArray3[chessArray2[i][0] - 1][chessArray2[i][1]  - 1] = chessArray2[i][2];
        }
        for(int row[]:chessArray3){
            System.out.println();
            for (int data:row){
                System.out.print(data + "  ");
            }
        }
    }

}


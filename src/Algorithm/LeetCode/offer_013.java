package Algorithm.LeetCode;
/*
剑指offer013，二维矩阵的和

 */
//方法一：使用一维前缀和
public class offer_013 {
    int [][]arr;
    public offer_013(int[][] matrix) {
        if(matrix == null) return ;
        arr = new int[matrix.length][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length + 1; j++){
                if(j == 0){
                    arr[i][j] = 0;
                }
                else{
                    arr[i][j] = arr[i][j - 1] + matrix[i][j-1];
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rnt = 0;
        for(int i = row1 ; i <= row2; i++){
            rnt += arr[i][col2+1] - arr[i][col1];
        }
        return rnt;
    }
}
//方法二，使用二维前缀和
class NumMatrix {
    int [][]arr;
    public NumMatrix(int[][] matrix) {
        if(matrix == null) return ;
        arr = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length + 1; i++){
            for(int j = 0; j < matrix[0].length +1; j++){
                if(i ==0 || j == 0){
                    arr[i][j] = 0;
                }
                else{
                    arr[i][j] = arr[i-1][j] + arr[i][j-1] -arr[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rnt = 0;
        rnt = arr[row2+1][col2+1] - arr[row1][col2+1] - arr[row2+1][col1] + arr[row1][col1];
        return rnt;
    }
}

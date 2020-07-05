package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCellsGrid {

    static int row;
    static int col;
    static boolean[][] visited ;
    static int count;
    static void check(int[][] matrix,int i,int j){
        if(i<0||j<0||i>=row||j>=col)
            return;
        if(visited[i][j]||matrix[i][j]==0)
            return;
        count +=1;
        visited[i][j]=true;
        check(matrix,i+1,j);
        check(matrix,i,j+1);
        check(matrix,i-1,j+1);
        check(matrix,i+1,j-1);
        check(matrix,i+1,j+1);
        check(matrix,i-1,j);
        check(matrix,i,j-1);
        check(matrix,i-1,j-1);
        
    }
    static int connectedCell(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        visited = new boolean[row][col];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]!=true){
                    count =0;
                    check(matrix,i,j);
                    result = Math.max(count,result);
                }
            }
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class knightpair{
    int a;
    int b;
    int count;
    knightpair(int a,int b,int count){
        this.a =a ;
        this.b = b;
        this.count = count;
    }
}
public class KnightMove2 {

    // Complete the knightlOnAChessboard function below.
    static int[][] arr;
    static int[][] result;
    static boolean[][] visited;
    static int bfs(int a,int b,int n){
        int[] aa = new int[] {a,a,-a,-a,b,b,-b,-b};
        int[] bb = new int[] {b,-b,b,-b,a,-a,a,-a};
        int end=n-1;
        visited= new boolean[n][n];
        Queue<knightpair> queue = new LinkedList<knightpair>();
        queue.add(new knightpair(0,0,0));
        visited[0][0]=true;
        while(!queue.isEmpty()){
            knightpair x = queue.remove();
            // System.out.println(x.a+" "+x.b+" "+x.count);
            if(x.a==end&&x.b==end ){
                // System.out.println("x.a "+x.a +"Result" +x.count);
                return x.count;
            }
            for(int i=0;i<8;i++){
                int newi = aa[i]+x.a;
                int newj = bb[i]+x.b;
                
                if(newi>=0&&newj>=0&&newi<n&&newj<n&&!visited[newi][newj]){
                
                // System.out.println(newi+" newj"+newj+" "+x.count);
                    queue.add(new knightpair(newi,newj,x.count+1));
                    // System.out.println(queue.peek());
                    visited[newi][newj]=true;
                }
            }
        }
        return -1;
    }
    
    static int[][] knightlOnAChessboard(int n) {
         
        int result[][] = new int[n-1][n-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(result[j-1][i-1]!=0){
                    result[i-1][j-1]= result[j-1][i-1];
                    continue;
                }
                if(result[i-1][j-1]==0)
                    result[i-1][j-1]=bfs(i,j,n);
                
            }
        }
    return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

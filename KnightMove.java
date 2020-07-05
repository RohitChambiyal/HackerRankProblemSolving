package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KnightMove {

    static int n;
    // static int arr[][];
    static int done[][];
    static boolean visited[][];
    
    static void check(int i,int j,int inci,int incj,int count){
        if(i<0||j<0||i>=n||j>=n)
            return;
        if(visited[i][j])
            return;
        if(done[inci][incj]!=-1 && done[inci][incj]<count)
            return;
        if(i==n-1&&j==n-1){
            // System.out.println("inci "+inci+" incj "+incj+" count "+count);
            
            if(done[inci][incj]!=-1){
                // if(inci ==4&&incj ==1)
                //     System.out.println("count "+count +" done "+done[inci][incj]);
                done[inci][incj]=Math.min(count,done[inci][incj]);
            }
            else
                done[inci][incj]=count;
            return;
        }
        visited[i][j]=true;
        
        check(i+inci,j+incj,inci,incj,count+1);
        check(i-inci,j-incj,inci,incj,count+1);
        check(i+inci,j-incj,inci,incj,count+1);
        check(i-inci,j+incj,inci,incj,count+1);

        check(i+incj,j+inci,inci,incj,count+1);
        check(i-incj,j-inci,inci,incj,count+1);
        check(i+incj,j-inci,inci,incj,count+1);
        check(i-incj,j+inci,inci,incj,count+1);
        visited[i][j]=false;   

    }
    static int[][] knightlOnAChessboard(int N) {
        n=N;
        // arr = new int[n][n];
        done = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                done[i][j]= -1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                visited= new boolean[n][n];
                check(0,0,i,j,0);
            }
        }
        int result[][] = new int[n-1][n-1];
        // int ri=0,rj=0;
        // System.out.println("done 1 2"+done[1][2]);
        for(int i=1,ri=0;i<n;i++,ri++)
            for(int j=1,rj=0;j<n;j++,rj++)
                result[ri][rj]=done[i][j];

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

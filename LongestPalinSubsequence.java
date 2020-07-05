package Non_Uploaded_Git;

import java.util.Arrays;

public class LongestPalinSubsequence {
    static int dp[][];
    public static int findpalin(String s, int i,int j){
        if(i==j)
            return dp[i][j]=1;
        if(dp[i][j]!=0)
            return dp[i][j];
        if(s.charAt(i)==s.charAt(j)&&i+1==j){
            return dp[i][j] = 2;
        }
        else if(s.charAt(i)==s.charAt(j)){
            return dp[i][j] = findpalin(s,i+1,j-1)+2;
        }
        else{
            return dp[i][j]=Math.max(findpalin(s, i+1, j),findpalin(s, i, j-1));
        }
    }
    static String printpalin(String s,int n,int r){
        int i=0,j=n-1;
        String res = "";
        while(i>=0&&j>=0&&dp[i][j]!=0){
            if(dp[i][j]==dp[i][j-1]){
                j--;
            }
            else if(dp[i][j]==dp[i+1][j]){
                i++;
            }
            else{
                res+=s.charAt(i);
                i++;
                j--;
            }
        }
        // System.err.println(res);
        if(r%2==0){
            for(i=res.length()-1;i>=0;i--){
                res+=res.charAt(i);
            }
        }
        else{
            for(i=res.length()-2;i>=0;i--){
                res+=res.charAt(i);
            }
        }
        return res;

    }
    public static void main(String[] args){
        String s = "BBABCBCAB";
        int n = s.length();
        dp= new int[n][n];
        // for(int i=0;i<n;i++)
        //     dp[i][i]=1;
        int x= findpalin(s,0,n-1);
        
        System.err.println(x);
        System.err.println("B B A B C B C A B");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        String res = printpalin(s,n,x);
        
        System.out.println("Resulting Largest Palin Seq : "+res);
        

    }
}
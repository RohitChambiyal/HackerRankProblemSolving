package Non_Uploaded_Git;

import java.util.Scanner;


public class CounterGames {
    static String counterGame(long n) {
        int count =-1;
        //%2=0 Louise
        //%2!=0 Richard
        while(n!=1){
            count++;
            long x = Long.highestOneBit(n);
            if(x==n){
                n/=2;
            }
            else{
                n=n-x;
            }
        }
        if(count%2==0)
            return "Louise";
        else
            return "Richard";

    }
    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- !=0){
            long x = s.nextLong();
            counterGame(x);
        }

    }
}
package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HighestPalin1 {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        
        
        char arr[] = s.toCharArray();
        int len = s.length();
        // int mismatch=0;
        // int nine=0;
        Vector<Integer> v = new Vector<Integer>();
        
        for(int i=0;i<len/2;i++){
            if(arr[i]!=arr[len-i-1]){
                int max= Math.max((int)(arr[i]),(int)(arr[len-i-1]));
                arr[i]=(char)max;
                arr[len-i-1] = (char)max;
                v.add(i);
                k--;
            }
        }
        if(k<0)
            return "-1";
        if(k>0){
            for(int i=0;i<len/2;i++){
                if(v.contains(i)&&arr[i]!='9'&&k>0){
                arr[i]='9';
                arr[len-i-1] = '9';
                k-=1;
                }
                else if(k>1&&arr[i]!='9'){
                    arr[i]='9';
                    arr[len-i-1]='9';
                    k-=2;
                }
            }
        }
        if(len%2!=0&&k>=1){
            arr[len/2]='9';
        }
        // System.out.println("arr len "+String.valueOf(arr).length());
        // System.out.println("slen "+s.length());
        // System.out.println(String.valueOf(arr).charAt(len-));
        return String.valueOf(arr);
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);
        System.out.println("size "+result.length());
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PasswordCracker {
    // static boolean visited[];
    static String re;
    public static boolean findResult(String[] str, String pass,int index,String result){
        if(index==pass.length()){
            re = result;
            return true;
        }
        for(int j=0;j<str.length;j++){
            int x=0;
            int i=index;
                while(x<str[j].length()&&i<pass.length()&&str[j].charAt(x)==pass.charAt(i)){
                    x++;
                    i++;
                }
                if(x==str[j].length()){
                    boolean back;
                    if(i==pass.length())
                        back =findResult(str,pass,i,result+str[j]);
                    else
                    back =findResult(str,pass,i,result+str[j]+" ");
                    if(back)
                        return true;
                    else{
                        continue;
                    }
                }
                else
                    continue;
            }
            return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- !=0){
            int n = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            String str1 [] = str.split(" ");
            String pass = s.nextLine();
            // visited=new boolean[n];
            re="WRONG PASSWORD";
            findResult(str1,pass,0,"");
            System.out.println(re);
        }

}
}

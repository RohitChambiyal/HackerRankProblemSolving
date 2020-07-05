package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagram {

    // Complete the sherlockAndAnagrams function below.
    public static Vector<String> findAllSubstrings(String s){
        Vector<String> allstring=new Vector<String>();
        int n = s.length();
        for(int i=0;i<n;i++){
            String str ="";
            for(int j=i;j<n;j++){
                str+=s.charAt(j);
                allstring.add(str);
            }
        }
        // System.out.println(allstring);

        return allstring;
    }
    public static boolean checkPairs(String s1,String s2){  
        // System.out.print("Checking "+s1+" "+s2+" ");
        int []x1 = new int[26];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i=0;i<s1.length();i++){
            x1[arr1[i]-97]++;
            x1[arr2[i]-97]--;
            // System.out.print(x1[s1.charAt(i)-97]+" ");
        }//System.out.println("not correct");
        boolean sum=true;

        for(int i=0;i<26;i++){
            if(x1[i]!=0)
                sum=false;
        }
        // System.out.println(sum+" ");
        if(sum)   return true;
        else return false;
    }
    public static int checkAnagram(int index,Vector<String> str){
        String base = str.get(index);
        // int next = str.get(index+1);
        int matched=0;
        for(int i=index+1;i<str.size();i++){
            if(str.get(i).length()==base.length()&&checkPairs(str.get(i),base) )
                matched++;
        }
        return matched;
    }
    static int sherlockAndAnagrams(String s) {
        boolean present = false;
        int arr[] = new int[26];
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-97]>0){
                present = true;
                break;
            }
            arr[s.charAt(i)-97]++;
        }
        if(present ==false){
            return 0;
        }
        int result =0;
        Vector<String> str =findAllSubstrings(s);
        for(int i=0;i<str.size();i++){
            result+=checkAnagram(i,str);
        }
    return result;
    }
    


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

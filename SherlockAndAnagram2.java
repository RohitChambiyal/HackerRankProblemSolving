package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndAnagram2 {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> hs1 = new HashMap<String, Integer>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String s1 = s.substring(i,j);
                char arr[] = s1.toCharArray();
                Arrays.sort(arr);
                s1= String.valueOf(arr);
                if(hs1.containsKey(s1)){
                    hs1.put(s1,hs1.get(s1)+1);
                }
                else
                    hs1.put(s1,1);
            }
        }
        
        int count=0;
        for(int x:hs1.values()){
            x=(x*(x-1))/2;
            count +=x;
        }
        return count;
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

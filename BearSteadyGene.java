package Non_Uploaded_Git;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BearSteadyGene {

    public static int n;
    // Complete the steadyGene function below.
    public static  boolean greaterThan(HashMap<Character,Integer> hs1){
            for(int i:hs1.values())
                if(i>n/4) return false;
            return true;
        }
    static int steadyGene(String gene) {
        
        HashMap<Character,Integer> hs1 = new HashMap<Character,Integer>();
        hs1.put('A',0);
        hs1.put('C',0);
        hs1.put('G',0);
        hs1.put('T',0);
        n = gene.length();
        for(int i=0;i<gene.length();i++){
            hs1.put(gene.charAt(i),hs1.get(gene.charAt(i))+1);
        }
        boolean check = false;
        for(int i:hs1.values()){
            if(i!=n/4)
                check = true;
        }
        if(check==false) return 0;
        
        int left =0,right = 0,minimum = Integer.MAX_VALUE;
        while(right<n){
            char x = gene.charAt(right);
            // System.out.println("before error "+x);
            System.out.println(hs1);
            hs1.put(x,(hs1.get(x))-1);
            right++;
            while(greaterThan(hs1)&&left<n){
                char y = gene.charAt(left);
                minimum = Math.min(minimum,right-left);
                hs1.put(y,hs1.get(y)+1);
                left++;
            }
        }
        return minimum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

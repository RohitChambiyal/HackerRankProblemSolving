import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CheifHopper {

    // Complete the chiefHopper function below.
    static int chiefHopper(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum+= arr[i];
        }
        
        int max = sum/n;
        if((double)(sum%n)>(double)0)
            max++;
        System.out.println(max);
        
        for(int maxnew=max-1;maxnew>0;maxnew--){
            long energy = maxnew;
            for(int i=0;i<n;i++){
                long oldenergy = energy;
                if(energy<arr[i]){
                    energy = oldenergy - (arr[i]-oldenergy);
                }
                else if(energy>arr[i]){
                    energy = oldenergy +(oldenergy-arr[i]);
                }
                else if(energy<=0&&i!=n-1&&arr[i+1]>energy +oldenergy)
                    return max;
            }
            max = maxnew;
            

        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = chiefHopper(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*

    99

    1401 2019 1748 3785 3236 3177 3443 3772 2138 1049 353 908 310 2388 1322 88 2160 2783 435 2248 1471 706 2468 2319 3156 3506 2794 1999 1983 2519 2597 3735 537 344 3519 3772 3872 2961 3895 2010 10 247 3269 671 2986 942 758 1146 77 1545 3745 1547 2250 2565 217 1406 2070 3010 3404 404 1528 2352 138 2065 3047 3656 2188 2919 2616 2083 1280 2977 2681 548 4000 1667 1489 1109 3164 1565 2653 3260 3463 903 1824 3679 2308 245 2689 2063 648 568 766 785 2984 3812 440 1172 2730


    Oytput
    2033
*/
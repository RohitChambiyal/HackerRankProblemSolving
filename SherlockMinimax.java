import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockMinimax {
    // Complete the sherlockAndMinimax function below.
    static int sherlockAndMinimax(int[] arr, int p, int q) {
        Arrays.sort(arr);
       int min = Integer.MAX_VALUE;
        int min_ind = 0;
        int max_ans = -1;
        int max_ind = -1;
        // start
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - p) < min) {
                min = Math.abs(arr[i] - p);
                min_ind = p;
            }
        }
        if (max_ans < min) {
            max_ans = min;
            max_ind = min_ind;
        }
        min = Integer.MAX_VALUE;
        // end
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - q) < min) {
                min = Math.abs(arr[i] - q);
                min_ind = q;
            }
        }
        if (max_ans < min) {
            max_ans = min;
            max_ind = min_ind;
        }

        // mid - optimal M
        for (int i = 1; i < arr.length; i++) {
            int mid = (arr[i] + arr[i - 1]) / 2;
            min = Integer.MAX_VALUE;
            if (mid > p && mid < q) {
                if (Math.abs(arr[i] - mid) < min) {
                    min = Math.abs(arr[i] - mid);
                    min_ind = mid;
                }
                if (Math.abs(arr[i - 1] - mid) < min) {
                    min = Math.abs(arr[i - 1] - mid);
                    min_ind = mid;
                }
                if (max_ans < min) {
                    max_ans = min;
                    max_ind = min_ind;
                }
            }
        }
        return max_ind;

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

        String[] pq = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pq[0]);

        int q = Integer.parseInt(pq[1]);

        int result = sherlockAndMinimax(arr, p, q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

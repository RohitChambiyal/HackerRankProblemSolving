package Non_Uploaded_Git;
import java.util.Scanner;

public class MaxOr{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int first = s.nextInt();
        int second = s.nextInt();
        System.err.println(Integer.toBinaryString(first));
        System.err.println(Integer.toBinaryString(second));
        int x = first^second;
        System.err.println(Integer.toBinaryString(x));
        int leading = Integer.numberOfLeadingZeros(x);
        int significant = 31-leading;
        System.err.println("Leading "+leading);
        System.out.println("final "+(31-leading));
        System.err.println("-----------------------");
        System.out.println(significant+1);
        System.out.println(1<<(significant+1));
        System.out.println(Integer.toBinaryString((1<<(significant+1))-1));
        int result = (1<<(significant+1))-1;
        System.out.println("result "+(result));
        System.out.println(Integer.toBinaryString(result));
    }
}
import java.util.*;
public class TestingComparable{

    public static void main(String[] args){
        String[] str = {"3", "34", "30", "5", "9"};
        Arrays.sort(str);
        for(String x:str)
            System.out.print(x+" ");
        
        int x="9".compareTo("34");
        System.out.println("result "+x);
    }
}
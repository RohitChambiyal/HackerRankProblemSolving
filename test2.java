package Non_Uploaded_Git;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class test2 {
    public static void main(String[] args){
    Vector<TreeSet<Integer>> v1 = new Vector<TreeSet<Integer>>();
    TreeSet<Integer>s1 = new TreeSet<Integer>();
    TreeSet<Integer>s2 = new TreeSet<Integer>();
    TreeSet<Integer>s3 = new TreeSet<Integer>();
        s1.add(3);
        s2.add(3);
        s2.add(4);
        
        v1.add(s1);
        v1.add(s2);
        System.out.println(v1.contains(s3));
    }
    
}
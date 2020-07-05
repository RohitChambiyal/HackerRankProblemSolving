package Non_Uploaded_Git;

import java.util.HashSet;
import java.util.Iterator;

public class RustAndMurderer1 {
    public static void main(String[] args){
        HashSet<Integer> hs1 = new HashSet<Integer>();
        hs1.add(4);
        
        hs1.add(6);hs1.add(7);hs1.add(7);
        hs1.remove(6);
        System.out.println(hs1);
        Iterator<Integer> itr1 = hs1.iterator();
        while(itr1.hasNext())
            System.out.println(itr1.next());
        
    }
}
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class check2 {
    public static void main(String[] args){
        Vector<Integer> v1 = new Vector<Integer>();
        v1.add(0, 2);
        v1.add(0,1);
        Iterator<Integer> itr = v1.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
        
    }
}
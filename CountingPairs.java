package Non_Uploaded_Git;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CountingPairs {
    

    public static int countpairs(List<Integer> numbers, int k)
    {
      HashSet<Integer> hs=new HashSet<Integer>();
    //   hs.addAll(numbers);
      hs.addAll(numbers);
      int count=0;
      Iterator<Integer> itr1 = hs.iterator();
      Vector<Integer> visited = new Vector<Integer>();
      while(itr1.hasNext())
      {
          int x = itr1.next();
          if(visited.contains(x))
            continue;
        System.out.println("entered "+x);
        if(hs.contains(x+k))
           count++;
        if(hs.contains(x-k))
          count++;
        //if(hs.contains(x))
          //System.out.prin tln("yes");
        hs.add(x);
        //for(int y:hs)
          System.out.println("ended ");
      }
      return count;

    }
    public final static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      ArrayList<Integer> numbers=new ArrayList<>();
      for(int i=0;i<n;i++)
        numbers.add(sc.nextInt());
      int k=sc.nextInt();
      System.out.println(countpairs(numbers,k));

    } 
}
//Input:6
//1 1 2 2 3 3
//1

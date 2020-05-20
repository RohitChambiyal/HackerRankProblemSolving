import java.util.*;
public class CloudyDay {
    

    /*    4

    10 1 8 3

    4 5 7 2

    4

    3 9 3 5

    11 10 8 7

    */
    // Complete the maximumPeople function below.
    static long maximumPeople(long[] population, long[] town, long[] cloud, long[] cloudrange) {
        long[] cloudcost = new long[cloud.length];
        long max=Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        
        int t2=0;
        Set<Long> s1 = new HashSet<Long>();
        for(int i=0;i<town.length;i++){
            if(town[i]<min)
                min = town[i];
            if(town[i]>max)
                max = town[i];
            s1.add(town[i]);
        }
        long town2[] = new long[s1.size()];
        Iterator<Long> itrx = s1.iterator();
        while(itrx.hasNext()){
            town2[t2++]=itrx.next();
        }
            
        
        
        //System.out.println("t "+ t2);
        HashMap<Long,Long> cost = new HashMap<Long,Long>();
        for(int i=0;i<town.length;i++){
            if(cost.containsKey(town[i])){          
               long x = cost.get(town[i])+population[i];
               cost.remove(town[i]);
               cost.put(town[i],x);
            }
            else
            cost.put(town[i],population[i]);    
       }
       Arrays.sort(town2);
        HashMap<Long,Integer> visited = new HashMap<Long,Integer>();
        for(int i=0;i<cloudrange.length;i++){
            long cloudpos = cloud[i];
            long range = cloudrange[i];
            long j = cloudpos+range;
            long limit = cloudpos - range;
            long sum=0;
            int plen = t2;
            plen--;
          //  System.out.println("before j "+j);
            if(limit<town2[0])
                limit = town2[0];
                
            if(j>town2[plen])
                j=town2[plen];
            //System.out.println("after j "+j);
            while(j>=limit){
                if(j>=town2[plen]){
                    j=town2[plen];
                    plen--;
                }
        //        System.out.println("entering j "+j);
                if(j<0)
                    break;
                else if(!cost.containsKey(j)){
                    j--;
                  //  System.out.println("j continue "+j);
                    continue;
                }
                else if(!visited.containsKey(j)){
                    visited.put(j,i);
                    sum+= cost.get(j);
                }
                else if(visited.containsKey(j)&&visited.get(j)!=Integer.MIN_VALUE){
                    cloudcost[visited.get(j)] -= cost.get(j);
                    visited.put(j,Integer.MIN_VALUE);
                }
                j--;
            }
            cloudcost[i]= sum;
            
        }
        long sunny = 0;
        for(int i=0;i<town.length;i++){
            if(!visited.containsKey(town[i]))
                sunny+= cost.get(town[i]);
        }
        long maxcost=0;
        for(int i=0;i<cloudcost.length;i++){
            if(cloudcost[i]>maxcost)
                maxcost = cloudcost[i];
        }
        // System.out.println("cost "+cost);
        // System.out.println("Visited "+visited);
        return (sunny+maxcost);

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int tlen = s.nextInt();
        long p[] = new long[tlen];
        long town[] = new long[tlen];
        for(int i=0;i<tlen;i++)
            p[i] =s.nextLong();
        for(int i=0;i<tlen;i++)
            town[i] =s.nextLong();
        int c = s.nextInt();
        long [] cloud =new long[c];
        long [] cloudrange =new long[c];
        for(int i=0;i<c;i++)
            cloud[i] =s.nextLong();
        for(int i=0;i<c;i++)
            cloudrange[i] =s.nextLong();
        System.out.println("result "+maximumPeople(p,town, cloud, cloudrange));
    }
}
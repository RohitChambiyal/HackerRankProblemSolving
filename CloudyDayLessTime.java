import java.util.*;


class city implements Comparable<city>
{
    long location; 
    TreeSet <Integer> clouds;
    long pop;
    
    public city(long location, long pop)
    {
        this.location=location;
        clouds = new TreeSet<Integer>();
        this.pop=pop;
    }
    
    public void addCloud(int x)
    {
        clouds.add(x);
        
    }

    public int compareTo(city arg0) {
        // TODO Auto-generated method stub
        return Long.compare(location, arg0.location);
    }
    
    
    public String toString()
    {
        
        return "location :" +location +" "+clouds.toString();
        
        
    }
    
}

class cloud implements Comparable<cloud>
{
    long start;
    long end;
    TreeSet <Integer> cities;
    HashSet <city> cities2;
    
    public cloud(long l, long m)
    {
        
        this.start=l;
        this.end = m;
        cities = new TreeSet <Integer>();
        
        //test
        cities2 = new HashSet<city>();
        
    }
    
    public void addCity(int x)
    {
        cities.add(x);
        
    }
    
    public String toString()
    {
        return "cloud at :"+start +" covers these cities : " + cities.toString() + cities2.toString();
        
        
    }

    public int compareTo(cloud arg0) {
        // TODO Auto-generated method stub
        return Long.compare(start, arg0.start);
    }
    
}


public class CloudyDayLessTime {
 
    // Complete the maximumPeople function below.
    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
         
              int N= p.length;
            int M= y.length;
            
            
            TreeMap<Long, city> CityList= new TreeMap<Long, city>();
            ArrayList<cloud> CloudList = new ArrayList<cloud>();
            
            
            for(int i=0;i<p.length;i++)
            {
                city q = CityList.get(x[i]);
                
                if(q !=null)
                {
                    q.pop+=p[i];
                    CityList.put(x[i], q);
                    
                }
                else
                {
                    CityList.put(x[i], new city(x[i] , p[i]));
                    
                }
                
                
                
                
                //CityList.add(new city(x[i], p[i]));
                
            }
            //create segments yi-r, yi+r
            for(int i=0;i< y.length;i++)
            {
                CloudList.add(new cloud(y[i]-r[i], y[i]+r[i]));
                
            }
            
             for(int i=0;i< CloudList.size();i++)
             {
                 
                 SortedMap <Long , city> curr = (SortedMap<Long, city>) CityList.subMap(CloudList.get(i).start,CloudList.get(i).end+1);
                 
                 
                // Iterator iter = curr.iterator();
                 
                 ArrayList<Long> toRemove = new ArrayList<Long>();
                 
                 
                 
                 for(Map.Entry<Long, city> entry : curr.entrySet())
                 {
                     
                    city q= (city) entry.getValue();
                    
                    if(q.clouds.size()>0)
                    {
                        toRemove.add(entry.getKey());
                    }
                    else{
                        q.clouds.add(i);
                        CloudList.get(i).cities2.add(q);
                    }
                     
                 }
                 
                 for(Long rem : toRemove)
                 {
                     city temp = CityList.get(rem);
                     CloudList.get(temp.clouds.first()).cities2.remove(temp);
                     
                     CityList.remove(rem);
                 }
                 
                 
             }
             
             System.out.println(CloudList.toString());
             System.out.println(CityList.toString());
             
             
             long MAXPOP =0;
            
            long SunnyPop=0;
            
            
            for(Map.Entry<Long, city> entry : CityList.entrySet())
            {

                int q = entry.getValue().clouds.size();
                
                if(q == 0)
                {    SunnyPop+= entry.getValue().pop;
                    //System.out.println("popped sunny pop");
                }
            }
      
            
            for(int i=0;i< CloudList.size();i++)
            {
                
                long acc=0;
                for(city q : CloudList.get(i).cities2)
                {
                    
                    if(q.clouds.size()==1 && q!=null)
                    {
                        acc+=q.pop;
                        //System.out.println("popped clouds pop");
                    }
                    
                }
                MAXPOP = Math.max(MAXPOP,acc);
            }
                
                
            
            
            return MAXPOP+ SunnyPop;
         
     
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
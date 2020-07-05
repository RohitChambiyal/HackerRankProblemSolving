package Non_Uploaded_Git;
import java.util.*;

class edge implements Comparable<edge>{
    int source;
    int dest;
    int weight;
    edge(int source,int dest,int weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(edge other){
        return this.weight-other.weight;
    }
}
class ranking{
    int parent;
    int rank;
    ranking(int parent){
        this.parent = parent;
        this.rank = 1;
    }
}
public class KruskalMST {
    
    static int findParent(Vector<ranking> checkparent,int i){
        if(checkparent.get(i).parent != i )
            return findParent(checkparent,checkparent.get(i).parent);
        return i;
    }
    static void union1(Vector<ranking> checkparent, int x,int y){
        int parentx = findParent(checkparent,x);
        int parenty = findParent(checkparent,y);
        if(checkparent.get(parentx).rank>checkparent.get(parenty).rank)
            checkparent.get(y).parent = checkparent.get(x).parent;
        else if(checkparent.get(parentx).rank<checkparent.get(parenty).rank)
            checkparent.get(x).parent = checkparent.get(y).parent;
        else{
            checkparent.get(y).parent = checkparent.get(x).parent;
            checkparent.get(parentx).rank +=1;       
            }

    }
   /*
   ------------------Only For Hackerrank Case 5--------------------
    static void union(Vector<ranking> checkparent, int x,int y){
        int parentx = findParent(checkparent,x);
        int parenty = findParent(checkparent,y);
        checkparent.get(parentx).parent = parenty;
    }
    */
 
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        int n = gFrom.size();
        Vector<edge> alledges = new Vector<edge>();
        for(int i=0;i<n;i++){
            alledges.add(new edge(gFrom.get(i)-1,gTo.get(i)-1,gWeight.get(i)));
        }
        Vector<ranking> checkparent = new Vector<ranking>();
        for(int i=0;i<gNodes;i++)
            checkparent.add(new ranking(i));
        int sum=0;
        HashSet<Integer> visited = new HashSet<Integer>();
        Collections.sort(alledges);
        int count=0;
        int i =0;
        int parentsrc,parentdest;
        // HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
        while(count<(gNodes-1)){
            
            parentsrc = findParent(checkparent, alledges.get(i).source);
            parentdest = findParent(checkparent, alledges.get(i).dest);
            if(parentsrc!=parentdest){
                sum+= alledges.get(i).weight;
                union1(checkparent,alledges.get(i).source, alledges.get(i).dest);
                count++;
                // result.put(alledges.get(i).source,alledges.get(i).dest);
                // System.out.println("source "+(alledges.get(i).source+1)+" dest "+(alledges.get(i).dest+1)); 
            }
            i++;
        }
        return sum;
        
    }



    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int edge = s.nextInt();
        List<Integer> starting = new LinkedList<Integer>();
        List<Integer> Dest = new LinkedList<Integer>();
        List<Integer> weight = new LinkedList<Integer>();
        for(int i=0;i<edge;i++){
            starting.add(s.nextInt());
            Dest.add(s.nextInt());
            weight.add(s.nextInt());
        }
        System.out.println(kruskals(n, starting, Dest, weight));
    }
}
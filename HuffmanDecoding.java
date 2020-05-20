package Data_Structure;
import java.util.*;
 
abstract class HDNode implements Comparable<HDNode> {
    
  	public  int frequency; // the frequency of this tree
    public  char data;
    public  HDNode left, right; 
    public HDNode(int freq) { 
    	frequency = freq;
   	}
 
    // compares on the frequency
    public int compareTo(HDNode tree) {
        return frequency - tree.frequency;
    }
  
}
 
class HuffmanLeaf extends HDNode {
    
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
  
}
 
class HuffmanHDNode extends HDNode {
    
    public HuffmanHDNode(HDNode l, HDNode r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class HuffmanDecoding {

/*  
	class HDNode
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  HDNode left, right;
    
*/ 
    static int find(String s,HDNode root,int i){
        if(root.left==null&&root.right==null){
            System.out.print(root.data);
            return i;
        }
        
        if(s.charAt(i)=='0')
            return find(s,root.left,i+1);
        if(s.charAt(i)=='1')
            return find(s,root.right,i+1);
        return i;
    }

    void decode(String s, HDNode root) {
        int n = s.length();
        int i=0;
        while(i<n){
            i=find(s,root,i);

        }

    }
}



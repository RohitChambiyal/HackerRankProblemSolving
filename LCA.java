package Data_Structure;
import java.util.*;
import java.io.*;

class LCANode {
    LCANode left;
    LCANode right;
    int data;
    
    LCANode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LCA {

	/*
    class LCANode 
    	int data;
    	LCANode left;
    	LCANode right;
	*/
	public static LCANode lca(LCANode root, int v1, int v2) {
        Queue<LCANode> queue1 = new LinkedList<LCANode>();
        queue1.add(root);
        
        int small;
        int large;
        if(v1>v2){
            small = v2;
            large = v1;
        }
        else{
            small = v1;
            large = v2;
        }
        if(root.data>small&&root.data<large)
            return root;
        
        while(!queue1.isEmpty()){
            LCANode temp = queue1.poll();
            if(temp.data>small&&temp.data<large){
                return temp;
            }
            if(temp.data==small)
                return temp;
            if(temp.data==large)
                return temp;
            if(temp.left!=null)
                queue1.add(temp.left);
            if(temp.right!=null)
                queue1.add(temp.right);
        }
        return null;
    }

	//public static LCANode insert(LCANode root, int data) {
    }

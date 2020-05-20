package Data_Structure;
import java.util.*;
import java.io.*;


 class NodeTopView {
    NodeTopView left;
    NodeTopView right;
    int data;
    
    NodeTopView(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TopView {

	/* 
    
    class NodeTopView 
    	int data;
    	NodeTopView left;
    	NodeTopView right;
	*/
	public static void topView(NodeTopView root) {
      Map<Integer,NodeTopView> hm1 = new TreeMap<Integer,NodeTopView>();
      
      class NodeTopViewphd{
          int index;
          NodeTopView root;
          NodeTopViewphd(NodeTopView root, int index){
              this.index = index;
              this.root = root;
          }
      }

      Queue<NodeTopViewphd> queue1 = new LinkedList<NodeTopViewphd>();
      queue1.add(new NodeTopViewphd(root,0));
      hm1.put(0,root);
      while(!queue1.isEmpty()){
            NodeTopViewphd temp  = queue1.poll();
            if(temp.root.left!=null){
                queue1.add(new NodeTopViewphd(temp.root.left,temp.index-1));
                if(!hm1.containsKey(temp.index-1)){
                    hm1.put(temp.index-1,temp.root.left);
                }
            }
            if(temp.root.right!=null){
                queue1.add(new NodeTopViewphd(temp.root.right,temp.index+1));
                if(!hm1.containsKey(temp.index+1)){
                    hm1.put(temp.index+1,temp.root.right);
                }
            }
      } 
      Iterator itr1 = hm1.entrySet().iterator();
      while(itr1.hasNext()){
          Map.Entry m1 = (Map.Entry)itr1.next();
          NodeTopView n1 =(NodeTopView) m1.getValue();
          System.out.print(n1.data+" ");
      }
    //   1 2 4 14 23 37 108 111 115 116 83 84 85 

    }
}
//	public static NodeTopView insert(NodeTopView root, int data) {

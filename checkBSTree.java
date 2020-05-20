/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*//*
    boolean checkHere(Node root,int left,int right){
       if(root==null)
            return true;
        if(root.data<=left||root.data>=right)
            return false;
        return (checkHere(root.left,left,root.data)&&checkHere(root.right,root.data,right));
        
    }
    boolean checkBST(Node root) {
        return checkHere(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
*/
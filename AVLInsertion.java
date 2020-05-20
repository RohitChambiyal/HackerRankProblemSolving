package Data_Structure;


class Node {
int val;	//Value
int ht;		//Height
Node left;	//Left child
Node right;	//Right child
}
public class AVLInsertion {

static int height(Node N) { 
    if (N == null) 
        return -1; 

    return N.ht; 
} 

// A utility function to get maximum of two integers 
static int max(int a, int b) { 
    return (a > b) ? a : b; 
} 

// A utility function to right rotate subtree rooted with y 
// See the diagram given above. 
static Node rightRotate(Node y) { 
    Node x = y.left; 
    Node T2 = x.right; 

    // Perform rotation 
    x.right = y; 
    y.left = T2; 

    // Update heights 
    y.ht = max(height(y.left), height(y.right)) + 1; 
    x.ht = max(height(x.left), height(x.right)) + 1; 

    // Return new root 
    return x; 
} 

// A utility function to left rotate subtree rooted with x 
// See the diagram given above. 
static Node leftRotate(Node x) { 
    Node y = x.right; 
    Node T2 = y.left; 

    // Perform rotation 
    y.left = x; 
    x.right = T2; 

    // Update heights 
    x.ht = max(height(x.left), height(x.right)) + 1; 
    y.ht = max(height(y.left), height(y.right)) + 1; 

    // Return new root 
    return y; 
} 

// Get Balance factor of node N 
static int getBalance(Node N) { 
    if (N == null) 
        return 0; 

    return height(N.left) - height(N.right); 
} 
static Node insert(Node node, int key) { 

    
    if (node == null) {
     Node temp = new Node();
        temp.val = key;
        return (temp); 
        
    }

    if (key < node.val) 
        node.left = insert(node.left, key); 
    else if (key > node.val) 
        node.right = insert(node.right, key); 
    else 
        return node; 

    
    node.ht = 1 + max(height(node.left), 
                        height(node.right)); 

    int balance = getBalance(node); 

    if (balance > 1 && key < node.left.val) 
        return rightRotate(node); 

    if (balance < -1 && key > node.right.val) 
        return leftRotate(node); 
    if (balance > 1 && key > node.left.val) { 
        node.left = leftRotate(node.left); 
        return rightRotate(node); 
    } 

    if (balance < -1 && key < node.right.val) { 
        node.right = rightRotate(node.right); 
        return leftRotate(node); 
    } 


    return node; 
} 

}
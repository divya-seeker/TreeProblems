import java.util.*;
class BST{
    static Scanner sc=new Scanner(System.in);
    
    Node roots;
    BST(){

    }
    Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(val<root.val){
            root.left=insert(root.left,val);
        }
        if(val>root.val){
            root.right=insert(root.right,val);
        }
        return root;
    }
    
    Node deleteNode(Node root,int val){
        if(root==null)return null;
       
        
        if(root.val<val){
            root.right=deleteNode(root.right,val);
        }
        else if(root.val>val){
            root.left=deleteNode(root.left,val);
        }
        else{
            if(root.left==null&&root.right==null)
               return null;
            else if(root.left==null)
            return root.right;
            else if(root.right==null)
            return root.left; 
            else{
                Node pred=root.right;
                while(pred.left!=null){
                    pred=pred.left; 
                }
               root.val=pred.val;
               root.right=deleteNode(root.right,root.val);
            }
        }
        
        return root;
    }
    int ans=-1;
    int floor(Node root,int key){
        if(root==null)
           return ans;
        
        if(key>root.val){
             ans=root.val;
             return floor(root.right,key);
        }
        if(key<root.val){
             return floor(root.left,key);
        }
        
        return ans;
    }
    static boolean isBst(Node root){
        return isBstsolve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static boolean isBstsolve(Node root,int ll,int ul){
        if(root==null)
        return true;

        if(root.val>=ll&&root.val<=ul){
            return isBstsolve(root.left, ll, root.val-1)
            && isBstsolve(root.right, root.val+1, ul);
        }
        return false;
    }
    void printInorder(Node root){
        if(root==null)return;
        printInorder(root.left);
        System.out.print(root.val+"  ");
        printInorder(root.right);
    }
    /**
     * @param args
     */
    
    public static void main(String[] args) {
        
        BST tree=new BST();
        tree.roots=null;
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int value=sc.nextInt();
            tree.roots=tree.insert(tree.roots,value);
        }
        tree.printInorder(tree.roots);
        System.out.println();
        // tree.deleteNode(tree.roots, 5);
        // tree.printInorder(tree.roots);
        int z=tree.floor(tree.roots, 0);
        System.out.println(z);

        // Tree tree2=new Tree();
        // System.out.println("Enter data for root");
        
    
        // Node rootNode=tree2.buildTree();
        // System.out.println(isBst(rootNode));
    }
}
class Tree{
    static Scanner sc=new Scanner(System.in);
    // Scanner sc=new Scanner(System.in);
    Node root;
    Tree(){
          
    }
    Node buildTree(){
       
        
        System.out.println("Enter the data");
        int d=sc.nextInt();
        if(d==-1)return null;
        Node n=new Node(d);
        
        System.out.println("Enter data to the left of "+ d);
        
        n.left=buildTree();
        System.out.println("Enter data to the right of "+ d);
        
        n.right=buildTree();
        return n;
    }
}
class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val=val;
        left=right=null;
    } 
}

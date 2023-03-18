import java.util.*;
class Tree {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.root=new Node(2);
        tree.root.left=new Node(3);
        tree.root.right=new Node(5);
        tree.root.left.left=new Node(6);
        tree.root.left.right=new Node(9);
        tree.root.right.left=new Node(11);
        tree.root.right.right=new Node(13);

        final Node ances=tree.lca(tree.root,11,13);
       //  System.out.println(ances.data);
   }
    Node root;
    Tree(){
        root=null;
    }
    boolean foundA=false;
    boolean foundB=false; 
    Node lca(Node root,int a,int b){
        if(root==null)return null;
        Node lnode=lca(root.left,a,b);
        Node rnode=lca(root.right,a,b);
        if((lnode!=null&&rnode!=null)||(lnode!=null&&(root.data==a||root.data==b))||(rnode!=null&&(root.data==a||root.data==b)))
           return root;
        if(lnode!=null&&rnode==null){
            return lnode;
        }
        if(lnode==null&&rnode!=null){
            return rnode;
        }
        return null;
    }
    
}
class Node{
    @Override
    public String toString() {
        return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
    }
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
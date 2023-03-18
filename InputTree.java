import java.util.*;
class Node{
     int val;
     Node left,right;
     Node(int val){
        this.val=val;
        left=right=null;
     }
}
class InputTree{
    static Scanner sc=new Scanner(System.in);
    static Node root;
    InputTree(){
        root=null;
    }
    Node BuildTree(){

        System.out.println("Enter the data");
        int data=sc.nextInt();
        

        if(data==-1)return null;
        Node n=new Node(data);
        System.out.println("Enter the data for left of "+data);
        n.left=BuildTree();
        System.out.println("Enter the data for right of "+data);
        n.right=BuildTree();

        return n;
    }
    void printPostOrder(Node root){
        if(root==null)return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }
    public static void main(String[] args) {
        System.out.println("Building a Binary Tree");
        System.out.println("Enter Root node data");
        InputTree tree=new InputTree();
        Node rootNode=tree.BuildTree();
        tree.printPostOrder(rootNode);
    }
}
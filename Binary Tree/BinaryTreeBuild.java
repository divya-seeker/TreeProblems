import java.util.*;
public class BinaryTreeBuild {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,-1,-1};
        BinaryTree bt=new BinaryTree();
        bt.root=bt.buildTree(nodes);
        System.out.println();
        Node a=bt.lca(bt.root,2,4);
        if(a!=null)System.out.println(a.data);
    }

    Node lca(Node root, int n1,int n2)
	{
		if(root==null)return null;
		
		if(root.data==n1)return root;
		if(root.data==n2)return root;
		
		Node l=lca(root.left,n1,n2);
		Node r=lca(root.right,n1,n2);
		
		if(l!=null&&r!=null)return root;
		if(l!=null||r!=null)return l!=null?l:r;
 		return null;
	}
    // Node lca(Node root,int a,int b){
    //     if(root==null)return null;
    //     Node lnode=lca(root.left,a,b);
    //     Node rnode=lca(root.right,a,b);
    //     if((lnode!=null&&rnode!=null)||(lnode!=null&&(root.data==a||root.data==b))||(rnode!=null&&(root.data==a||root.data==b)))
    //        return root;
    //     if(lnode!=null&&rnode==null){
    //         return lnode;
    //     }
    //     if(lnode==null&&rnode!=null){
    //         return rnode;
    //     }
    //     return null;
    // }

    static class BinaryTree{
        static int idx=-1;
        Node root;
        BinaryTree (){
            root=null;
        }
        public BinaryTreeBuild.Node lca(BinaryTreeBuild.Node root2, int i, int j) {
            return null;
        }
        Node buildTree(int nodes[]){
             idx++;
             if(nodes[idx]==-1)return null;
             Node newNode=new Node(nodes[idx]);
             newNode.left =buildTree(nodes);
             newNode.right=buildTree(nodes);
             return newNode;
        } 
    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data =data;
            this.left =null;
            this.right=null;
        }
    }

}

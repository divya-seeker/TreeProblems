import java.util.*;
class ConstructTreePreIn{
    static class Node{
        int val;
        Node left,right;
        Node(int val){
           this.val=val;
           left=right=null;
        }
    }
    Node root;
    ConstructTreePreIn(){
        root=null;
    }
    static Scanner sc=new Scanner(System.in);
    
    Node solve(int in[],int pre[],int preS,int preE,int inS,int inE,int n){
        if(inS>inE)return null;//Base Case
        //root
        int ele=pre[preS];
        Node nodes=new Node(ele);
        int index=-1;
        for(int i=inS;i<=inE;i++)
            if(in[i]==ele)
               index=i;
        
        //Trivial
        int LinS=inS;
        int RinE=inE;
        int LpreS=preS+1;
        int RpreE=preE;
        //Non trivial
        int LinE=index-1;
        int RinS=index+1;
        int LpreE=LinE-LinS+LpreS;
        int RpreS=LpreE+1;

        nodes.left=solve(in,pre,LpreS,LpreE,LinS,LinE, n);
        
        nodes.right=solve(in,pre,RpreS,RpreE,RinS,RinE, n);

        return nodes;
    }
    void postOrder(Node node){
        if(node==null)return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    public static void main(String[] args) {
        int in[] ={4,2,5,1,8,6,9,3,7};
        int pre[]={1,2,4,5,3,6,8,9,7};
        ConstructTreePreIn tree=new ConstructTreePreIn();
        Node rootNode=tree.solve(in,pre,0,pre.length-1,0,in.length-1,9);
        tree.postOrder(rootNode);
    }
}

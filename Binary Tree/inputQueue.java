import java.util.*;
public class inputQueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new ArrayDeque<Integer>();
        System.out.println("Enter the root node of tree");
        int root=sc.nextInt();
        q.add(root);
        while(!q.isEmpty()){
            int i=q.poll();
            System.out.println("Enter the right neighbour or enter -1 if no node is present");
            int r=sc.nextInt();
            
            System.out.println("Enter the left neighbour or enter -1 if no node is present");
            int l=sc.nextInt();

           if (l!=-1) q.add(l);
           if (r!=-1) q.add(r);
           
        }
        
    }
}

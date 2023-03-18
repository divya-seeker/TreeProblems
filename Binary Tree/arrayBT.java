import java.util.*;
class arrayBT{
    public static void main(String[] args) {
        Array_Imp obj=new Array_Imp(6);
      
        obj.Left (1,1);
        obj.Right(4,1);
        obj.Left (5,2);
        obj.Right(6, 3);
        obj.print();
    }
}
class Array_Imp{
    
    ArrayList<Integer> arr=new ArrayList<Integer>();
    Array_Imp(int root){
        arr.set(1,root);
        
    }
   
   
    void Left(int val,int par){
         int t=2*par;
         if(par==0){System.out.println("Error");return;}
         arr.set(t,val);
    }
    void Right(int val,int par){
        int t=2*par+1;
        if(par==0){System.out.println("Error");return;}
        arr.set(t,val);
   }
   void print(){
    for(int e:arr){
        if(e!=0)
        System.out.println(e);
    }
   }
}
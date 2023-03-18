import java.util.*;
public class Sqrt {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int nd=mySqrt(n);
        double d=fun(nd,n,2);
        System.out.println(d);
    }
    static double fun(int x,int n,int pre){
        double ans=x;
        double add=1.0;
        for(int i=1;i<=pre;i++){
            add=add*0.1;
            ans=ans+add;
            for(int j=1;j<=9;j++){
                int a=(int)ans;
                double b=add*j;
                double t=a+b;
                if(t*t==n)return t;
                else if(t*t<n){
                    ans=t;
                }
                else break;
            }
        }
        return ans;
    }
    public static int mySqrt(int x) {
        int s=0;
        int e=x;
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if((long)mid*mid==x)return mid;
            else if((long)mid*mid<x){
                ans=mid;
                s=mid+1;
            }
            else 
                e=mid-1;
        }
        return ans;
    }

}

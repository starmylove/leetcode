package middle;

public class num_50 {
    //Pow(x, n)

    //快速幂
    public double myPow(double x, int n) {
        long N = n ;
        return N>=0? quickMul(x,N) : 1.0/quickMul(x,-N);
    }
    public double quickMul(double x , long n){
        if(n==0) {
            return 1.0;
        }
        double y = quickMul(x,n/2);
        return (n&1)==1? y*y*x : y*y;
    }

}

package easy;

public class Offer_11 {
    public static void main(String[] args) {
        int[] numbers = new int[]{10,1,10,10,10};
        int ans = minArray1(numbers);
        System.out.println(ans);
    }

    public static int minArray(int[] numbers) {
        //二分法
        if(numbers[0]<numbers[numbers.length-1]) {
            return  numbers[0];
        }
        int l = 0 , r = numbers.length-1;
        int mid=(l+r)/2;
        while(l<r){
            if(numbers[l]==numbers[mid]&&numbers[mid]==numbers[r]){
                int min = numbers[l];
                while(l<r) {
                    min = min > numbers[l] ? numbers[l] : min;
                    l++;
                }
                return min;
            }
            if(numbers[mid]>=numbers[l]){
                l=mid;
                mid=(l+r)/2;
                if(l==mid){
                    return Math.min(numbers[l],numbers[r] );
                }
            }else{
                r=mid;
                mid=(l+r)/2;
                if(l==mid){
                    return Math.min(numbers[l],numbers[r] );
                }
            }
        }
        return numbers[l];
    }
    public static int minArray1(int[] numbers) {
        //官方题解
        int low = 0 , pivot , high = numbers.length-1;
        while(low<high){
            pivot = low + (high-low)/2;
            if(numbers[pivot]>numbers[high]){
                low = pivot + 1 ;
            }else if(numbers[pivot]<numbers[high]){
                high = pivot ;
            }else {
                high--;
            }
        }
        return numbers[low];
    }
}

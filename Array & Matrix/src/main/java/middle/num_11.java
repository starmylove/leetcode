package middle;

public class num_11 {
//    给你 n 个非负整数 a1，a2，...，an，
//    每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
//    垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
//    使得它们与 x 轴共同构成的容器可以容纳最多的水。
public static void main(String[] args) {
    int[] height = {1,8,6,2,5,4,8,3,7};
    int ans = maxArea(height);
    System.out.println(ans);
}
    public int maxArea_1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public int maxArea_2(int[] height){
        int l = 0 , r = height.length-1;
        int ans = 0 ;
        while(l < r){
            ans = Math.max(ans,(r-l)*Math.min(height[l],height[r]));
            if(height[l]<=height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

public static int maxArea(int[] height) {
    int max = 0 ;
    int len = height.length;
    int i = 0 , j = len - 1 ;
    int temp;
    while(i<j){
        if((temp = square(height,i,j))>max) {
            max = temp;
        }
        if(move(height,i,j)) {
            i++;
        } else {
            j--;
        }
    }
    return max ;
}
    private static boolean move(int[] height, int i, int j) {
        //如果返回true，左指针右移，否则右指针左移
        do{
            if(height[i]<height[j]) {
                return true;
            } else if(height[i]>height[j]) {
                return false;
            } else{
                i++;
                j--;
            }
        }while((height[i]==height[j])&&i<j);

        return true;
    }

    public static int min(int a , int b ){
        return (a>=b)?b:a;
    }

    public static int square(int[] height,int i , int j){
        return (j-i)*min(height[i],height[j]);
    }


}

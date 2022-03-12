package middle;

public class Offer_4 {
    /*
    * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
    * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
    * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    */
    public static void main(String[] args) {
        int[][] nums = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean flag = findNumberIn2DArray(nums,23);
        System.out.println(flag);
    }
    public static boolean solution(int[][] nums,int m){
        //从左上角往右下角找，束手无策
        //换个角度，找个简单具体的例子来分析，试图寻找普遍的规律
        //比如找7
        //如果从左上角开始找，判断当前位置数字与目标数字后，剩下的搜寻空间就变成
        //了非矩形，但如果从右上角或左下角开始搜索，剩下的搜寻空间就变成矩形
        if(nums.length==0) {
            return false;
        }
        int i=0,j=nums[0].length-1;
        int num = nums[0][nums[0].length-1];
        while(i>=0 && i<nums.length && j>=0 && j<nums[0].length){
            if(nums[i][j]==m){
                return true;
            }else if(nums[i][j]>m){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) {
            return false;
        }
        int i=0,j=matrix[0].length-1;
        while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
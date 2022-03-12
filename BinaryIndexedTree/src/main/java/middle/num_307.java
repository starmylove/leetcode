package middle;

public class num_307 {
    //307. 区域和检索 - 数组可修改
    /*
    * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
实现 NumArray 类：
    NumArray(int[] nums) 用整数数组 nums 初始化对象
    void update(int index, int val) 将 nums[index] 的值更新为 val
int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
    * */
    int[] tree , num ;
    int n ;
    public num_307(int[] nums) {
        n = nums.length;
        tree = new int[n+1];
        num = nums ;
        for (int i = 0; i < n; i++) {
            add(i+1,num[i]);
        }
    }
    public void add(int x , int u){
        for (int i = x; i <= n ; i+=lowbit(i)) {
            tree[i] += u ;
        }
    }
    private int lowbit(int i) {
        return i & (-i );
    }
    public void update(int index, int val) {
        add(index+1,val - num[index]);
        num[index] = val ;
    }
    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }
    public int query(int x){
        int sum = 0 ;
        for( ; x !=0 ; x -= lowbit(x)){
            sum += tree[x];
        }
        return sum ;
    }
}












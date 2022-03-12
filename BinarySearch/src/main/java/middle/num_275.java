package middle;

import org.junit.Test;

public class num_275 {
    //275. H 指数 II
    /*
    * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，
    * citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。h 指数的定义：h 代表“高引用次数”（high citations），
    * 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
    * 且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
    * 请你设计并实现对数时间复杂度的算法解决此问题。
    * 输入：citations = [0,1,3,5,6] 输出：3
    * 输入：citations = [1,2,100] 输出：2
    * */
    public int hIndex(int[] citations) {
        int l = 0 , n = citations.length , r = n - 1 ;
        while (l<=r){
            int mid = (l + r )>>1;
            if(citations[mid] >= n - mid){
                r = mid -1;
            }else {
                l = mid + 1 ;
            }
        }
        return n - l ;
    }
    public int hIndex1(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
    @Test
    public void test(){
        int[] citations = new int[]{3,3,3};
        hIndex1(citations);
    }
}

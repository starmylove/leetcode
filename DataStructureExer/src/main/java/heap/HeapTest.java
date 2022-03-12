package heap;

import org.junit.Test;

public class HeapTest {

    public int[] buildMinHeap(int[] nums){
        int length = nums.length;
        int[] heap = new int[length];
        //下面建一个最小堆
        heap[0] = nums[0];
        for (int i = 1 ; i < length ; i ++){
            heap[i] = nums[i];
            int index = i ;
            while (index!=0 && heap[index] < heap[(index-1)/2]){
                swap(heap,index,(index-1)/2);
                index = (index-1)/2 ;
            }
        }
        return heap;
    }
    public int[] buildMaxHeap(int[] nums){
        int length = nums.length;
        int[] heap = new int[length];
        //下面建一个最小堆
        heap[0] = nums[0];
        for (int i = 1 ; i < length ; i ++){
            heap[i] = nums[i];
            int index = i ;
            while (index!=0 && heap[index] > heap[(index-1)/2]){
                swap(heap,index,(index-1)/2);
                index = (index-1)/2 ;
            }
        }
        return heap;
    }
    @Test
    public void test(){
        int[] nums = new int[]{5,6,9,4,7,1,3,8};
        int[] minHeap = buildMinHeap(nums);
        int[] maxHeap = buildMaxHeap(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(minHeap[i]);
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(maxHeap[i]);
        }
    }
    public void swap(int[] nums , int i , int j ){
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
}

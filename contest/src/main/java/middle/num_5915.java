package middle;

import java.util.List;

public class num_5915 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int leftIndex = Integer.MAX_VALUE, rightIndex=Integer.MIN_VALUE ,
                lastIndex = Integer.MAX_VALUE , cur , n = 0 ,a,b,c , min = Integer.MAX_VALUE;
        ListNode p = head;
        while (p != null){
            n ++ ;
            p = p.next;
        }
        if( n < 4) {
            return new int[]{-1,-1};
        }
        p = head ;
        a = p.val;
        p = p.next;
        b=p.val;
        p=p.next;
        c=p.val;
        for (int i = 2; i < n; i++) {
            if(( a < b && b > c) || ( a > b && b < c)){
                leftIndex = Math.min(leftIndex,i-1);
                rightIndex = Math.max(rightIndex,i-1);
                if(lastIndex != Integer.MAX_VALUE){
                    min = Math.min(min,i - 1 - lastIndex);
                }
                lastIndex = i - 1 ;
            }
            p = p.next;
            a = b;
            b = c ;
            if(p != null) {
                c = p.val;
            }

        }
        if(leftIndex == rightIndex || leftIndex == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }
        return new int[]{min,rightIndex - leftIndex};
    }
}

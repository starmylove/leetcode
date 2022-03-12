package middle;

public class num_739 {
    //739. 每日温度
    /*
    * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
    * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
    * */
    //单调栈 100% 29%
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int index = -1 ;
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if(index==-1 || temperatures[i]<=temperatures[stack[index]]) {
                stack[++index] = i ;
            } else {
                while (index!=-1 && temperatures[stack[index]]<temperatures[i]){
                    int popIndex = stack[index--];
                    ans[popIndex] = i - popIndex;
                }
                stack[++index ] = i ;
            }
        }
        return ans;
    }
}

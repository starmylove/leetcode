package middle;

import java.util.*;

public class num_254 {
    public List<List<Integer>> getFactors(int n) {
        return dfs(2,n);
    }

    private List<List<Integer>> dfs(int start, int num ) {
        if(num == 1){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = start; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(i);
                simpleList.add(num/i);
                list.add(simpleList);
                for(List<Integer> l : dfs(i,num/i)){
                    l.add(i);
                    list.add(l);
                }
            }
        }
        return list;
    }

}

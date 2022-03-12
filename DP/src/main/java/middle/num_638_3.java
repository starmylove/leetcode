package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_638_3 {
    Map<List<Integer>,Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for(List<Integer> sp : special){
            int totalCount = 0 , totalPrice = 0 ;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i)*price.get(i);
            }
            if(totalCount>0 && totalPrice > sp.get(n)){
                filterSpecial.add(sp);
            }
        }
        return dfs(price,filterSpecial,needs,n);
    }

    private int dfs(List<Integer> price, List<List<Integer>> filterSpecial, List<Integer> curNeeds, int n) {
        if(!map.containsKey(curNeeds)){
            int minPrice = 0 ;
            for (int i = 0; i < n; i++) {
                minPrice += curNeeds.get(i)*price.get(i);
            }
            for(List<Integer> curSpecial : filterSpecial){
                List<Integer> nxtNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if(curSpecial.get(i)<=curNeeds.get(i)){
                        nxtNeeds.add(curNeeds.get(i)-curSpecial.get(i));
                    }else {
                        break;
                    }
                }
                if(nxtNeeds.size()==n){
                    minPrice = Math.min(minPrice,dfs(price,filterSpecial,nxtNeeds,n));
                }
            }
            map.put(curNeeds,minPrice);
        }
        return map.get(curNeeds);
    }
}

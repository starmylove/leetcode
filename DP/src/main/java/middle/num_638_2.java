package middle;

import java.util.ArrayList;
import java.util.List;

public class num_638_2 {
    int minPrice;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice = directlyBuy(price, needs);
        helper(price, special, needs, 0, 0);
        return minPrice;
    }

    private int directlyBuy(List<Integer> price, List<Integer> needs){
        int total = 0;
        int n = price.size();
        for(int i = 0; i < n; i++){
            total += price.get(i) * needs.get(i);
        }
        return total;
    }

    // 判断能不能用这个offer， offer是嵌套在大礼包的某一条offer
    private boolean canUse(List<Integer> offer, List<Integer> needs){
        int n = needs.size();
        for(int i = 0; i < n; i++){
            if(needs.get(i) < offer.get(i))//需要的东西数量小于offer要求你购买的数量
            {
                return false;
            }
        }
        return true;
    }

    // 因为返回的minprice是全局变量，所以返回空
    private void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int used, int index){
        // ==base case==
        // 1. 花的钱大于你目前能花的最小价格，直接返回回溯，找下去没意义
        if(used >= minPrice) {
            return;
        }
        // 2. 找的第n个物品，已经不能用offer了，就直接不用offer买剩下的，并且更新minPrice
        if(index == special.size()){
            used += directlyBuy(price, needs);
            if(used < minPrice) {
                minPrice = used;
            }
            return;
        }

        List<Integer> offer = special.get(index);
        if(canUse(offer, needs)){
            // 使用这个offer， 并且更新needs需求的个数
            int n = needs.size();
            List<Integer> updateNeed = new ArrayList<>();
            for(int i = 0; i < n; i++){
                updateNeed.add(needs.get(i) - offer.get(i));
            }
            //index可以不变，因为offer可以重复使用，直到不能用，自动跳到else里面index+1
            helper(price, special, updateNeed, used + offer.get(n), index);
        }
        //不能写else
        helper(price, special, needs, used, index + 1);//不能用就index+1找下一个offer
    }
}

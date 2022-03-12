package middle;

import org.junit.Test;

import java.util.*;

public class num_1418 {
    /*
    * 给你一个数组 orders，表示客户在餐厅中完成的订单，
    * 确切地说， orders[i]=[customerName i,tableNumber i,foodItem i] ，
    * 其中 customerName i 是客户的姓名，tableNumber i 是客户所在餐桌的桌号，
    * 而 foodItem i 是客户点的餐品名称。请你返回该餐厅的 点菜展示表 。
    * 在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
    * 后面每一列都是按字母顺序排列的餐品名称。
    * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，
    * 第一列应当填对应的桌号，后面依次填写下单的餐品数量。
    * 注意：客户姓名不是点菜展示表的一部分。
    * 此外，表中的数据行应该按餐桌桌号升序排列。
    * */
    //答案里最快的方法 ，空间96，时间100
    public List<List<String>> displayTable2(List<List<String>> orders) {
        HashSet<String> set = new HashSet<>();
        for(List<String> o:orders){
            set.add(o.get(2));
        }
        List<String> food = new ArrayList<>(set);
        food.sort(null);
        food.add(0,"Table");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 1;i<food.size();i++){
            map.put(food.get(i),i);
        }
        int foodCount = food.size();
        ArrayList<String>[] list = new ArrayList[501];
        for(List<String> o:orders){
            int o1 = Integer.valueOf(o.get(1));
            if(list[o1]==null){
                list[o1] = new ArrayList<String>(Collections.nCopies(foodCount+1, "0"));
                list[o1].set(0,o.get(1));
            }
            int idx = map.get(o.get(2));
            int num = Integer.valueOf(list[o1].get(idx)) + 1;
            list[o1].set(map.get(o.get(2)),String.valueOf(num));
        }
        List<List<String>> res = new ArrayList<>();
        res.add(food);
        for(int i = 1;i<501;i++){
            if(list[i]!=null){
                res.add(list[i]);
            }
        }
        return res;
    }
    //还有bug
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> foodSet = new HashSet<>();
        Set<Integer> tableSet = new HashSet<>();
        for(List<String> list: orders){
            foodSet.add(list.get(2));
            tableSet.add(Integer.parseInt(list.get(1)));
        }
        List<String> foods = new ArrayList(foodSet) ;
        List<Integer> tables = new ArrayList(tableSet) ;
        foods.sort(null);
        tables.sort(null);
        int tableCount = tables.size();
        int foodCount = foods.size();
        Map<String,Integer> foodMap = new HashMap<>();
        ans.add(new ArrayList<String>());
        ans.get(0).add("Table");
        for (int i = 0; i < foodCount; i++) {
            String food = foods.get(i);
            foodMap.put(food,i+1);
            ans.get(0).add(food);
        }
        Map<Integer,Integer> tableMap = new HashMap<>();
        for (int i = 0; i < tableCount; i++) {
            List<String> list = new ArrayList<>(Collections.nCopies(foodCount+1, "0"));
            int poll = tables.get(i);
            list.set(0,String.valueOf(poll));
            tableMap.put(poll,i+1);
            ans.add(list);
        }
        for(List<String> list: orders){
            int count = Integer.parseInt(ans.get(tableMap.get(list.get(1))).get(foodMap.get(list.get(2))));
            ans.get(tableMap.get(list.get(1))).set(foodMap.get(list.get(2)),String.valueOf(count+1));
        }
        return ans;
    }
    //自己写的，空间100，时间18
    public List<List<String>> displayTable0(List<List<String>> orders) {
        PriorityQueue<String> foodQueue = new PriorityQueue<>();
        PriorityQueue<String> tableQueue = new PriorityQueue<>((a,b)->Integer.parseInt(a)-Integer.parseInt(b));
        for(List<String> list: orders){
            if(!tableQueue.contains(list.get(1))) {
                tableQueue.offer(list.get(1));
            }
            if(!foodQueue.contains(list.get(2))) {
                foodQueue.offer(list.get(2));
            }
        }
        Map<String,Integer> tableMap = new HashMap<>();
        Map<String,Integer> foodMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int tableCount = tableQueue.size();
        int foodCount = foodQueue.size();
        ans.add(new ArrayList<String>());
        ans.get(0).add("Table");
        for (int i = 0; i < foodCount; i++) {
            String poll = foodQueue.poll();
            foodMap.put(poll,i+1);
            ans.get(0).add(poll);
        }
        for (int i = 0; i < tableCount; i++) {
            List<String> list = new ArrayList<>();
            String poll = tableQueue.poll();
            list.add(poll);
            for (int j = 0; j < foodCount; j++) {
                list.add("0");
            }
            tableMap.put(poll,i+1);
            ans.add(list);
        }
        for(List<String> list: orders){
            int count = Integer.parseInt(ans.get(tableMap.get(list.get(1))).get(foodMap.get(list.get(2))));
            ans.get(tableMap.get(list.get(1))).set(foodMap.get(list.get(2)),String.valueOf(count+1));
        }
        return ans;
    }
    @Test
    public void test(){
        List<List<String>> orders = new ArrayList<>();
        List<String> list1 = new ArrayList<String>(){};
        list1.add("David");
        list1.add("3");
        list1.add("Ceviche");
        List<String> list2 = new ArrayList<String>(){};
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        List<String> list3 = new ArrayList<String>(){};
        list3.add("David");
        list3.add("3");
        list3.add("Fried Chicken");
        List<String> list4 = new ArrayList<String>(){};
        list4.add("Carla");
        list4.add("5");
        list4.add("Water");
        orders.add(list1);
        orders.add(list2);
        orders.add(list3);
        orders.add(list4);
        List<List<String>> lists = displayTable(orders);
        System.out.println(lists);
    }
    @Test
    public void test2(){
        System.out.println((Integer.parseInt("5") - Integer.parseInt("10")));
    }
}












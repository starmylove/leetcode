package easy;

import java.util.LinkedList;
import java.util.List;

public class num_95 {
    //给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
    // 可以按 任意顺序 返回答案。
    public List<TreeNode> generateTrees(int n) {
        if(n == 0 ) {
            return new LinkedList<>();
        }
        return generateTrees(1 , n);
    }

    public List<TreeNode> generateTrees(int start , int end ){
        List<TreeNode> allTrees = new LinkedList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i = start ; i <= end ; i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);
            for(TreeNode lefttree : leftTrees){
                for(TreeNode righttree : rightTrees){
                    TreeNode curTree = new TreeNode(i);
                    curTree.left=lefttree;
                    curTree.right=righttree;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }

}














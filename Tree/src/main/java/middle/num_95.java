package middle;

import java.util.LinkedList;
import java.util.List;

public class num_95 {
    //给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
    // 可以按 任意顺序 返回答案。
    public List<easy.TreeNode> generateTrees(int n) {
        if(n == 0 ) {
            return new LinkedList<>();
        }
        return generateTrees(1 , n);
    }

    public List<easy.TreeNode> generateTrees(int start , int end ){
        List<easy.TreeNode> allTrees = new LinkedList<>();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i = start ; i <= end ; i++){
            List<easy.TreeNode> leftTrees = generateTrees(start,i-1);
            List<easy.TreeNode> rightTrees = generateTrees(i+1,end);
            for(easy.TreeNode lefttree : leftTrees){
                for(easy.TreeNode righttree : rightTrees){
                    easy.TreeNode curTree = new easy.TreeNode(i);
                    curTree.left=lefttree;
                    curTree.right=righttree;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }

}














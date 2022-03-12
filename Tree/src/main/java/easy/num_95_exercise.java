package easy;

import java.util.LinkedList;
import java.util.List;

public class num_95_exercise {
    /*
    * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
    * 可以按 任意顺序 返回答案。
    * */
    /*
    * 解题思路：
    *   在给定范围的情况下，创建一个集合，
    * 集合用来存放当前范围（start,end）可能
    * 产生的所有二叉搜索树，枚举范围内每个点，
    * 每次选中一个点当作根节点，然后分别递归
    * 生成根节点左右子树所有种类的集合
    *
    * */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0 ) {
            return new LinkedList<>();
        }
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> alltrees = new LinkedList<>();
        if(start > end ){
            alltrees.add(null);
            return alltrees;
        }
        for(int i = start ; i < end ; i++){
            List<TreeNode> lefttrees = generateTrees(start,i-1);
            List<TreeNode> righttrees = generateTrees(i+1,end);
            for(TreeNode lefttree : lefttrees) {
                for(TreeNode righttree : righttrees){
                    TreeNode curtree = new TreeNode(i);
                    curtree.left=lefttree;
                    curtree.right=righttree;
                    alltrees.add(curtree);
                }
            }
        }
        return  alltrees;
    }
}














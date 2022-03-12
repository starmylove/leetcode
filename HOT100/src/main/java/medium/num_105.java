package medium;

import easy.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class num_105 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder,  int pl, int pr, int il, int ir) {
        if(pl > pr || pl < 0 || pr >= preorder.length){
            return null;
        }
        if(pl == pr){
            return new TreeNode(preorder[pl]);
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int mid = map.get(preorder[pl]) , llen = 0  , rlen = 0  ;
        llen = mid - il ;
        rlen = ir - mid ;
        root.left = build(preorder,inorder,pl + 1,pl + llen  , il , mid - 1);
        root.right = build(preorder,inorder,pl + llen + 1,pl + llen + rlen,mid + 1 , mid + rlen);
        return root;
    }
}

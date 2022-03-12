package middle;

public class Offer_33 {
    public boolean verifyPostorder(int[] postorder) {
        return bfs(postorder,0,postorder.length-1);
    }
    public boolean bfs(int[] postorder , int l , int r){
        if(l >= r) {
            return true;
        }
        int val = postorder[r];
        int lr = l - 1 ;
        while(postorder[lr+1] < val){
            lr ++ ;
        }
        if(lr == r - 1 ) {
            return bfs(postorder,l,lr);
        }
        int rr = lr + 1 ;
        while(postorder[rr+1] > val ){
            rr ++ ;
        }
        if(rr != r - 1 ) {
            return false ;
        }
        return bfs(postorder,l,lr) && bfs(postorder,lr+1,rr);
    }
}

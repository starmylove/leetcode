package hard;

import org.junit.Test;

public class num_302 {
    public int minArea(char[][] image, int x, int y) {
        int left = findColumn(image, true, 0, y);
        int right = findColumn(image, false, y + 1, image[0].length - 1);
        int top = findRow(image, true, 0, x);
        int bottom = findRow(image, false, x + 1, image.length - 1);
        return (right - left) * (bottom - top);
    }
    public int findColumn(char[][] image, boolean whiteToBlack, int l, int r){
        int ans = whiteToBlack ? 0 : image[0].length;
        while (l <= r) {
            int mid = (r - l) / 2 + l, k = 0;
            while(k < image.length && image[k][mid] == '0') k ++;
            if(k < image.length == whiteToBlack){
                r = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int findRow(char[][] image, boolean whiteToBlack, int l, int r){
        int ans = whiteToBlack ? 0 : image.length;
        while (l <= r) {
            int mid = (r - l) / 2 + l, k = 0;
            while(k < image[0].length && image[mid][k] == '0') k ++;
            if(k < image[0].length == whiteToBlack){
                r = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(minArea(new char[][]{{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}}, 0, 2));
    }
}

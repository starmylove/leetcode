package easy;

public class num_492 {
    // 100 100
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        for (int i = w; i >= 1; i--) {
            if(area%i==0) {
                return new int[]{area/i,i};
            }
        }
        return null;
    }

    //巨慢
    public int[] constructRectangle1(int area) {
        int l , w ;
        int x = (int)Math.sqrt((double) area);
        double y = Math.sqrt(area);
        if(y-(double) (x)>0){
            for (int i = (int) Math.ceil(y); i <= area; i++) {
                double m = area / (double)i;
                if(m-Math.floor(m)==0) {
                    return new int[]{i,(int) m};
                }
            }
        }else {
            return new int[]{x,x};
        }
        return null;
    }
}

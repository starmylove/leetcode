package middle;

public class Offer_44 {
    public int findNthDigit(int n) {
        int l = 9 ,numLen = 1 , maxNum = 0 ;
        long bitSum = 0 ;
        while (n > bitSum + (long) l * numLen){
            maxNum += l ;
            bitSum += (long) l * numLen ;
            l *= 10 ;
            numLen += 1 ;
        }
        int resBits = (int) (n - bitSum);
        int x  = maxNum;
        if(resBits % numLen != 0){
            x += 1 ;
        }
        x += resBits / numLen ;
        String y = String.valueOf(x);
        int index = resBits % numLen == 0 ? y.length() - 1 : resBits % numLen - 1;
        return Integer.parseInt(y.substring(index,index+1));
    }
}
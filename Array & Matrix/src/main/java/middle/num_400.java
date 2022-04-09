package middle;

public class num_400 {
    public static int findNthDigit(int n) {
        long l = 1, r = 9, width = 1, len = 0;
        while(len + width * (r - l + 1) < n){
            len += width * (r - l + 1);
            l = r + 1;
            r = r * 10 + 9;
            width ++;
        }
        long index = n - len;
        long num = l - 1 + index / width + (index % width == 0 ? 0 : 1);
        String s = String.valueOf(num);
        return index % width == 0 ? s.charAt(s.length() - 1) - '0' : s.charAt((int)(index % width - 1)) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}

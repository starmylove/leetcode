package middle;

public class num_1109 {
    //1109. 航班预订统计
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] flight = bookings[i] ;
            for (int j = flight[0]; j <= flight[1]; j++) {
                ans[j]+=flight[2];
            }
        }
        return ans ;
    }
    //差分法
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] booking : bookings){
            ans[booking[0]-1] += booking[2];
            if(booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i-1];
        }
        return ans ;
    }

    }

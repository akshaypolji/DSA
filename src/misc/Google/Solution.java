package misc.Google;

import java.util.Arrays;

class Solution {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (b[0] - a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        boolean result = canAttendMeetings(intervals);
        System.out.println(result);
    }
}

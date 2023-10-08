package onboarding;

import java.util.List;

class Problem1 {

    /*
    숫자가 연속 되지 않는 경우 >> 예외 상황
     */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;



        return answer;
    }

    private int[] getMax(int left, int right) {
        if(right - left != 1) { return null; }
        int[] arr = {0, 1, 0, 1}; // left sum, mul , right sum, mul
        for(int i = 100; i >= 1; i/=10){
            int l = left/i;
            int r = right/i;
            arr[0] += l;
            arr[1] *= (l == 0) ? 1 : l;
            arr[2] += r;
            arr[3] *= (r == 0) ? 1 : r;
            left%=i;
            right%=i;
        }
        return arr;
    }


}
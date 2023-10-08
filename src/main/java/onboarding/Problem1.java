package onboarding;

import java.util.List;

class Problem1 {

    /*
    숫자가 연속 되지 않는 경우 >> 예외 상황
     */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 p = new Problem1();
        int[] left = p.getMax(pobi.get(0),pobi.get(1));
        int[] right = p.getMax(crong.get(0),crong.get(1));
        if(left == null || right == null) { return -1; }
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < 4; i++) {
            leftMax = Math.max(leftMax, left[i]);
            rightMax = Math.max(rightMax, right[i]);
        }
        if(leftMax == rightMax) { return 0; }
        else if(leftMax > rightMax) { return 1; }
        return 2;
    }

    public int[] getMax(int left, int right) {
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
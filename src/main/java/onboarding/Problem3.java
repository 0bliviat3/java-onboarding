package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Problem3 p = new Problem3();
        for(int i = 1; i <= number; i++) {
            answer += p.getClap(i);
        }

        return answer;
    }

    int getClap(int number) {
        int cnt = 0;
        for(int i = 1000; i >= 1; i/=10) {
            int now = number/i;
            if(now == 3 || now == 6 || now == 9) { cnt++; }
            number%=i;
        }
        return cnt;
    }
}

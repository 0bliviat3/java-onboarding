package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 50000; i >= 50; i/=2) {
            for(int j = 0; j < 2; j++) {
                int mod = money/i;
                answer.add(mod);
                money -= mod * i;
                i/=5;
            }
            i*=5;
        }

        answer.add(money%10);

        return answer;
    }
}

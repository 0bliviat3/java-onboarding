package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(char val : word.toCharArray()) {
            if(val >= 'A' && val <= 'Z') {
                sb.append((char)('Z' + 'A' - val));
            }else if(val >= 'a' && val <= 'z') {
                sb.append((char)('z' + 'a' - val));
            }else {
                sb.append(val);
            }
        }
        return sb.toString();
    }

}

package onboarding;

public class Problem2 {
    
    /*
    문자가 연속 되면 제거
     */

    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        int size = cryptogram.length();
        int top = 0;
        boolean flag = false;
        char[] stack = new char[size];
        stack[top] = cryptogram.charAt(0);
        for(int i = 1; i < size; i++) {
            char next = cryptogram.charAt(i);

            if(stack[top] != next) { // 같지 않다면
                if(flag) { // 직전에 같은 문자 였던 경우 삭제
                    top--;
                    flag = false;
                    i--; // 한번더 체크
                }else {
                    stack[++top] = next; // 삽입
                }
            }else { // 같은 경우 삽입 하지 않는다.
                flag = true; // 다른 경우에 지우기 위한 표시
            }
        }

        if(flag) { top--; }

        for(int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }


        return sb.toString();
    }



}

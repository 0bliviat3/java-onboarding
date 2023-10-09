package onboarding;

import java.util.*;

public class Problem6 {

    private HashMap<String,String> infoMap;
    private Set<String> emailSet;

    Problem6() {
        infoMap = new HashMap<>();
        emailSet = new TreeSet<>();
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 p = new Problem6();
        p.listSequence(forms);
        List<String> answer = new ArrayList<>(p.getEmailSet());
        return answer;
    }

    void listSequence(List<List<String>> forms) {
        for(List<String> list : forms) {
            setMap(list);
        }
    }

    private void setMap(List<String> info) {
        String nickName = info.get(1);
        String email = info.get(0);

        for(int i = 0; i < nickName.length() - 1; i++) {
            String key = nickName.substring(i, i + 2);
            infoChk(key, email);
        }
    }

    private void infoChk(String key, String val) {
        if (infoMap.containsKey(key)) {
            emailSet.add(val);
            emailSet.add(infoMap.get(key));
            return;
        }
        infoMap.put(key,val);
    }

    Set<String> getEmailSet() { return emailSet; }

}

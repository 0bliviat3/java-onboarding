package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    private HashMap<String, HashSet<String>> edges;
    private HashMap<String,Integer> recomendPoint;

    Problem7() {
        edges = new HashMap<>();
        recomendPoint = new HashMap<>();
    }

    void setEdges(List<List<String>> friends) {
        for(List<String> list : friends) {
            init(list.get(0),list.get(1));
        }
    }

    private void init(String a, String b) {
        containsName(a);
        containsName(b);
        edges.get(a).add(b);
        edges.get(b).add(a);
    }

    private void containsName(String name) {
        if(!edges.containsKey(name)) {
            edges.put(name,new HashSet<>());
        }
    }

    private void setRecomendPoint(List<String> visitors) {
        for(String key : edges.keySet()) {
            recomendPoint.put(key, 0);
        }
        for (String key : visitors) {
            recomendPoint.put(key, 1);
        }
    }

    void findFriend(String user,List<String> visitors) {
        setRecomendPoint(visitors);
        HashSet<String> friends = edges.get(user);
        for(String near : friends) {
            updatePoint(near);
        }
        deletePoint(friends,user);
    }

    private void updatePoint(String near) {
        HashSet<String> newFriends = edges.get(near);
        for(String name : newFriends) {
            recomendPoint.put(name,recomendPoint.get(name) + 10);
        }
    }

    private void deletePoint(HashSet<String> friends, String user) {
        recomendPoint.remove(user);
        for(String friend : friends) {
            recomendPoint.remove(friend);
        }
    }

    private List<String> sortPoint() {
        List<String> nameList = new ArrayList<>(recomendPoint.keySet());
        nameList.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return recomendPoint.get(t1) - recomendPoint.get(s);
            }
        });

        return nameList;
    }

    List<String> getAns() {
        List<String> nameList = sortPoint();
        List<String> ansList = new ArrayList<>();
        int size = Math.min(nameList.size(),5);
        for (int i = 0; i < size; i++) {
            ansList.add(nameList.get(i));
        }
        return ansList;
    }



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p = new Problem7();
        p.setEdges(friends);
        p.findFriend(user,visitors);
        List<String> answer = p.getAns();
        return answer;
    }
}


package number_1311;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<String, Integer> videoMap = new TreeMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visvited = new boolean[friends.length];
        visvited[id] = true;
        for (int f : friends[id]) {
            deque.add(f);
        }

        while (!deque.isEmpty() && level != 0) {
            int size = deque.size();
            level--;
            while (size-- > 0) {
                int friend = deque.pop();
                for (int fs : friends[friend]) {
                    if (!visvited[friend]) {
                        deque.add(friend);
                    }
                }

                if (level == 0) {
                    List<String> list = watchedVideos.get(friend);
                    for (String s : list) {
                        if (videoMap.containsKey(s)) {
                            videoMap.put(s, videoMap.get(s) + 1);
                        } else {
                            videoMap.put(s, 1);
                        }
                    }
                }

            }
        }

        List<String> res = new ArrayList<>();


        return null;



    }

    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("C"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));

        int[][] friends = {{1,2},{0, 3}, {0, 3}, {1, 2}};
        new Solution().watchedVideosByFriends(watchedVideos, friends, 0, 1);

    }
}

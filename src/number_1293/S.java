package number_1293;

import java.util.LinkedHashMap;
import java.util.Map;

public class S {
    public static void main(String[] args) {
        int limit = 5;
        Map<Integer, String> map = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > limit;
            }
        };
        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }
        String v = map.get(6);
        map.keySet().forEach(System.out::print);

    }
}

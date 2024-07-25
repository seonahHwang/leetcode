package Milla.Repeat.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private Map<String,List<Pair>> timeStore;
    public TimeMap() {
        timeStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeStore.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(timestamp,value));
    }

    public String get(String key, int timestamp) {
        List<Pair> values = timeStore.getOrDefault(key,new ArrayList<>());

        int l = 0;
        int r = values.size() - 1;
        String result = "";

        while (l <= r){
            int mid = (l+r)/2;
            if(values.get(mid).key <= timestamp){
                result = values.get(mid).value;
                l = mid + 1;
            }else r = mid - 1;
        }
        return result;
    }

    static class Pair{
        int key;
        String value;

        Pair(int k, String v){
            this.key = k;
            this.value = v;
        }

        int getKey(){
            return key;
        }

        String getValue(){
            return value;
        }
    }
}

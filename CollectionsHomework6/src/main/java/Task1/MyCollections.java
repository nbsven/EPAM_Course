package Task1;

import java.util.*;

public class MyCollections {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
        System.out.println(list);
        HashSet<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.clone();
        TreeMap<String, String> map1 = new TreeMap<>();
//        map1.put(null, null);
//        map1.clone();
//        System.out.println(map1);
        Vector<String> vector = new Vector<>();
        vector.add(null);
        System.out.println(vector);
//        TreeSet<String> set1 = new TreeSet<>();
//        set1.add(null);
//        System.out.println(set1);
    }
}

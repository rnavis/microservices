package com.rnavis.basics.brushup;

import java.util.*;

public class StringFries {

    public static void main(String args[]) {
        String[] strings = {"amry", "mary", "trap", "crap", "part", "grover", "overrg"};
        findAnagrams(strings);
    }
    static void findAnagrams(String[] strings) {
        Map<String, Set<String>>  map = new HashMap<>();
        for (String str: strings) {
            char[] array = new char[26];
            for (char c: str.toCharArray()) {
                array[c-'a'] = c;
            }
            String string = new String(array);
            if (map.get(string) == null) {
                Set<String> st = new HashSet<>();
                st.add(str);
                map.put(string, st);
            } else {
                map.get(string).add(str);
            }
        }
        System.out.println(map);
    }

}

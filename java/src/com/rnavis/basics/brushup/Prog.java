package com.rnavis.basics.brushup;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Prog {

    public static void main(String args[]) {

        java.util.Dictionary<String, Coupon> couponMap = new Hashtable<>();
        java.util.Dictionary<String, Coupon> couponMap2 = new Hashtable<>();
        List<java.util.Dictionary<String,Coupon>> coupons = new ArrayList<>();

        couponMap.put("c1", new Coupon("upc1", "1", "c1", 20,100));
        couponMap.put("c2", new Coupon("upc1", "1", "c2", 20,100));
        couponMap.put("c3", new Coupon("upc1", "1", "c3", 20,100));
        couponMap.put("c4", new Coupon("upc1", "1", "c4", 20,100));
        couponMap.put("c5", new Coupon("upc1", "1", "c5", 20,100));
        couponMap.put("c6", new Coupon("upc1", "1", "c6", 20,100));
        couponMap2.put("c7", new Coupon("upc1", "1", "c1", 20,100));
        couponMap2.put("c8", new Coupon("upc1", "1", "c2", 80,100));
        couponMap2.put("c9", new Coupon("upc1", "1", "c3", 20,100));
        coupons.add(couponMap);
        coupons.add(couponMap2);
        List<String> categories = Arrays.asList("c1", "c8");
        personalizeCoupon(coupons, categories);


    }

    public static Map<String, Coupon> personalizeCoupon(List<java.util.Dictionary<String,Coupon>> listofCoupons, List<String> categories) {
        List<java.util.Dictionary<String,Object>> filtered = new ArrayList<>();
        Map<String, Coupon> map = new HashMap<>();
        listofCoupons.stream().forEach(m ->map.putAll(Collections.list(m.keys()).stream().collect(Collectors.toMap(Function.identity(), m::get))));
        map.entrySet().removeIf(entry-> !categories.contains(entry.getKey()));
        map.forEach((k,v) -> v.code= null);
        TreeMap<String, Coupon> sorted = new TreeMap<String, Coupon>(new ValueComparator(map));
        sorted.putAll(map);
        return sorted;
    }
}

class ValueComparator implements Comparator<String> {

    private Map<String, Coupon> map;

    public ValueComparator(Map<String, Coupon> map) {
        this.map = map;
    }

    public int compare(String a, String b) {
        return map.get(a).couponAmt - (map.get(b).couponAmt)> 0 ? -1:1;
    }
}
class Coupon {
    String upc;
    String code;

    public Coupon(String upc, String code, String category, float price, float couponAmt) {
        this.upc = upc;
        this.code = code;
        this.category = category;
        this.price = price;
        this.couponAmt = couponAmt;
    }

    String category;;
    float price;
    float couponAmt;
}

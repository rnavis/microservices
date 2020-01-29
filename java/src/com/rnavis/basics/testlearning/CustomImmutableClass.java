package com.rnavis.basics.testlearning;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class CustomImmutableClass {
    private final String name;
    private final Map map;
    private final Date date;
    public CustomImmutableClass(final String name, final Map map, final Date date) {
        this.name = name;
        this.map = map;
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public Map getMap() {
        Map a= new HashMap();
        a.putAll(map);
        return a;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "CustomImmutableClass{" +
                "name='" + getName() + '\'' +
                ", map=" + getMap() +
                ", date=" + getDate().toString() +
                '}';
    }
}

class TestImmutableClass {
    public static void main(String args[]) {
        Map<String, String> m = new HashMap();
        m.put("t","ran");
        Date current = new Date();
        CustomImmutableClass immutableClass = new CustomImmutableClass("t",m,current);
        System.out.println(immutableClass.toString());
        immutableClass.getDate().setTime(1000);
        System.out.println(immutableClass.toString());


    }

}

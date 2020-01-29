package com.rnavis.basics.testlearning;

import java.util.Date;

public class ImmutableClass {


}

final class ImmutableEmployee {
    final int id;
    final String name;
    final Date inDate;

    ImmutableEmployee(final int id, final String name, final Date inDate) {
        this.id = id;
        this.name = name;
        this.inDate = new Date(inDate.getTime());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getInDate() {
        return new Date(inDate.getTime());
    }
}

package com.rnavis.basics.brushup;

public class Equality {
    public static void main(String args[]) {
        //primitives == true
        int i=10;int j=10;System.out.print("primitive int == ");System.out.println(i==j);
        long p=10;long q=10;System.out.print("primitive long == ");System.out.println(p==q);
        double c=10;double d=10;System.out.print("primitive double == ");System.out.println(c==d);
        short s1=10;short s2=10;System.out.print("primitive short == ");System.out.println(s1==s2);
        byte b1=10;byte b2=10;System.out.print("primitive byte == ");System.out.println(b1==b2);
        float f1=10;float f2=10;System.out.print("primitive float == ");System.out.println(f1==f2);
        //Enum
        Enum e1= Places.California;Enum e2 = Places.California;
        System.out.print("Enums == ");System.out.println(e1==e2);
        System.out.print("Enums .equals ");System.out.println(e1.equals(e2));
        //String
        String str1 = "abc";String str2="abc";System.out.print("String literals 'abc'=='abc' ");System.out.println(str1==str2);
        String str3 = "abc";String str4=new String("abc");System.out.print("String literals vs new String 'abc'==new String('abc') ");System.out.println(str3==str4);
        String str5 = new String("abc");String str6=new String("abc");System.out.print("new String vs new String new String('abc')==new String('abc') ");System.out.println(str5==str6);
        String str7 = new String("abc");String str8=new String("abc");str7.intern();str8.intern();System.out.print("new String vs new String new String('abc').intern()==new String('abc').intern() ");System.out.println(str7==str8);
        String str9 = new String("abc");String str10=new String("abc");System.out.print("new String vs new String new String('abc').equas(new String('abc')) ");System.out.println(str9.equals(str10));

        //All other objects
        Employer em1 = new Employer(1,"test");Employer em2 = new Employer(1,"test");
        System.out.print("em1 == em2 ?");System.out.println(em1==em2);
        System.out.print("em1.equals(em2) ?");System.out.println(em1.equals(em2)); //coz uses object equals which is ==!!
        User us1 = new User(1,100,"test");User us2 = new User(1,100,"test");
        System.out.print("us1 == us2 ?");System.out.println(us1== us2);
        System.out.print("us1.equals(us2) ?");System.out.println(us1.equals(us2)); //coz uses overriden equals which is does deep check
        Employer em3 = new Employer(1,"test"); Employer em4 = em3;
        System.out.print("em3 == em4 ?");System.out.println(em3==em4);
        System.out.print("em3.equals(em4) ?");System.out.println(em4.equals(em3)); //coz uses object equals which is ==!!
    }


}

enum Places {
    California,
    NewYork,
    Pasadena
}
class User {
    int id;
    Integer itin;
    String name;

    public User(int id, Integer itin, String name) {
        this.id = id;
        this.name = name;
        this.itin = itin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!itin.equals(user.itin)) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + itin.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
class Employer {
    int id;

    public Employer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String name;
}

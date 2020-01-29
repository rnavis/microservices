package com.rnavis.basics.testlearning;

import java.util.*;

/**
 * Created by sivanr on 8/8/2018.
 */


class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id == employee.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id*31;
    }
}
public class triap {

    public static void main(String args[]) {
        triap tr = new triap();
       // tr.fibo(150);
        //tr.isArmstrong(1633);

        Employee e1 = new Employee(2,"qrahul1");
        Employee e2 = new Employee(4,"orahul2");
        Employee e3 = new Employee(15,"frahul3");
        Employee e4 = new Employee(18,"arahul4");
        Employee e5 = new Employee(5,"mrahul1");
        Employee e6 = new Employee(1,"xrahul2");
        List employeeList = Arrays.asList(e1,e2,e3,e4,e5,e6);
        System.out.println("Before...");
        employeeList.forEach(emp -> System.out.println(emp.toString()));
        employeeList.sort(new Comparator<Employee>() {
           public int compare(Employee o1, Employee o2) {
               return o1.getId() - o2.getId();
            }
        });
        System.out.println("After...");
        employeeList.forEach(emp -> System.out.println(emp.toString()));

        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("b", e1);
        employeeMap.put("d", e2);
        employeeMap.put("j", e3);
        employeeMap.put("m", e4);
        employeeMap.put("e", e5);
        employeeMap.put("a", e6);

        //sort map by key
/*        TreeMap<String, Employee> sortedByKey= new TreeMap<String, Employee>(employeeMap);
        System.out.println("Sorted by value map key...");
        for(Map.Entry e: sortedByKey.entrySet()) {
            System.out.println(e.getKey() + " ==> "+ e.getValue().toString());
        }*/
        //sort map by value==> put into linked hashmap
        Set<Map.Entry<String, Employee>> listOfEntries = employeeMap.entrySet();

        List<Map.Entry<String,Employee>> list = new ArrayList<Map.Entry<String, Employee>>(listOfEntries);
        Collections.sort(list, new Comparator<Map.Entry<String, Employee>>() {

            public int compare(Map.Entry<String, Employee> e1, Map.Entry<String, Employee> e2) {
                return e1.getValue().getName().compareTo(e2.getValue().getName());
            }
        });

        LinkedHashMap<String, Employee> sortedByValue = new LinkedHashMap<>();

        for (Map.Entry<String, Employee> sortedEntry: list) {
            sortedByValue.put(sortedEntry.getKey(),sortedEntry.getValue());
        }
        System.out.println("Sorted by map value name...");
        for(Map.Entry e: sortedByValue.entrySet()) {
            System.out.println(e.getKey() + " ==> "+ e.getValue().toString());
        }

    }
    public void fibo(int limit) {

        int i = 1;
        int temp =0;
        int sum =0;
        while(sum<=limit) {
            sum = i+temp;
            temp = i;
            i = sum;
            System.out.print(" > "+ sum);
        }
    }

    public void isArmstrong(int input) {
        int digitCounter = 0;
        int sizer = input;
        int n = input;
        while(sizer!=0) {
            digitCounter++;
            sizer = sizer/10;
        }
        System.out.println(digitCounter);
        int sum =0;
        System.out.println("n "+n);
        while (n !=0) {
            sum += (int)Math.pow(n%10,digitCounter);
            n = n/10;
        }
        System.out.println("Sum ... "+ sum);
        if (sum== input) {
            System.out.println("Armstrong number");
        } else {
            System.out.println("Not Armstrong");
        }

    }
}


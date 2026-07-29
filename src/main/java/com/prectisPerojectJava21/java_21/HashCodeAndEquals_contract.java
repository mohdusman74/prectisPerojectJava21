package com.prectisPerojectJava21.java_21;

public class HashCodeAndEquals_contract {
    public static void main(String[] args) {
        Employee emp=new Employee(1,"usman");
        Employee emp2=new Employee(2,"usman");
        Employee emp3=new Employee(3, "usman");

        System.out.println(emp.hashCode());
        System.out.println(emp2.hashCode());
        System.out.println(emp3.hashCode());
        System.out.println(emp.equals(emp2));
        System.out.println(emp.equals(emp3));

    }
}

class Employee{
    int id;
    String name;

    Employee(int id, String name){
        this.id = id;
        this.name=name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee)obj;
        return name.equals(e.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public String toString() {
        return name.toString();
    }
}

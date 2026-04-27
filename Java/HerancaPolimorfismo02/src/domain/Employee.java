package domain;

public sealed abstract class Employee permits Manager, Salesman {
    protected String name;
    protected String code;
    protected String address;
    protected int age;
    protected double salary;

    public Employee(String name, String code, String address, int age, double salary) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double getFullSalary();
}

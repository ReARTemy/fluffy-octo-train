package org.donstu.domain;

public class Master {

    private String name;
    private int experience;
    private int salary;

    public Master(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

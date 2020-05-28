package org.wikipedia.learn;

public class Person {
    //id, first name, last name, age <- zadeklaruj
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Job job;

    //gettery
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public Job getJob() {
        return job;
    }
    //settery
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*konstruktor bez argumentowy
        public Person() {
        }
        */
//    konstruktor wieloargumentowy
    public Person(int id, String firstName, String lastName, int age, Job job) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.job = job;
    }


}

package com.example.fitelevate;

public class dbUser {

    String name;
    int height;
    int age;
    int weight;
    String gender;
    Double mobile;
    String address;

    dbUser(){}

    public dbUser(String name, int height, int age, int weight, String gender, Double mobile, String address) {
        this.name = name;
        this.height = height;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.mobile = mobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getMobile() {
        return mobile;
    }

    public void setMobile(Double mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

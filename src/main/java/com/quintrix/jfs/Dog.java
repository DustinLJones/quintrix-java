package com.quintrix.jfs;

public class Dog {
  private String breed;
  private int age;
  private String color;

  public static int NUM_OF_LEGS = 4;

  // Constructors
  public Dog() {

  }

  public Dog(String breed, int age, String color) {
    super();
    this.breed = breed;
    this.age = age;
    this.color = color;
  }

  // Getters & Setters
  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  // Methods
  public void barking() {
    System.out.println("Whoof Whoof");
  }

  @Override
  public String toString() {
    return "Dog [breed=" + breed + ", age=" + age + ", color=" + color + "]";
  }
}

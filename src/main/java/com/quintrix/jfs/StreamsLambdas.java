package com.quintrix.jfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLambdas {

  public static void main(String[] args) {

    // Primitive data example
    // ----------------------------------------------
    // Create master integer list
    List<Integer> intSet = Stream.iterate(1, n -> n + 1).limit(1000).collect(Collectors.toList());

    // Use lambdas and streams for numerical fun
    List<Integer> divisibleBySeventyNine =
        intSet.stream().filter(d -> d % 79 == 0).collect(Collectors.toList());
    int summation = intSet.stream().filter(d -> d % 23 == 0).mapToInt(Integer::intValue).sum();

    System.out.println("Fun with first 1000 integers using lambdas and streams!");
    System.out.println("List of numbers divisible by 79:" + divisibleBySeventyNine);
    System.out.println("Count of numbers divisible by 79: " + divisibleBySeventyNine.size());
    System.out.println("Sum of numbers divisible by 23: " + summation);
    System.out.println();

    // Object example
    // ----------------------------------------------
    // Create master list of Dogs
    List<Dog> dogsList = new ArrayList<>(Arrays.asList((new Dog("Chihuahua", 3, "Brown")),
        (new Dog("Husky", 3, "White")), (new Dog("Pit Bull", 5, "Brown")),
        (new Dog("Husky", 1, "Black")), (new Dog("Husky", 4, "Brown")),
        (new Dog("Pug", 7, "Black")), (new Dog("Corgi", 1, "Brown"))));

    // Use lambdas and streams for object fun
    List<Dog> olderDogs =
        dogsList.stream().filter(a -> a.getAge() >= 4).collect(Collectors.toList());
    List<Dog> allHusky =
        dogsList.stream().filter(s -> s.getBreed() == "Husky").collect(Collectors.toList());

    int youngerDogs = dogsList.size() - olderDogs.size();

    System.out.println("Fun with dogs using lambdas and streams!");
    System.out.println("Number of younger dogs (less than 4 years of age): " + youngerDogs);
    System.out.println("All Huskys in list: " + allHusky);

    System.out.println();
  }

}

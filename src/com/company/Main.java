package com.company;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.util.stream.Collectors;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> listOfIntegers = Arrays.asList(14,51,5,1,5,12,5,6,7,23,46,78,34);

        List<Integer> doubleInts;

        List<String> strings = Arrays.asList("23","35","1","3","16","1","16");

        List<Character> listOfCharacters = Arrays.asList('f','d','g','f','a');



//------------------------task 1--------------------------------------
        doubleInts = listOfIntegers.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println("Int * 2: "+ doubleInts);


//------------------------task 2--------------------------------------

        String reverseString = "Hello Java";
        reverseString = stringReverse(reverseString);
        System.out.println("String after reverse: "+ reverseString);


//------------------------task 3---------------------------------------

        Integer result = (Integer) getNthElement(listOfIntegers,13);
        System.out.println("The Nth elements is: " + result);


//------------------------task 4----------------------------------------

        listOfIntegers =  strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("List of integers from string "+listOfIntegers);


//------------------------task 5--------------------------------------
        Integer max = listOfIntegers.stream()           //the list was overwritten in previous task
                .mapToInt(v -> v)
                .max().getAsInt();

        Integer min = listOfIntegers.stream()
                .mapToInt(v -> v)
                .min().getAsInt();

        System.out.println("Max: " + max +" Min: " + min);


//------------------------task 6--------------------------------------

        Character minAsci = listOfCharacters.stream()
                .min(Character::compareTo).get();

        Character maxAsci = listOfCharacters.stream()
                .max(Character::compareTo).get();

        System.out.println("Min char: " + minAsci + " Max Char: " + maxAsci);


//------------------------task 7--------------------------------------

        listOfIntegers = listOfIntegers.stream().distinct().collect(Collectors.toList());

      //listOfIntegers = new ArrayList<> (listOfIntegers.stream().collect(Collectors.toSet())); //second method

        System.out.println("Distinct values" + listOfIntegers);


//------------------------task 8--------------------------------------

        String filePath = "C:\\Users\\DSprinceac\\IdeaProjects\\StreamApiTask\\src\\com\\company\\stream_values.txt";
        Stream<String> streamFromFile = Files.lines(Paths.get(filePath));
        streamFromFile.forEach(System.out::println);
    }



   public static <T> Object getNthElement(List<T> list, int nElement){
       T object;

       if(nElement > list.size()) throw new IllegalArgumentException();

        if(nElement == 0){
             object = list.get(0);
        }
        else object = list.stream().skip(nElement-1).findFirst().get();

        return object;
   }

   public static String stringReverse(String s){
       List<String> list1 = Collections.singletonList(s);
       List<String> list2= list1.stream().map(s1-> new StringBuilder(s).reverse().toString())
               .collect(Collectors.toList());

        return list2.get(0);
   }
}

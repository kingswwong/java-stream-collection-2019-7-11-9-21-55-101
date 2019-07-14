package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return Stream.iterate(leftBorder > rightBorder ? rightBorder : leftBorder, n -> n + 1).limit(Math.abs(rightBorder - leftBorder) + 1).filter(i -> i % 2 == 0).reduce(0, (a, b) -> a + b);

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return Stream.iterate(leftBorder > rightBorder ? rightBorder : leftBorder, n -> n + 1).limit(Math.abs(rightBorder - leftBorder) + 1).filter(i -> i % 2 != 0).reduce(0, (a, b) -> a + b);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0, (re, cur) -> re + cur * 3 + 2);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map((n) -> {
            n = n % 2 == 0 ? n : n * 3 + 2;
            return n;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 != 0).reduce(0, (a, b) -> a + b * 3 + 5);
    }

//    public double getMedianOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
//    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 == 0).reduce(0, (a, b) -> a + b) / 2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
    }

//    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
//        throw new NotImplementedException();
//    }

//    public List<Integer> getProcessedList(List<Integer> arrayList) {
//        throw new NotImplementedException();
//    }
}

package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return left < right ? IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList()) : IntStream.rangeClosed(right, left).boxed().sorted(Comparator.comparing(Integer::intValue).reversed() ).collect(Collectors.toList());

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left,right).stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream( array ).boxed().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        List<Integer> array2List = Arrays.stream(array).boxed().collect(Collectors.toList());
        return array2List.get(array2List.size() - 1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondArray2IntegerList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray).boxed().filter(n -> secondArray2IntegerList.contains(n)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArray2List = Arrays.stream(firstArray).collect(Collectors.toList());
        Stream secondArray2Stream = Arrays.stream(secondArray);
        secondArray2Stream.forEach( n -> {
            if(firstArray2List.indexOf(n) == -1){
                firstArray2List.add((Integer) n);
            }
        });
        return firstArray2List;
    }
}

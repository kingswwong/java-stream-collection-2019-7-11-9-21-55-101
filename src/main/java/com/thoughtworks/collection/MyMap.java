package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map((n) -> {
            n = n * 3;
            return n;
        }).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map((n) -> {
            int temp = Integer.valueOf(n) + 96;
            return (char)temp + "";
        }).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map( n -> {
            if(n <= 26){
                return (char)(n + 96) + "";
            }else{
                if(n % 26 == 0){
                    return (char)(n / 26 + 95) + "z";
                }else{
                    return (char)(n / 26 + 96) + "" + (char) (n % 26 + 96);
                }
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}

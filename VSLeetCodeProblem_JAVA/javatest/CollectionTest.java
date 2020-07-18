package javatest;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {

    public static void main(String[] args) {
        
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        List<String> list = new ArrayList<>();

        Map<String,Integer> coMap = new ConcurrentHashMap<>();
    }
}
package xyz.applebox.java.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class CollectionExample {

    /**
     * JEP 269: Convenience Factory Methods for Collections
     * Release 9
     * 정적 팩토리 메서드를 이용하여 편리하게 불변 컬랙션을 생성할 수 있습니다.
     */
    @Test
    void jep269(){
        List<String> immutableList = List.of("apple", "banana", "melon", "watermelon");
        System.out.println(immutableList);

        Set<Integer> immutableSet = Set.of(8, 10, 88);
        System.out.println(immutableSet);

        Map<String, Integer> immutableMap = Map.of("coco", 28, "lily", 34);
        System.out.println(immutableMap);

        Map<String, Integer> immutableMap2 = Map.ofEntries(Map.entry("coco", 28), Map.entry("lily", 34));
        System.out.println(immutableMap2);
    }

    /**
     * Java 8 이전에서 불변 컬랙션 만들던 방법
     */
    @Test
    void immutableCollectionTest() {
        List<String> mutableList = Arrays.asList("apple", "banana");   // 사이즈가 고정된 List 만들기
        mutableList.set(0, "melon");   // 수정은 가능
//        immutableList2.add("melon"); // 추가는 불가능
//        mutableList2.remove(1);       // 요소 제거도 불가능

        List<String> immutableList = Collections.unmodifiableList(Arrays.asList("apple", "banana"));
//        immutableList.set(0, "melon");   // 수정, 추가, 삭제 모두 불가능
//        immutableList.add("melon");
//        immutableList.remove(1);

        System.out.println(mutableList);
        System.out.println(immutableList);

        Set<Integer> immutableSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 10, 5)));
        Set<Integer> immutableSet2 = Collections.unmodifiableSet(Stream.of(1, 10, 5, 1).collect(Collectors.toSet()));
        System.out.println(immutableSet);
        System.out.println(immutableSet2);
    }

}
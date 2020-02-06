package my.mins.jmt.app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b");

        Optional<String> filteredData = strList.stream().filter(str -> "a".equals(str)).findAny();
        Optional<String> noData = strList.stream().filter(str -> "c".equals(str)).findAny();


        System.out.println("========== isPresent, get ==========");
        if (noData.isPresent()) {
            System.out.println(noData.get());
        } else {
            System.out.println("필터링된 데이터가 없습니다.");
        }
        if (filteredData.isPresent()) {
            System.out.println(filteredData.get());
        } else {
            System.out.println("필터링된 데이터가 없습니다.");
        }



        System.out.println("\n========== orElse ==========");
        System.out.println(noData.orElse("필터링된 데이터가 없습니다."));
        System.out.println(filteredData.orElse("필터링된 데이터가 없습니다."));



        System.out.println("\n========== ifPresent ==========");
        noData.ifPresent(System.out::println);
        filteredData.ifPresent(System.out::println);



        System.out.println("\n========== ifPresentOrElse ==========");
        noData.ifPresentOrElse(System.out::println, () -> {
            System.out.print("필터링된 데이터가 없어 별도로 다른 Thread를 실행합니다. 비동기. ");
            System.out.println("필터링된 데이터가 없습니다.");
        });
        filteredData.ifPresentOrElse(System.out::println, () -> {
            System.out.print("필터링된 데이터가 없어 별도로 다른 Thread를 실행합니다. 비동기. ");
            System.out.println("필터링된 데이터가 없습니다.");
        });



        System.out.println("\n========== orElseThrow ==========");
        try {
            System.out.println(noData.orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(filteredData.orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("\n========== orElseThrow(Supplier) ==========");
        try {
            System.out.println(noData.orElseThrow(Exception::new));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(filteredData.orElseThrow(Exception::new));
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("\n========== or(Supplier) ==========");
        System.out.println(noData.or(() -> Optional.of("test")).get());
        System.out.println(filteredData.or(() -> Optional.of("test")).get());
    }
}

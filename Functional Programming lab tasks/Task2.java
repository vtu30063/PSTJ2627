import java.util.*;
import java.util.stream.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            data.add(sc.next() + " " + sc.nextDouble());
        }

        data.stream()
            .map(s -> s.split(" "))
            .filter(a -> Double.parseDouble(a[1]) > 50)
            .collect(Collectors.groupingBy(
                a -> a[0],
                Collectors.averagingDouble(
                    a -> Double.parseDouble(a[1])
                )
            ))
            .entrySet()
            .stream()
            .sorted(
                Map.Entry.<String, Double>
                comparingByValue()
                .reversed()
            )
            .forEach(
                e -> System.out.println(
                    e.getKey() + " " + e.getValue()
                )
            );

        sc.close();
    }
}
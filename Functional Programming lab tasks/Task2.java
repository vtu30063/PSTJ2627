import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> sensors = new ArrayList<>();
        List<Double> temps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sensors.add(sc.next());
            temps.add(sc.nextDouble());
        }

        Map<String, Double> result = IntStream.range(0, n)
                .filter(i -> temps.get(i) > 50)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(
                        sensors.get(i), temps.get(i)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                ));

        result.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        sc.close();
    }
}
//output:
60
80
70
90

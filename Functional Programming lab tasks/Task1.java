import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        List<Integer> updatedSalaries = salaries.stream()
                .map(salary -> salary * 110 / 100)
                .collect(Collectors.toList());

        updatedSalaries.forEach(salary -> System.out.print(salary + " "));
    }
}
//output:5
1000
2000
3000
4000
5000
1100 2200 3300 4400 5500

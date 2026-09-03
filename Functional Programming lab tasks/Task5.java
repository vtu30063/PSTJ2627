import java.util.*;
import java.util.stream.*;

public class Task5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double balance = IntStream.range(0, n)
                .mapToObj(i -> sc.nextLine().split(" "))
                .mapToDouble(a -> 
                    a[0].equals("Deposit")
                    ? Double.parseDouble(a[1])
                    : -Double.parseDouble(a[1])
                )
                .sum();

        System.out.println((int) balance);

        sc.close();
    }
}
// input
3
Deposit 5000
Withdraw 2000
Deposit 1000
// output
  4000  

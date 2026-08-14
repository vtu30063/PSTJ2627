
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int current = sc.nextInt();
        int max = current;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();

            current = Math.max(value, current + value);
            max = Math.max(max, current);
        }

        System.out.println(max);

        sc.close();
    }
}
   //input:8
   
   -2
   -3
   4
   -1
   -2
   1
   5
   -3
//output: 7

import java.util.*;
import java.util.stream.*;

public class Task10{

    static boolean validate(String username, String password) {
        return username.length() >= 3 &&
               username.length() <= 20 &&
               password.length() >= 6 &&
               password.length() <= 20 &&
               username.equals("admin") &&
               password.equals("admin123");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        IntStream.range(0, n)
                .mapToObj(i -> new String[]{
                        sc.next(),
                        sc.next()
                })
                .map(a -> validate(a[0], a[1]))
                .forEach(result ->
                        System.out.println(result ? "SUCCESS" : "FAILURE")
                );

        sc.close();
    }
}
//input
3
admin admin123
ab 123
user pass
//output
SUCCESS
FAILURE
FAILURE    

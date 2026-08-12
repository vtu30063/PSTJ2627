import java.util.*;

public class Task3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = Arrays.stream(nums).collect(
            () -> new int[]{0, Integer.MIN_VALUE},
            (a, x) -> {
                a[0] = Math.max(x, a[0] + x);
                a[1] = Math.max(a[1], a[0]);
            },
            (a, b) -> {
                a[0] = Math.max(a[0], b[0]);
                a[1] = Math.max(a[1], b[1]);
            }
        );

        System.out.println(result[1]);

        sc.close();
    }
}
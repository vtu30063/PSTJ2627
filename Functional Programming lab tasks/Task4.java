import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().trim();
        String pattern = sc.nextLine().trim();

        int[] lps = new int[pattern.length()];

        int j = 0;

        // Create LPS array
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        // KMP search
        StringBuilder result = new StringBuilder();

        int i = 0;
        j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                result.append(i - j).append(" ");
                j = lps[j - 1];
            } 
            else if (i < text.length() &&
                     text.charAt(i) != pattern.charAt(j)) {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        System.out.println(result.toString().trim());

        sc.close();
    }
}
// Input
AABAACAADAABAABA
AABA
// Output
0 9 12

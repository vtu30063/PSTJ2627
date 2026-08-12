import java.util.Arrays;

class Task1 {
    public static void main(String[] args) {

        int[] li = {1000, 2000, 3000, 4000, 5000};

        int[] newSalaries = Arrays.stream(li)
                .map(salary -> salary + (salary * 10 / 100))
                .toArray();

        System.out.println(Arrays.toString(newSalaries));
    }
}
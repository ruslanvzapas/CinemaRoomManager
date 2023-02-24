import java.util.Scanner;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt(); // reading a length
        int[] array = new int[len];  // creating an array with the specified length

        for (int i = 0; i < len; i++) {
            array[i] = 10 + i; // read the next number of the array
        }

        System.out.println(Arrays.toString(array));

    }
}
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int arraysCount = scanner.nextInt();
        int[] array = new int[arraysCount];
        //ORIGINAL ARRAY
        for (int i = 0; i < arraysCount; i++) {
            array[i] = scanner.nextInt();
        }

        int last = array[arraysCount - 1];
        System.arraycopy(array, 0, array, 1, --arraysCount);
        array[0] = last;
        System.out.println(Arrays.toString(array)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
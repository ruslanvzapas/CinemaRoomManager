import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int countArray = scanner.nextInt();
        int[] array = new int[countArray];
        int sumArray = 0;
        for (int i = 0; i < countArray; i++) {
            array[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        for (int i = 0; i < countArray; i++) {
            if (array[i] > a) {
                sumArray += array[i];
            }
        }
        System.out.println(sumArray);
    }
}

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        for (int i = 1; i <= 4; i++) {
            int a = scanner.nextInt();
            --a;
            System.out.print(a + " ");
        }
    }
}
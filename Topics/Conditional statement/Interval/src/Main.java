import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int i = scanner.nextInt();
        if (i > -15 && i <= 12 || i > 14 && i < 17 || i >= 19) {
            System.out.println("True"); }
            else System.out.println("False");
    }
}
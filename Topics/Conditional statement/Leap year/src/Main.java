import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int i = scanner.nextInt();
        if (i >= 1900 && i <= 3000) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                System.out.println("Leap");
            } else System.out.println("Regular");
        } else System.out.println("eror");
    }
}
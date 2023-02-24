import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if(a == 0) {
                break;
            }
            if (a % 2 != 0) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
        }
    }
}
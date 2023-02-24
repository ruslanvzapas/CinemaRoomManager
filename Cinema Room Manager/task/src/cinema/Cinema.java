package cinema;

import java.util.Scanner;

public class Cinema {

    public static int ticketsCount = 0;
    public static int ticketPrice = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        char[][] seating = new char[rows + 1][seats + 1];
        createSeating(seating, seats);

        int seatsCount = rows * seats;
        final int firstPrice = 10;
        final int secondPrice = 8;
        int firstHalf = rows / 2;
        int secondHalf = rows - firstHalf;
        int firstSeats = firstHalf * seats;
        int secondSeats = secondHalf * seats;

        int totalIncome;
        if (seatsCount <= 60) {
            totalIncome = seatsCount * firstPrice;
        } else {
            totalIncome = firstSeats * firstPrice + secondSeats * secondPrice;
        }

        printMenu();
        int menuItems = sc.nextInt();



        while (menuItems != 0) {
            switch (menuItems) {
                case 1 -> {
                    printSeating(seating, seats);
                    printMenu();
                    menuItems = sc.nextInt();
                }
                case 2 -> {
                    input:
                    {
                        System.out.println();
                        System.out.println("Enter a row number: ");
                        int rowNumber = sc.nextInt();
                        System.out.println("Enter a seat number in that row: ");
                        int seatsNumber = sc.nextInt();
                        if (rowNumber > rows || seatsNumber > seats) {
                            System.out.println("Wrong input!");
                            break input;
                        } else if (seating[rowNumber][seatsNumber] == 'B') {
                            System.out.println("That ticket has already been purchased!");
                            break input;
                        } else {
                            buyTickets(seating, rows, seatsCount, seats, rowNumber, seatsNumber);
                        }
                        printMenu();
                        menuItems = sc.nextInt();
                    }
                }
                case 3 -> {
                    statistics(seatsCount, totalIncome);
                    printMenu();
                    menuItems = sc.nextInt();
                }
                default -> {
                }
            }
        }

    }

    public static void createSeating(char[][] seating, int seats) {
        int numRows = '1';
        int numSeats = '1';
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j <= seats; j++)
                if (i == 0 && j != 0) {
                    char val = (char) numSeats++;
                    seating[i][j] = val;
                } else if (j == 0 && i != 0) {
                    char val = (char) numRows++;
                    seating[i][j] = val;
                } else {
                    seating[0][0] = ' ';
                    seating[i][j] = 'S';
                }
        }
    }

    public static void printSeating(char[][] seating, int seats) {

        System.out.println("Cinema:");
        for (char[] chars : seating) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static void buyTickets(char[][] seating, int rows, int seatsCount, int seats, int rowNumber, int seatsNumber) {

        int ticketsPrice;
        int firstPrice = 10;
        int secondPrice = 8;
        int firstHalf = rows / 2;

        if (seating[rowNumber][seatsNumber] == 'B') {
            System.out.println("That ticket has already been purchased!");

        } else if (rowNumber <= rows && seatsNumber <= seats) {

            if (seatsCount <= 60) {
                ticketsPrice = firstPrice;
            } else {
                if (rowNumber <= firstHalf) {
                    ticketsPrice = firstPrice;
                } else ticketsPrice = secondPrice;
            }

            for (int i = 0; i < seating.length; i++) {
                for (int j = 0; j <= seats; j++) {
                    if (i == rowNumber && j == seatsNumber) seating[i][j] = 'B';
                }
            }
            System.out.println("Ticket price: $" + ticketsPrice);
            ticketsCount++;
            ticketPrice += ticketsPrice;
        } else {
            System.out.println("Wrong input!");
        }

    }

    public static void printMenu() {
        System.out.println();
        System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");
    }

    public static void statistics(int seatsCount, int totalIncome) {
        float percent = (float) ticketsCount / seatsCount * 100;
        char p = '%';
        System.out.printf("Number of purchased tickets: %d%n", ticketsCount);
        System.out.printf("Percentage: %3.2f%c%n", percent, p);
        System.out.printf("Current income: $%d%n", ticketPrice);
        System.out.printf("Total income: $%d%n", totalIncome);
    }

}

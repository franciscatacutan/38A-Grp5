import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int PaymentType = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payment payment = new Payment();

        // Array to store bookings
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Integer> availableSeats = new ArrayList<Integer>();

        int totalTicket = 0;

        // Initialize available seats
        for (int i = 1; i <= 20; i++) {
            availableSeats.add(i);
        }

        while (true) {
            System.out.println("Enter details for booking:");

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter movie: ");
            String movie = scanner.nextLine();

            int numOfTickets;
            while (true) {
                // enters the number of tickets the person wants to buy
                System.out.print("Enter number of tickets (max 5 tickets): ");
                numOfTickets = Integer.parseInt(scanner.nextLine());

                if (numOfTickets <= 5) {
                    totalTicket += numOfTickets;

                    for (int j = 1; j < numOfTickets; j++) {
                        int seatNumber;
                        while (true) {
                            System.out.print("Enter seat number: ");
                            seatNumber = scanner.nextInt();
                            // consume newline left-over
                            scanner.nextLine();

                            if (availableSeats.contains(seatNumber)) {
                                // remove this seat from available seats
                                availableSeats.remove(Integer.valueOf(seatNumber));
                                break;
                            } else {
                                System.out
                                        .println("This seat is already booked. Please enter a different seat number.");
                            }
                        }

                        people.add(new Person(name, movie, seatNumber));
                    }
                    break;
                } else {
                    System.out.println("Invalid number of tickets. Can only purchase a maximum of 5 tickets!");
                }
            }

            int seatNumber;
            while (true) {
                System.out.print("Enter seat number: ");
                seatNumber = scanner.nextInt();
                // consume newline left-over
                scanner.nextLine();

                if (availableSeats.contains(seatNumber)) {
                    // remove this seat from available seats
                    availableSeats.remove(Integer.valueOf(seatNumber));
                    break;
                } else {
                    System.out.println("This seat is already booked. Please enter a different seat number.");
                }
            }

            people.add(new Person(name, movie, seatNumber));

            System.out.print("Do you want to book another Movie? (yes/no): ");
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {
                System.out.print("Proceeding with payment...");

                // Display all bookings
                for (Person person : people) {
                    person.display();
                }

                System.out.println("Total Amount is " + payment.computeAmount(totalTicket));

                System.out.print("Enter payment method <cash / digital>: ");
                String paymentType = scanner.nextLine();

                if (payment.paymentMethod(paymentType) == "cash") {
                    System.out.print("Please pay/enter exact amount: ");
                    int paymentCash = scanner.nextInt();

                    while (paymentCash < payment.computeAmount(totalTicket)) {
                        if (paymentCash < payment.computeAmount(totalTicket)) {
                            System.out.println("Invalid amount.");
                        } else {
                            System.out.println("You paid: " + paymentCash);
                        }
                        break;
                    }
                } else {
                    System.out.print("Enter desired amount: ");
                    int paymentDigital = scanner.nextInt();
                    
                    if (paymentDigital > payment.computeAmount(totalTicket)) {
                        paymentDigital -= payment.computeAmount(totalTicket);
                        int change = paymentDigital;
                        System.out.println("Your change is: " + change);
                    }
                }
                break;
            }
        }
        scanner.close();
    }
}
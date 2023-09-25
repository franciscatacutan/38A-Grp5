import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Payment payment = new Payment();
        ArrayList<Person> people = new ArrayList<Person>(); // Array to store bookings
        ArrayList<Integer> availableSeats = new ArrayList<Integer>();

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
                System.out.print("Enter number of tickets (max 5 tickets): "); // enters the number of tickets the
                                                                               // person wants to buy
                // numOfTickets = scanner.nextInt();
                numOfTickets = Integer.parseInt(scanner.nextLine());

                if (numOfTickets <= 5) {
                    for (int j = 1; j < numOfTickets; j++) {
                        int seatNumber;
                        while (true) {
                            System.out.print("Enter seat number: ");
                            seatNumber = scanner.nextInt();
                            scanner.nextLine(); // consume newline left-over

                            if (availableSeats.contains(seatNumber)) {
                                availableSeats.remove(Integer.valueOf(seatNumber)); // remove this seat from available
                                                                                    // seats
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
                scanner.nextLine(); // consume newline left-over

                if (availableSeats.contains(seatNumber)) {
                    availableSeats.remove(Integer.valueOf(seatNumber)); // remove this seat from available seats
                    break;
                } else {
                    System.out.println("This seat is already booked. Please enter a different seat number.");
                }
            }

            people.add(new Person(name, movie, seatNumber));

            System.out.print("Do you want to book another Movie? (yes/no): ");
            String response = scanner.nextLine();

            if (!response.equalsIgnoreCase("yes")) {

                // Display all bookings
                for (Person person : people) {
                    person.display();
                }

                System.out.println("Total Amount is " + payment.computeAmount(numOfTickets));

                break;
            }

        }

        scanner.close();
    }
}

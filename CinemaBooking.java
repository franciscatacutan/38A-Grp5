import java.util.Scanner;
import java.util.ArrayList;

class Person {
    String name;
    String movie;
    int seatNumber;

    Person(String name, String movie, int seatNumber) {
        this.name = name;
        this.movie = movie;
        this.seatNumber = seatNumber;
    }

    void display() {
        System.out.println("Name: " + name + ", Movie: " + movie + ", Seat Number: " + seatNumber);
    }
}

public class CinemaBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                System.out.print("Enter number of tickets (max 5 tickets): "); // enters the number of tickets the person wants to buy
                numOfTickets = scanner.nextInt();

                if (numOfTickets <= 5) {
                    for (int j = 1; j < numOfTickets; j++){
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

            System.out.print("Do you want to book another? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Display all bookings
        for (Person person : people) {
            person.display();
        }

        scanner.close();
    }
}

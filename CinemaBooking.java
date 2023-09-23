import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Person {
    String name;
    String movie;
    ArrayList<Integer> seatNumbers;

    Person(String name, String movie, ArrayList<Integer> seatNumbers) {
        this.name = name;
        this.movie = movie;
        this.seatNumbers = seatNumbers;
    }

    void display() {
        System.out.println("Name: " + name + ", Movie: " + movie + ", Seat Numbers: " + seatNumbers);
    }
}

public class CinemaBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        Map<String, ArrayList<Integer>> availableSeats = new HashMap<>();

        // Initialize available seats for each movie
        availableSeats.put("Movie 1", new ArrayList<>());
        availableSeats.put("Movie 2", new ArrayList<>());
        availableSeats.put("Movie 3", new ArrayList<>());

        for (int i = 1; i <= 20; i++) {
            availableSeats.get("Movie 1").add(i);
            availableSeats.get("Movie 2").add(i);
            availableSeats.get("Movie 3").add(i);
        }

        String[] movies = {"Movie 1", "Movie 2", "Movie 3"};

        while (true) {
            System.out.println("Enter details for booking:");

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            // Choose a movie
            System.out.println("Available movies:");
            for (int i = 0; i < movies.length; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }
            int movieChoice;
            while (true) {
                System.out.print("Enter movie choice (1-" + movies.length + "): ");
                movieChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                if (movieChoice >= 1 && movieChoice <= movies.length) {
                    String selectedMovie = movies[movieChoice - 1];
                    ArrayList<Integer> remainingSeats = availableSeats.get(selectedMovie);

                    if (!remainingSeats.isEmpty()) {
                        System.out.println("Available seats for " + selectedMovie + ": " + remainingSeats);
                        System.out.print("Enter seat numbers (comma-separated, e.g., 1,5,10): ");
                        String seatInput = scanner.nextLine();
                        String[] seatStrings = seatInput.split(",");
                        ArrayList<Integer> selectedSeats = new ArrayList<>();

                        for (String seatStr : seatStrings) {
                            int seatNumber = Integer.parseInt(seatStr.trim());
                            if (remainingSeats.contains(seatNumber)) {
                                selectedSeats.add(seatNumber);
                            } else {
                                System.out.println("Seat " + seatNumber + " is not available. Please choose from available seats.");
                            }
                        }

                        if (!selectedSeats.isEmpty()) {
                            for (int seatNumber : selectedSeats) {
                                remainingSeats.remove(Integer.valueOf(seatNumber));
                            }
                            availableSeats.put(selectedMovie, remainingSeats);
                            people.add(new Person(name, selectedMovie, selectedSeats));
                            break;
                        }
                    } else {
                        System.out.println("All seats for " + selectedMovie + " are occupied. Please choose another movie.");
                    }
                } else {
                    System.out.println("Invalid movie choice. Please enter a valid choice.");
                }
            }

            System.out.print("Do you want to book another ticket? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Display all bookings
        System.out.println("\nAll Bookings:");
        for (Person person : people) {
            person.display();
        }

        scanner.close();
    }
}

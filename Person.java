public class Person {
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

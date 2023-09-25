public class Payment {

    String paymentMethod;
    int amount;

    public double computeAmount(int numOfTicket) {

        int price = 250;

        double amount = price * numOfTicket;
        return amount;

    }

}

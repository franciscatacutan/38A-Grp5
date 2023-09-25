public class Payment {

    enum paymentMethod {cash, gcash};
    int amount;

    public double computeAmount(int numOfTicket) {

        int price = 250;

        double amount = price * numOfTicket;
        return amount;

    }

    public String paymentMethod(String paymentMethod) {
        if (paymentMethod == "cash") {
            return "cash";
        } else {
            return "gcash";
        }
    }
}

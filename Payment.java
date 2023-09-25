public class Payment {

    int amount;

    public double computeAmount(int numOfTicket) {

        int price = 250;

        double amount = price * numOfTicket;
        return amount;

    }

    public String paymentMethod(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("cash")) {
            return "CASH";
        } else {
            return "GCASH";
        }
    }
}

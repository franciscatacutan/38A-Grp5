public class Payment {

    String paymentMethod;
    int amount;
    
    public double computeAmount(int price, int numOfTicket){
        
        double amount = price * numOfTicket;
        return amount;

    }

}

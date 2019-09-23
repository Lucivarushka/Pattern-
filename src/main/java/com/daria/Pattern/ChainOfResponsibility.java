package main.java.com.daria.Pattern;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Payment cardPayment = new CardPayment();
        Payment cashPalPayment = new CashPayment();
        cardPayment.setNext(cashPalPayment);
        cardPayment.pay();
    }
}

interface Payment {

    void setNext(Payment payment);

    void pay();
}

class CardPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println("Card Payment");
    }
}

class CashPayment implements Payment {
    private Payment payment;

    public void setNext(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        System.out.println("Cash Payment");
    }
}



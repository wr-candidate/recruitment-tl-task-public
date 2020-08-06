package main.java.card.information;


public class CreditCardInformation {

    public CreditCardInformation(String[] inputArgs){
        cardIssuerName = inputArgs[0];
        cardNumber = inputArgs[1];
    }

    public String getCardIssuerName() {
        return cardIssuerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    private String cardIssuerName;
    private String cardNumber;//int may be too small, I think it's the better solution than the int array
}

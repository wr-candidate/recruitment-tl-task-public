package main.java.card.issuer;

import java.util.ArrayList;

//for now it stores only information about length, but it provides possibility to expand program to check other values
//like digits in IIN Range, which identifies the Issuer
public class CardIssuerParameters {

    CardIssuerParameters(String crdIssuerNm, ArrayList<Integer> lngthOfCrdNmb){
        cardIssuerName = crdIssuerNm;
        lengthsOfCardNumber = lngthOfCrdNmb;
    }

    public ArrayList<Integer> getLengthOfCardNumber() {
        return lengthsOfCardNumber;
    }

    public String getCardIssuerName() { return cardIssuerName; }

    private String cardIssuerName;
    private ArrayList<Integer> lengthsOfCardNumber;//number of digits for card may be different for one issuer
}

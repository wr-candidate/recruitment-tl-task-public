package main.java.card.issuer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardIssuers {
    private static Map<String, CardIssuerParameters> cardIssuersMap =  new HashMap<String, CardIssuerParameters>();

    public static boolean doesIssuerExist(String issuerName) {
        if(cardIssuersMap.get(issuerName) == null)
            return false;
        else
            return true;
    }

    public static CardIssuerParameters getIssuerParameters(String issuerName){
        return cardIssuersMap.get(issuerName);
    }

    public static void prepareCardIssuersMap()
    {
        //EXAMPLE DATA(in future it may be created from a file)

        ArrayList<Integer> digitNumber = new ArrayList<Integer>();
        //MasterCard
        digitNumber.add(16);
        CardIssuerParameters masterCardParamters = new CardIssuerParameters("MasterCard", digitNumber);
        cardIssuersMap.put("MasterCard", masterCardParamters);

        digitNumber.clear();
        //Visa
        digitNumber.add(13);
        digitNumber.add(16);
        digitNumber.add(19);
        CardIssuerParameters visaCardParameters = new CardIssuerParameters("Visa", digitNumber);
        cardIssuersMap.put("Visa", visaCardParameters);
    }
}

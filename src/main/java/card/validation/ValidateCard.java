package main.java.card.validation;

import main.java.card.issuer.CardIssuerParameters;
import main.java.card.information.CreditCardInformation;
import main.java.card.issuer.CardIssuers;

import java.io.IOException;
import java.util.ArrayList;

public class ValidateCard {

    public enum ResultTypeEnum {
        SUCCESS("Validated"),
        ERR_ISUER("Incorrect issuer name"),
        ERR_LENGTH("Incorrect card length"),
        ERR_LUHN("Card number didn't successfully pass Luhn validation");

        ResultTypeEnum(String msg){
            message = msg;
        }
        public String getMessage() {
            return message;
        }

        private String message;
    }


    public static ResultTypeEnum performValidation(String[] inputArgs){
        CardInputArgumentsControl inputControl = new CardInputArgumentsControl(inputArgs, 2);

        try {
            inputControl.checkInput();
        }
        catch(IOException e){
            System.out.println(e);
            System.exit(1);
        }

        CreditCardInformation creditCard = new CreditCardInformation(inputArgs);

        if(!CardIssuers.doesIssuerExist(creditCard.getCardIssuerName()))
            return ResultTypeEnum.ERR_ISUER;

        if (!checkCardNumberLength(creditCard))
            return ResultTypeEnum.ERR_LENGTH;

        if (!validateCardNumber(creditCard.getCardNumber()))
            return ResultTypeEnum.ERR_LUHN;

        return ResultTypeEnum.SUCCESS;
    }

    private static boolean checkCardNumberLength(CreditCardInformation creditCard){
        String currentCardIssuerName = creditCard.getCardIssuerName();
        String currentCardNumber = creditCard.getCardNumber();
        int currentCardNumberLength = currentCardNumber.length();

        CardIssuerParameters cardIssuer =  CardIssuers.getIssuerParameters(currentCardIssuerName);
        ArrayList<Integer> lengthsOfCardNumber = cardIssuer.getLengthOfCardNumber();

        for(Integer numberLength : lengthsOfCardNumber)
            if (numberLength == currentCardNumberLength)
                return true;

        return false;
    }

    private static boolean validateCardNumber(String cardNumber){
        //it uses Luhn algorithm
        ArrayList<Integer> digitsInNumber = stringToDigitsArrayInt(cardNumber);

        int sum = 0 ;

        //multiply odd digits by 2
        for(int i = 0 ; i < digitsInNumber.size() ; i += 2) {
            int curNmb = digitsInNumber.get(i);
            curNmb *= 2;

            if(curNmb > 9)
                curNmb -= 9;

            sum += curNmb;
        }

        for(int i = 1 ; i < digitsInNumber.size() ; i += 2)
            sum += digitsInNumber.get(i);

        if( sum % 10 == 0)
            return true;
        else
            return false;
    }

    private static ArrayList<Integer> stringToDigitsArrayInt(String numberInStr){
        ArrayList<Integer> digitsArray = new ArrayList<Integer>();

        for(int i = 0 ; i < numberInStr.length()  ; i++ )
            digitsArray.add( numberInStr.charAt(i) -'0');

        return digitsArray;
    }
}

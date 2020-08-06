package main.java.card;

import main.java.card.validation.ValidateCard;
import main.java.card.issuer.CardIssuers;

public class Main {
    public static void main(String[] args) {
        CardIssuers.prepareCardIssuersMap();

        ValidateCard.ResultTypeEnum validationResult = ValidateCard.performValidation(args);

        if (validationResult == ValidateCard.ResultTypeEnum.SUCCESS)
            System.out.println("Valid");
        else
            System.out.println("Invalid");

        //More precise information about the result
        System.out.println(validationResult.getMessage());
    }
}

package main.java.card.validation;

import java.io.IOException;

public class CardInputArgumentsControl {

    public CardInputArgumentsControl(String[] inputArgs, int expectedArgsNmb){
        expectedArgumentsNmb = expectedArgsNmb;
        inputArguments = inputArgs;
    }

    public void checkInput() throws IOException{
        if(!isInputLentgthCorrect())
            throw new IOException("Wrong number of input arguments.");

        if(!isCardNumberCorrect())
            throw new IOException("Didn't provide a card number in a proper format.");
    }

    private boolean isInputLentgthCorrect(){
        if( inputArguments.length != expectedArgumentsNmb )
            return false;
        else
            return true;
    }

    private boolean isCardNumberCorrect(){
        return inputArguments[1].matches("[0-9]+");
    }

    private String [] inputArguments;
    private int expectedArgumentsNmb;
}

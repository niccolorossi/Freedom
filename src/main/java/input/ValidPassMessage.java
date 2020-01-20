package input;

import exceptions.WrongPassMessageException;

public class ValidPassMessage {
    
    private String inputString;
    
    public ValidPassMessage(String inputString) {
        this.inputString = inputString;
    }
    
    public String passMessage() throws WrongPassMessageException {
        if(!inputString.equals("Y") && !inputString.equals("N")) {
            throw new WrongPassMessageException("Type Y if you want to pass, N otherwise!");
        } else return inputString;
    }
}

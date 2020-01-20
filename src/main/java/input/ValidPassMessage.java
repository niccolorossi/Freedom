package input;

import exceptions.WrongPassMessageException;

class ValidPassMessage {
    
    private String inputString;
    
    ValidPassMessage(String inputString) {
        this.inputString = inputString;
    }
    
    String passMessage() throws WrongPassMessageException {
        if(!inputString.equals("Y") && !inputString.equals("N")) {
            throw new WrongPassMessageException("Type Y if you want to pass, N otherwise!");
        } else return inputString;
    }
}

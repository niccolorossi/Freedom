package it.freedom;

import it.freedom.exceptions.OutOfBoundsException;

class Player {
    
    private Character playerStone;
    
    Player(Character playerStone) {
        this.playerStone = playerStone;
    }

    private void checkBounds(int coordinate) throws OutOfBoundsException {
        if(coordinate < 0 || coordinate > 9)
            throw new OutOfBoundsException(coordinate + " is out of bound!");
    }
    
    
    
    public void move(int x, int y) {
        try {
            checkBounds(x);
        } catch (OutOfBoundsException e1) {
            System.out.println(e1.getMessage());
        }
        try {
            checkBounds(y);
        } catch (OutOfBoundsException e2) {
            System.out.println(e2.getMessage());
        }
    }
}

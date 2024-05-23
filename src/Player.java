import java.sql.SQLOutput;
import java.util.Arrays;

public class Player {
    public int handLength;

    public int handValue;
    public Card[] hand = new Card[99];
    public String name;
    public boolean isPlayer; //dealer vs. player - maybe make into a boolean
    public String decision;
    int numCards;
    public Player(String pUserName) {
        name = pUserName;
        isPlayer = true;

    }

    public void print() {
        System.out.println("");
        if (isPlayer){
            System.out.println("You have " + handValue + " points:");
        } else {
            System.out.println("the dealer has " + handValue + " points:");
        }
        for (int i=0; i<handLength; i++) {
            hand[i].print();
        }

    }

    public void addCard(Card c){
        hand[handLength] = c;
        handLength += 1;
        handValue += c.value;

    }

}
import java.sql.SQLOutput;
import java.util.Arrays;

public class Player {

    public int handValue;
    public Card[] hand = new Card[2];
    public String name;
    public boolean isPlayer; //dealer vs. player - maybe make into a boolean
    public boolean isHit;
    int numCards;
    public Player(String pUserName) {
        name = pUserName;
        isPlayer = true;

    }

    public void print() {
        if (isPlayer){
            System.out.println("hi, " + name);
            System.out.println("You have " + handValue + " points");
        } else {
            System.out.println("the dealer has " + handValue + " points");
        }
        for (int i=0; i<hand.length; i++) {
            hand[i].print();
        }

    }

    public void addCard(Card c){
        hand[numCards] = c;
        numCards = numCards+1;
        handValue += c.value;
    }

}

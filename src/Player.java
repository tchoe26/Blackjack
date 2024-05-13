import java.util.Arrays;

public class Player {

    public int handValue;
    public Card[] hand;
    public String name;
    public String playerType; //dealer vs. player - maybe make into a boolean
    public boolean isHit;
    public Player(String pName, Card[] pHand, String pPlayerType) {
        name = pName;
        hand = pHand;
        playerType = pPlayerType;

        for (int i=0; i<hand.length; i++) {
            handValue+=hand[i].value;
        }

    }

    public void print() {
        System.out.println("Player " + name + "is a" + playerType + "who has cards " + Arrays.toString(hand) + " equaling a value of " + handValue);
    }

}

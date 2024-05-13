import java.sql.SQLOutput;
import java.util.Arrays;

public class Player {

    public int handValue;
    public Card[] hand;
    public String name;
    public boolean isPlayer; //dealer vs. player - maybe make into a boolean
    public boolean isHit;
    public Player(String pUserName) {
        name = pUserName;
        isPlayer = true;



    }

    public void print() {
        if (isPlayer){
            System.out.println("hi, " + name);
            System.out.println("You have " + handValue + " points");
        } else {
            System.out.println("dealer info");
        }
    }

}

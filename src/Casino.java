import java.util.Objects;
import java.util.Scanner;
public class Casino {

    public Card[] deck;
    public int deckPosition;
    public Player p;
    public Player dealer;
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Casino c = new Casino();
    }




    public Casino() {
        System.out.println("welcome to the casino");
        makeDeck();
        shuffleDeck();
        printDeck();



        System.out.println("enter your username:");
        String userName = scan.nextLine();
        System.out.println("hi, " + userName);
        p = new Player(userName);

        dealer = new Player("dealer");
        dealer.isPlayer = false;

        deal();
        playGame();
    }

    public void makeDeck() {
        deck = new Card[52];
        int count=0;

        //setting the suit
        for (int s=0; s<4; s++) {
            for (int t=0; t<13; t++) {
                deck[count] = new Card(s,t);
                count++;
            }
        }
    }

    public void shuffleDeck() {
        for (int x=0; x<52; x++) {
            int randomIndex = (int)(Math.random()*52);
            Card randomCard = deck[randomIndex];

            Card temp = deck[x];
            deck[x]=randomCard;
            deck[randomIndex] = temp;
        }

    }
    public void printDeck() {
        for (int i=0; i<52; i++) {
            deck[i].print();
        }
    }

    public void deal(){
        dealCard(p);
        dealCard(p);
        dealCard(dealer);
        p.print();
        dealer.print();
    }

    public void playGame() {
        System.out.println("hit or stand? (h/s)");
        p.decision = scan.nextLine();
        if (Objects.equals(p.decision, "h")) {
            hit(p);
        } if (Objects.equals(p.decision, "s")) {
            stand();
        }
    }

    public void hit(Player temp) {
        dealCard(temp);
        p.print();
        dealer.print();
        if (temp.handValue>21 && temp.isPlayer) {
            System.out.println();
            System.out.println("bust");
            System.out.println("dealer wins");
            reset();
        } else if (temp.handValue>21){
            System.out.println();
            System.out.println("dealer bust");
            System.out.println("you win!");
            reset();
        } else if (temp.isPlayer) {
            playGame();
        }
    }
    public void stand() {
        System.out.println("you chose to stand:");
        while (dealer.handValue<17) {
            hit(dealer);
        }
        if (p.handValue > dealer.handValue && p.handValue<=21) {
            System.out.println();
            System.out.println("you win!");
            reset();
        } else if (dealer.handValue>p.handValue && dealer.handValue<=21) {
            System.out.println();
            System.out.println("dealer wins");
            reset();
        } else if (dealer.handValue==p.handValue) {
            System.out.println("push");
            reset();
        }
    }
    public void dealCard(Player temp) {
        temp.addCard(deck[deckPosition]);
        deckPosition++;
    }

    public void reset() {
        System.out.println("do you want to play again? (y/n)");
        p.reset = scan.nextLine();
        if (deckPosition>40) {
            System.out.println("shuffling the deck...");
            makeDeck();
            shuffleDeck();
            deckPosition=0;
        }
        if (Objects.equals(p.reset, "y")) {
            p.decision = null;
            p.handLength = 0;
            p.handValue = 0;
            dealer.handLength = 0;
            dealer.handValue = 0;
            deal();
            playGame();
        } else if (Objects.equals(p.reset, "n")) {
            System.out.println("thank you for playing :)");
        }
    }

}
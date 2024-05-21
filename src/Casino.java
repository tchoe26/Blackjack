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
        System.out.println(userName);
        p = new Player(userName);

        dealer = new Player("dealer");
        dealer.isPlayer = false;

        deal();

        p.print();

        dealer.print();
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
        dealCard(dealer);
    }

    public void playGame() {
        System.out.println("hit or stand?");
        p.decision = scan.nextLine();
        if (Objects.equals(p.decision, "hit")) {
            hit(p);

        } if (Objects.equals(p.decision, "stand")) {
            System.out.println("stand");
        }
    }

    public void hit(Player temp) {
        dealCard(p);
        p.print();
        playGame();
    }
    public void dealCard(Player temp) {
        temp.addCard(deck[deckPosition]);
        deckPosition++;
        temp.handLength++;
    }

}



import java.util.Scanner;
public class Casino {

    public Card[] deck;
    public boolean isHit;
    public Player p;
    public static void main(String[] args) {
        Casino c = new Casino();
    }


    public Casino() {
        System.out.println("welcome to the casino");
        makeDeck();
        shuffleDeck();
        printDeck();


        Scanner scan = new Scanner(System.in);
        System.out.println("enter your username:");
        String userName = scan.nextLine();
        System.out.println(userName);
        p = new Player(userName);
        p.print();

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
        p.hand[0] = deck[0];
        p.hand[1] = deck[1];
    }

}



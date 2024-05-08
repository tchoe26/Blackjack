public class Casino {

    public Card[] deck;
    public static void main(String[] args) {
        Casino c = new Casino();
    }


    public Casino() {
        System.out.println("welcome to the casino");
        deck = new Card[52];
        int count=0;

        //setting the suit
        for (int s=0; s<4; s++) {
            for (int t=0; t<13; t++) {
                deck[count] = new Card(s,t);
                deck[count].print();
            }
        }
    }


}



public class Card {

    public String suit;
    public String type;
    public int value;
    public Card(int pSuit, int pType){
        if (pType == 0) {
            type = "Ace";
            value = 11;
        } if (pType==1) {
            type = "2";
            value = 2;
        } if (pType==2) {
            type = "3";
            value = 3;
        } if (pType==3) {
            type = "4";
            value = 4;
        } if (pType==4) {
            type = "5";
            value = 5;
        } if (pType==5) {
            type = "6";
            value = 6;
        } if (pType==6) {
            type = "7";
            value = 7;
        } if (pType==7) {
            type = "8";
            value = 8;
        } if (pType==8) {
            type = "9";
            value = 9;
        } if (pType==9) {
            type = "10";
            value = 10;
        } if (pType==10) {
            type = "Jack";
            value = 10;
        } if (pType==11) {
            type = "Queen";
            value = 10;
        } if (pType==12) {
            type = "King";
            value = 10;
        }

        if (pSuit==0) {
            suit = "Spades";
        } if (pSuit==1) {
            suit = "Hearts";
        } if (pSuit==2) {
            suit = "Clubs";
        } if (pSuit==3) {
            suit = "Diamonds";
        }
    }



    public void print() {
        System.out.println("the " + type + " of " + suit + " is worth " + value);
    }
}

/*
Name: Elliot Park
ID: 304269516
Class; PIC 20A
*/
package hw3;

public class WarCard {

    //War Card fields
    private String suit;
    private String rank;
    private int value;
    
    //Takes in a number from 0 to 51
    public WarCard(int a) {

        switch (a/4) 
        {
            case 0:
                this.rank = "Two";
                this.value = 2;
                break;
            case 1:
                this.rank = "Three";
                this.value = 3;
                break;
            case 2:
                this.rank = "Four";
                this.value = 4;
                break;
            case 3:
                this.rank = "Five";
                this.value = 5;
                break;
            case 4:
                this.rank = "Six";
                this.value = 6;
                break;
            case 5:
                this.rank = "Seven";
                this.value = 7;
                break;
            case 6:
                this.rank = "Eight";
                this.value = 8;
                break;
            case 7:
                this.rank = "Nine";
                this.value = 9;
                break;
            case 8:
                this.rank = "Ten";
                this.value = 10;
                break;
            case 9:
                this.rank = "Jack";
                this.value = 11;
                break;
            case 10:
                this.rank = "Queen";
                this.value = 12;
                break;
            case 11:
                this.rank = "King";
                this.value = 13;
                break;
            case 12:
                this.rank = "Ace";
                this.value = 14;
                break;
            default:
                break;
        }
        
        switch(a%4){
            case 0:
                this.suit = "Diamonds";
                break;
            case 1:
                this.suit = "Clubs";
                break;
            case 2:
                this.suit = "Hearts";
                break;
            case 3:
                this.suit = "Spades";
                break;
        }
    }
    
    public String toString()
    {
        String full;
        
        full = this.rank + " of " + this.suit;
        
        return full;
    }
    
    public int compareTo(WarCard b)
    {        
        //this.player had the better card
        if(this.value > b.value)
        {
            return -1;
        }
        //b.player had the better card
        else if(this.value < b.value)
        {
            return 1;
        }
        //this.player and b.player had the same card, initiate war!
        else
        {
            return 0; //if a and b are equal
        }
    }

}

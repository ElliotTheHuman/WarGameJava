/*
Name: Elliot Park
ID: 304269516
Class: PIC 20A
*/
package hw3;

import java.util.*;

public class WarTester {
    
        public void WarTest() {
        
            //Testing WarCard    
            WarCard a = new WarCard(1);
            WarCard b = new WarCard(51);
            WarCard c = new WarCard(50);

            //Testing toString function
            System.out.println(a.toString()); //should output Two of Clubs
            System.out.println(b.toString()); //should output Ace of Spades
            System.out.println(c.toString()); //should output Ace of Hearts

            //Testing compareTo function
            System.out.println(a.compareTo(b)); //should output 1
            System.out.println(b.compareTo(c)); //should output 0
            System.out.println(b.compareTo(a)); //shoudl output -1

            System.out.println("");
            System.out.println("");
            
            /////////////////////////////////////////////////////////////
            
            //Testing WarDeck Constructor
            WarDeck yugi = new WarDeck();
            for(int i = 0; i < 52; i++)
            {
                System.out.println(yugi.getCard(i)); //should print out all cards in order
            }
            
            System.out.println("");
            System.out.println("");
            
            //Testing shuffle function
            yugi.shuffle();
            for(int i = 0; i < 52; i++)
            {
                System.out.println(yugi.getCard(i)); //should print out all cards in randomized order
            }
            
            //We will test dealCards function in the next section
            
            System.out.println("");
            System.out.println("");
            
            /////////////////////////////////////////////////////////////
            
            //Testing WarPlayer Constructor && acceptCard function
            WarPlayer foo = new WarPlayer("MARCUS");
            WarPlayer goo = new WarPlayer("DOM");
            
            foo.acceptCard(new WarCard(4));
            goo.acceptCard(new WarCard(8)); 
            foo.print(); //should output Three of Diamonds
            goo.print(); //should output Four of Diamonds
            
            //Testing playCard function && topCard function
            foo.playCard();
            goo.playCard();
            (foo.topCard()).toString(); //should output Three of Diamonds in foo's pile
            (goo.topCard()).toString(); //should output Four of Diamonds in goo's pile
     
            //Testing dealCards function
            yugi.dealCards(foo, goo);
            foo.print(); //should now have 26 cards in hand
            goo.print(); //should now also have 26 cards in hand
            
            //Testing takeCards function
            foo.takeCards(goo);
            foo.print(); //should show that foo has 28 cards in hand now
        }
        
 }

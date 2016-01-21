/*
Name: Elliot Park
ID: 304269516
Class; PIC 20A
*/
package hw3;

import java.util.*;

public class WarDeck {
    
    //Fields
    private ArrayList<WarCard> deck; // note this is just a pointer to an list
    private int size = 52;
    
    //Default Constructor
    public WarDeck()
    {
        //initialize the deck; we need to construct an Array list
        deck = new ArrayList<WarCard>();
        
        for(int i = 0; i < 52; i++)
        {            
            //We will create a new War Card for each value of i, 0<=i<=51
            deck.add(new WarCard(i));
        }
    }
    
    //strictly for testing purposes
    public WarCard getCard(int i)
    {
        return deck.get(i);
    }
    
    //Should shuffle itself; try creating a new ArrayList
    public void shuffle() 
    {
        //Create a new deck to pull from
        WarDeck temp = new WarDeck();
            
        for(int i = this.size - 1; i >= 0; i--)
        {            
            //random generates random double from 0 to i
            int rand = (int)(Math.random() * (i+1));
            
            //switch the random card from temp and the current card in deck
            (this.deck).set(i, (temp.deck).get(rand));
            
            //now remove that random card from temp
            (temp.deck).remove(rand);
        }
    }
    
    //Should deal itself
    public void dealCards(WarPlayer a, WarPlayer b)
    {
        for(int i = 0; i < 52; i++) //run through 0 to 51
        {
            //We're going to deal one card to each player at a time
            if(i%2 == 0)
            {   
                //Try creating a new card and going from there
                a.acceptCard(deck.get(i)); //a accepts card into their hand
            }
            else
            {
                b.acceptCard(deck.get(i));//b accepts card into their hand
            }
        }
    }
}

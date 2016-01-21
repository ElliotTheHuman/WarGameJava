/*
Name: Elliot Park
ID: 304269516
Class; PIC 20A
*/
package hw3;

import java.util.*;

public class WarPlayer {
    
    //Fields
    private String name;
    private ArrayList<WarCard> hand;
    private ArrayList<WarCard> pile;
    
    //Constructor
    public WarPlayer(String name)
    {
        this.name = name;
        this.hand = new ArrayList<WarCard>();
        this.pile = new ArrayList<WarCard>();
    }
    
    //Accept function
    public void acceptCard(WarCard c)
    {     
        //want to add c into the hand
         hand.add(c);
    }
    
    public WarCard topCard()
    {
        return pile.get(pile.size() - 1);
    }
    
    public void playCard()
    {
        //want to move first card from hand into pile, then remove from hand
        pile.add(hand.get(0)); //add first card from hand
        hand.remove(0); //remove that card from hand
    }
    
    public void takeCards(WarPlayer loser)
    {
        int aBound = this.pile.size();
        int bBound = loser.pile.size();
        
        //Want to take cards from both piles into hand
        //First add cards from your pile
        while(this.pile.size() > 0)
        {
            //add card from pile to hand
            (this.hand).add((this.pile).get(0)); //the first guy from the pile
            (this.pile).remove((this.pile).get(0));
        }
        
        //Then add piles from other player
        while(loser.pile.size() > 0)
        {
            (this.hand).add(loser.pile.get(0));
            (loser.pile).remove(loser.pile.get(0));
        }
    }
    
    public void print()
    {
        if(pile.size() > 0)
        {
            System.out.print(name + "\'s " + "Pile: ");   
        }
        
        for(int i = pile.size() - 1; i >= 0; i--)
        {
                if(i == 0 && hand.size() == 0) //the last guy
                    System.out.print((pile.get(i)).toString());
                else if(i == 0) //the last guy with separating bar
                    System.out.print((pile.get(i)).toString() + " | "); // put the bar
                else if(i == pile.size() - 3 && hand.size() > 4)
                {
                    System.out.print("(" + (hand.size() - 4) + " more), ");
                    i = 2; //this is so we'll end up at the 2nd to last element in the next iteration
                }
                else
                    System.out.print((pile.get(i)).toString() + ", ");
        } 
        
        
        if(hand.size() > 0)
        {
            System.out.print(name + "\'s " + "Hand: ");
        }
        
        for(int i = 0; i < hand.size(); i++)
        {
                if(i == hand.size() - 1) //the last guy
                    System.out.print((hand.get(i)).toString());
                else if(i == 2 && hand.size() > 4)
                {
                    System.out.print("(" + (hand.size() - 4) + " more), ");
                    i = hand.size() - 3; //this is so we'll end up at the 2nd to last element in the next iteration
                }
                else
                    System.out.print((hand.get(i)).toString() + ", ");
        }
        
        System.out.println("");
    }
    
    //Strictly to be used as a finishing condition
    public int getHandSize()
    {
        return this.hand.size();
    }
        
    public String getName()
    {
        return this.name;
    }
}

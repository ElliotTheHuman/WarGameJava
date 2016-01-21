package hw3;

public class WarGame {
    
    public static void main(String[] args) {
        
        //Our WarTester triggers if we uncomment these two lines
        //WarTester alpha = new WarTester();
        //alpha.WarTest();

        System.out.println("Ladies and gentlemen! Let us begin!");
        System.out.println("");
        
        //Create two players
        WarPlayer P1 = new WarPlayer("Pompey");
        WarPlayer P2 = new WarPlayer("Caeser");
        
        //We create a deck
        WarDeck gulch = new WarDeck();
        //Shuffle the cards
        gulch.shuffle();
        //Deal the cards
        gulch.dealCards(P1, P2);
        
        //Initial Hands
        System.out.println("Initial Hands");
        P1.print();
        P2.print();

        int round = 1;
        int result;
        
        while(P1.getHandSize() < 52  && P2.getHandSize() < 52)
        {
            do // we include a do while within the while loop so that if war is initiated, we don't bump up the round count
            {
                //Each player plays a card as long as they have cards in hand
                if(P1.getHandSize() != 0)
                {
                    P1.playCard();
                }    
                
                if(P2.getHandSize() != 0)
                {    
                    P2.playCard();
                } 
                
                WarCard P1Card = P1.topCard();
                WarCard P2Card = P2.topCard();
                
                //We compare those cards and get a result integer
                result = (P1Card).compareTo(P2Card);
                
                //State the round and each player's hand
                System.out.println("Round " + round);
                P1.print();
                P2.print();
                
                switch (result) {
                    case -1:
                        P1.takeCards(P2);
                        System.out.print(P1.getName() + " says: I win! ");
                        System.out.println(P1.getName() + " took the pile.");
                        break;
                    case 1:
                        P2.takeCards(P1);
                        System.out.print(P2.getName() + " says: I win! ");
                        System.out.println(P2.getName() + " took the pile.");
                        break;
                    case 0:
                        //need to initiate War
                        System.out.println("WAR!");
                        
                        if(P1.getHandSize() != 0)
                        {
                            P1.playCard();
                        }
                        if(P2.getHandSize() != 0)
                        {    
                            P2.playCard();
                        }  
                        
                        break;
                }
            
            //now if we initiated war, then we'll run the loop again!
            }while(result == 0);
            
            round++;
        }
        
        System.out.println("Game Over!");
    }
}

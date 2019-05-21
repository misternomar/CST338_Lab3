/* Team 1
 * Austin Ah Loo
 * Ramon Lucindo
 * Mikie Reed
 * Mitchell Saunders
 * Nick Saunders
 * CST 338 - Module 3: Deck of Cards
 */

import java.util.*;

/**
 * Class that contains all parts of Lab 3 - Decks of Cards
 *
 * @author Team 1
 */
public class Assig3
{
   /**
    * Starting point for program
    *
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      //testCardClass(); //Phase 1
      //testHandClass(); //Phase 2
      testDeckClass();   //Phase 3
      testHandDeck();    //Phase 4
   }

   /**
    * Runs the tests required to confirm Phase 1
    *
    */
   private static void testCardClass()
   {
      //System.out.println("Testing Phase 1");
      // instantiate three cards, two legally, and one illegally 
      Card card1 = new Card();
      Card card2 = new Card('Z', Card.Suit.diamonds);
      Card card3 = new Card('Q', Card.Suit.hearts);
      printThreeCards(card1, card2, card3);
      
      // make good card bad by set() with an illegal value,
      //and second card vice versa
      card1.set('X', Card.Suit.clubs);
      card2.set('T', Card.Suit.diamonds);     
      System.out.println();
      printThreeCards(card1, card2, card3);
      System.out.println();
   }
   
   /**
    * Prints 3 cards via println to confirm cards are set correctly
    *
    * @param Card card1 = first card object
    * @param Card card2 = second card object
    * @param Card card3 = third card object
    */
   private static void printThreeCards(Card card1, Card card2, Card card3)
   {
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
   }
   
   /**
    * Runs the tests required to confirm Phase 2
    *
    */
   private static void testHandClass()
   {
      System.out.println("Testing Phase 2");
      Card card1 = new Card('A', Card.Suit.hearts);
      Card card2 = new Card('K', Card.Suit.diamonds);
      Card card3 = new Card('Q', Card.Suit.hearts);
      Card card4 = new Card('4', Card.Suit.spades);
      Card card5 = new Card('8', Card.Suit.clubs);
      Card[] cards = new Card[] {card1, card2, card3, card4, card5};
      Hand hand = getHand(cards);
      
      System.out.println("After deal");
      printHand(hand);

      testInspectCard(hand);
      
      playAllCards(hand);
      
      System.out.println("After playing all cards");
      printHand(hand);
   }

   /**
    * Loops all cards, uses playCard() with each
    *
    * @param Hand hand = hand to loop and playCard()
    */
   private static void playAllCards(Hand hand)
   {
      //System.out.println("Testing playCard()");
      int totalCards = hand.getNumCards();
      for (int i = 0; i < totalCards; i++) 
      { 
         System.out.print("Playing ");
         System.out.println(hand.playCard());
      }
      System.out.println();
   }

   /**
    * Tests a couple cards in hand with inspectCard()
    * Tests first card, and last card + 1 (INVALID)
    *
    * @param Hand hand = hand to test cards from
    */
   private static void testInspectCard(Hand hand)
   {
      //System.out.println("Testing inspectCard()");
      System.out.println(hand.inspectCard(0));
      System.out.println(hand.inspectCard(Hand.MAX_CARDS));
      System.out.println();
   }

   /**
    * Uses print to show entire hand with "Hand = ( " and
    * " )" on both sides
    *
    * @param Hand hand = hand to loop and playCard()
    */
   private static void printHand(Hand hand)
   {
      System.out.println("Hand = ( " + hand.toString() + " )");
      System.out.println();
   }

   /**
    * Sets up a hand based on card array
    * 
    * @param Card[] cards to add to hand
    * @return Hand new hand object with cards
    */
   private static Hand getHand(Card[] cards)
   {
      Hand hand = new Hand();
      int i = 0;
      int j = 0;
      while (i < Hand.MAX_CARDS) 
      { 
         hand.takeCard(cards[j]);
         i++;
         j++;
         if (j > cards.length - 1)
         {
            j = 0; // ran out of cards, duplicate
         }
      }
      System.out.println("Hand Full");
      return hand;
   }


   private static void testDeckClass()
   {
      //System.out.println("Testing Phase 3");
      //testing of class Deck with two decks)
      Deck deck1 = new Deck(2);
    
      // unshuffled deck
      for(int i = 0; i < 52 * 2; i++)
      {
         // Displaying the cards dealed as it is dealed.
         Card dealedCards = deck1.dealCard();
         System.out.print(dealedCards.toString() + " / ");
      } 
      System.out.println("\n"); 

      deck1.init(2);
    
      // shuffled deck
      deck1.shuffle();
    
      for(int i = 0; i < 52 * 2; i++)
      {
         Card dealedCards = deck1.dealCard();
         System.out.print(dealedCards.toString() + " / ");
      } 
      System.out.println("\n");
      System.out.println();
    
      // testing of class Deck with one deck
      deck1.init(1);
     
      // unshuffled deck
      for(int i = 0; i < 52; i++)
      {
         Card dealedCards = deck1.dealCard();
         System.out.print(dealedCards.toString() + " / ");
      } 
      System.out.println("\n"); 

      deck1.init(1);
     
      // shuffled deck
      deck1.shuffle();
      for(int i = 0; i < 52; i++)
      {
         Card dealedCards = deck1.dealCard();
         System.out.print(dealedCards.toString() + " / ");
      } 
      System.out.println("\n");
      System.out.println();
   }
   
   // testing both Hand and Deck classes working together
   private static void testHandDeck()
   {
      int numHands = 0; // set to zero to initialize loop
    
      Scanner input = new Scanner(System.in);
    
      // loop user prompt and validate a legal value (anything negative or 
      // more than 10 will keep asking for legal input
      while (numHands <= 0 || numHands > 10)
      {
         System.out.println("How many hands? (1 - 10, please): ");
         numHands = input.nextInt();
      }
    
      // instantiate single Deck and Hand objects
      Hand[] hands = new Hand[numHands];
      Deck deck = new Deck();
    
      // create user defined number of hands to deal to
      for (int i = 0; i < hands.length; i++)
      {
         hands[i] = new Hand();
      }
    
      //dealing a deck into user provided hands.
      while (true)
      {
         Card dealedCards = null;
        
         // deal a deck into that many Hand objects,
         // dealing all cards until the deck is empty
         for (int i = 0; i < hands.length; i++)
         {
            dealedCards = deck.dealCard();
           
            if (dealedCards == null)
               break;
           
            // deal a single card to each hand, 
            // until all hands have one card, then repeat
            hands[i].takeCard(dealedCards);
         }
        
         if (dealedCards == null)
            break;
      }
     
      // output the unshuffled hands
      System.out.println();
      System.out.println("Here are the hands, from the unshuffled deck: ");
     
      for (int i = 0; i < hands.length; i++)
      {
         System.out.println("Hand = " + "( " + hands[i].toString() + " )");
         System.out.println();
      }
     
      // reset all the hands for second deal of same number of hands
      for (int i = 0; i < hands.length; i++)
      {
         hands[i].resetHand();
      }
     
      // initialize and shuffle the deck
      deck.init(1);
      deck.shuffle();
     
      // same loop as first deal
      while (true)
      {
         Card dealedCards = null;
        
         for (int i = 0; i < hands.length; i++)
        {
           dealedCards = deck.dealCard();
           
           if(dealedCards == null)
              break;
           
           hands[i].takeCard(dealedCards);
        }
        
        if (dealedCards == null)
           break;
      }
     
      // output the shuffled hands
      System.out.println();
      System.out.println("Here are the hands, from the SHUFFLED deck: ");
     
      for(int i = 0; i < hands.length; i++)
      {
         System.out.println("Hand = " + "( " + hands[i].toString() + " )");
         System.out.println();
      }
      
      input.close();
   } 
}
      

/**
 * Class that contains the members and methods of a playing card
 *
 * @author Team 1
 */
class Card
{
   private static final char DEFAULT_VALUE = 'A';
   private static final Suit DEFAULT_SUIT = Suit.spades; 
   
   /**
    * enum of Suits
    *
    */
   public static enum Suit
   {
      clubs, diamonds, hearts, spades;
   }
   
   private char value;
   private Suit suit;
   private boolean errorFlag;
   
   /**
    * Default Constructor for Card
    * Sets value = DEFAULT_VALUE, Suit = DEFAULT_SUIT
    * errorFlag set based on default constants
    *
    */
   public Card()
   {
      this.set(DEFAULT_VALUE, DEFAULT_SUIT); // default
   }
   
   /**
    * Constructor for Card with only errorFlag argument
    * Mainly used if errorFlag needs to be set
    * Sets value = DEFAULT_VALUE, Suit = DEFAULT_SUIT
    *
    */
   public Card( boolean errorFlag )
   {
      this.set(DEFAULT_VALUE, DEFAULT_SUIT); // default
      this.errorFlag = errorFlag;
   }
   
   /**
    * Constructor for Card
    * Sets value, Suit, and errorFlag based on arguments
    *
    * @param char value = set card value
    * @param Suit suit = set card suit
    */
   public Card( char value, Suit suit )
   {
      this.set(value, suit);
   }

   //Checks if the value is a digit (2 - 9) or (T(10), J, Q, K, A)
   /**
    * Constuctor for Card
    * Sets value, Suit, and errorFlag based on arguments
    *
    * @param char value = value to check
    * @param Suit suit = suit to check (does not check at this time)
    */
   private boolean isValid( char value, Suit suit )
   {
      String goodChars = "TJQKA";
      boolean valueGood = goodChars.contains(Character.toString(value));
      //no upper bound check necessary because 9 is the largest digit
      //that can be represented by a single character.
      if ((Character.isDigit(value) && value > 1) || valueGood)
      {
         return true;
      }
      return false;
   }

   /**
    * Accessor for value
    *
    * @return char value
    */
   public char getValue()
   {
      return this.value;
   }

   /**
    * Accessor for suit
    *
    * @return Suit suit
    */
   public Suit getSuit()
   {
      return this.suit;
   }

   /**
    * Accessor for errorFlag
    *
    * @return boolean errorFlag
    */
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }

   /**
    * Override method toString for Card object
    *
    * @return String (value + " of " + suit) or INVALID if errorFlag == true
    */
   @Override
   public String toString()
   {
      if (errorFlag)
      {
         return "[ INVALID ]";
      }
      return this.value + " of " + this.suit;
   }

   /**
    * Mutator for Card object
    * sets object.errorFlag based on validity
    *
    * @param char value = set card value
    * @param Suit suit = set card suit
    * @return Boolean based on success
    */
   public boolean set( char value, Suit suit )
   {
      this.value = value;
      this.suit = suit;
      if (!isValid(value, suit))
      {
         this.errorFlag = true;
         return false;
      }
      //if good values are passed, they are stored and errorFlag is set to false
      else
      {
         this.errorFlag = false;
         return true;
      }
   }

   /**
    * Method to test if two cards are equal
    *
    * @param Card card = card to test object against
    * @return Boolean true if equal, false otherwise
    */
   public boolean equals( Card card )
   {
      if (this.value == card.getValue() && this.suit == card.getSuit())
      {
         return true;
      }
      return false;
   }
}

/**
 * Class that contains the members and methods of a hand of playing cards
 *
 * @author Team 1
 */
class Hand
{
   public static final int MAX_CARDS = 51;
   
   private Card[] myCards;
   private int numCards;
   
   /**
    * Default Constructor for Hand
    * sets myCards = Card[MAX_CARDS]
    * sets numCards = 0
    *
    */
   public Hand()
   {
      this.resetHand();
   }
   
   /**
    * remove all cards from the hand
    *
    */
   public void resetHand()
   {
      // if myCards is not empty, properly empty it?
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   
   /**
    * adds a card to the next available position in the myCards array
    * 
    * @param Card card = card to add to hand
    * @return boolean based on success of method
    */
   public boolean takeCard(Card card)
   {
      if(numCards < MAX_CARDS)
      { 
         myCards[numCards++] = card;
         return true;
      }
      return false;
   }
   
   /**
    * returns and removes the card in the top occupied position of the array
    * 
    * @return Card cardToPlay
    */
   public Card playCard()
   {
      this.numCards--;
      return myCards[this.numCards];
   }
   
   /**
    * stringizer that the client can use to display the entire hand
    * 
    * @return String entireHand
    */
   public String toString()
   {
      if (this.numCards == 0)
      {
         return "Your hand is empty";
      }
      String entireHand = "";
      for (int i = 0; i < (this.numCards - 1); i++) 
      { 
         entireHand += this.myCards[i] + ", ";
      }
      // last card does not need ", " after
      entireHand += this.myCards[this.numCards - 1]; 
      return entireHand;
   }
   
   /**
    * Accessor for numCards
    * 
    * @return int numCards
    */
   public int getNumCards()
   {
      return this.numCards;
   }
   
   /**
    * Accessor for an individual card
    * Returns a card with errorFlag = true if k is bad
    * 
    * @return String entireHand
    */
   public Card inspectCard(int k)
   {
      if (k >= numCards)
      {
         // make card with errorFlag = true
         Card badCard = new Card(true);
         return badCard;
      }
      return myCards[k];
   }
}

/**
 * Class that contains the members and methods of deck(s) of playing cards
 *
 * @author Team 1
 */
class Deck
{
   /** Define a public final int value like MAX_CARDS, and initialize it to 
    * allow a maximum of six packs (6×52 cards).
    */
   public final int MAX_CARDS = 6 * 52;
   
   private static Card[] masterPack;
   private Card[] cards;
   private int topCard;
   private int numPacks;
   public static boolean haveAllocatedMasterPack = false;
   
/** constructors that populate the arrays and assigns initial values to
 *  members. Overload so that if no parameters are passed, 1 pack is assumed.
 */ 
   public Deck(int numPacks)
   {
      this.numPacks = numPacks;
      init(numPacks);
      allocateMasterPack();
   }
   
   public Deck()
   {
      this.numPacks = 1;
      init(numPacks);
      allocateMasterPack();
   }
      
  
   /** initialize and repopulate cards[]
    * 
    * @param numPacks
    */
   public void init(int numPacks)
   {
      this.numPacks = numPacks;
      getTopCard();
      
      if((topCard) <= MAX_CARDS && numPacks != 0)
      {
         cards = new Card[topCard];
         for(int k = 0; k < cards.length; k++)
            cards[k] = new Card();

         int cardNumber = 0;
         // re-populate cards[] with the standard 52 × numPacks cards
         while (numPacks > 0)
         {
            char[] cardVal = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 
                  'T', 'J', 'Q', 'K'};
            for (int i = 0; i < 4; i++)
            {
              for (int j = 0; j < cardVal.length; j++)
              {
                 cards[cardNumber] = new Card(cardVal[j],
                                              Card.Suit.values()[i]);
                 cardNumber++;
              }
            }
            numPacks--;
         }
      }
      else
         return;
   }
   
   /** shuffle cards[]
    */
   public void shuffle()
   {
      Random shuffling = new Random();
      for (int i = 0; i < cards.length; i++)
      {
         int randomPosition = shuffling.nextInt(cards.length);
         Card temp = cards[i];
         cards[i] = cards[randomPosition];
         cards[randomPosition] = temp;
      }
   }
   
   /** An accessor for the int, topCard (no mutator.)
    * @return topCard
    */
   public int getTopCard()
   {
      topCard = 52 * numPacks;
      return topCard;
   }
   
   /**
    * Accessor for an individual card
    * Returns a card with errorFlag = true if k is bad
    * 
    * @return String entireHand
    */
   public Card inspectCard(int k)
   {
      if (k >= topCard)
      {
         // make card with errorFlag = true
         Card badCard = new Card(true);
         return badCard;
      }
      return cards[k];
   }
   
   /** returns and removes the card in the top occupied position of cards[].
    * Make sure there are still cards available.
    * @return
    */
   public Card dealCard() 
   { 
      if(topCard == 0)
         return null;
      
      Card remCard = cards[topCard - 1];
      cards[topCard - 1] = null; 
      topCard--;
      
      return remCard;
   }
   
   /** this is a private method that will be called by the constructor;
    *  will not allow itself to be executed more than once
    */
   private static void allocateMasterPack()
   {
      if (haveAllocatedMasterPack)
         return;
      
      haveAllocatedMasterPack = true;
      
      // allocate masterPack
      masterPack = new Card[52];
      int cardNumber = 0;
      char[] cardVal = {'A', '2', '3', '4', '5', '6', '7',
         '8', '9', 'T', 'J', 'Q', 'K'};
      for (int i = 0; i < 4; i++)
      {
        for (int j = 0; j < cardVal.length; j++)
        {
           masterPack[cardNumber] = new Card(cardVal[j], Card.Suit.values()[i]);
           cardNumber++;
        }
      }
      
      /*for (int k = 0; k < masterPack.length; k++)
         System.out.print(masterPack[k] + " :: ");
         System.out.println("\n******************************************");*/
   }
}


/******************************OutPut****************************************
K of spades / Q of spades / J of spades / T of spades / 9 of spades / 8 of spade
s / 7 of spades / 6 of spades / 5 of spades / 4 of spades / 3 of spades / 2 of s
pades / A of spades / K of hearts / Q of hearts / J of hearts / T of hearts / 9 
of hearts / 8 of hearts / 7 of hearts / 6 of hearts / 5 of hearts / 4 of hearts 
/ 3 of hearts / 2 of hearts / A of hearts / K of diamonds / Q of diamonds / J of
 diamonds / T of diamonds / 9 of diamonds / 8 of diamonds / 7 of diamonds / 6 of
 diamonds / 5 of diamonds / 4 of diamonds / 3 of diamonds / 2 of diamonds / A of
 diamonds / K of clubs / Q of clubs / J of clubs / T of clubs / 9 of clubs / 8 o
f clubs / 7 of clubs / 6 of clubs / 5 of clubs / 4 of clubs / 3 of clubs / 2 of 
clubs / A of clubs / K of spades / Q of spades / J of spades / T of spades / 9 o
f spades / 8 of spades / 7 of spades / 6 of spades / 5 of spades / 4 of spades /
 3 of spades / 2 of spades / A of spades / K of hearts / Q of hearts / J of hear
ts / T of hearts / 9 of hearts / 8 of hearts / 7 of hearts / 6 of hearts / 5 of 
hearts / 4 of hearts / 3 of hearts / 2 of hearts / A of hearts / K of diamonds /
 Q of diamonds / J of diamonds / T of diamonds / 9 of diamonds / 8 of diamonds /
 7 of diamonds / 6 of diamonds / 5 of diamonds / 4 of diamonds / 3 of diamonds /
 2 of diamonds / A of diamonds / K of clubs / Q of clubs / J of clubs / T of clu
bs / 9 of clubs / 8 of clubs / 7 of clubs / 6 of clubs / 5 of clubs / 4 of clubs
 / 3 of clubs / 2 of clubs / A of clubs / 

Q of diamonds / 5 of clubs / 3 of diamonds / 8 of spades / 6 of spades / K of sp
ades / A of hearts / 6 of spades / 9 of hearts / J of spades / K of clubs / 9 of
 diamonds / 3 of clubs / 5 of spades / A of clubs / 4 of hearts / J of diamonds 
/ 4 of spades / 6 of hearts / T of hearts / 4 of clubs / 4 of diamonds / 9 of sp
ades / 6 of hearts / 8 of diamonds / 7 of hearts / T of spades / 3 of spades / 4
 of clubs / 6 of diamonds / 2 of spades / 6 of clubs / 8 of clubs / J of diamond
s / 6 of diamonds / 9 of clubs / 2 of clubs / 5 of clubs / 7 of clubs / K of clu
bs / A of spades / 7 of diamonds / 2 of hearts / K of diamonds / Q of clubs / 7 
of hearts / 5 of hearts / 5 of diamonds / 9 of diamonds / Q of diamonds / 6 of c
lubs / 9 of clubs / Q of hearts / 3 of spades / 4 of spades / 2 of diamonds / J 
of clubs / 5 of hearts / A of spades / J of hearts / Q of spades / 4 of hearts /
 3 of hearts / Q of spades / 7 of diamonds / 2 of clubs / T of hearts / A of dia
monds / K of hearts / T of diamonds / 9 of hearts / K of spades / 8 of spades / 
9 of spades / 8 of hearts / 5 of spades / K of diamonds / A of hearts / J of hea
rts / A of clubs / 3 of diamonds / Q of hearts / T of clubs / 3 of hearts / K of
 hearts / 7 of spades / 5 of diamonds / 8 of clubs / 7 of clubs / J of spades / 
2 of hearts / 8 of diamonds / T of spades / 7 of spades / 4 of diamonds / J of c
lubs / A of diamonds / Q of clubs / 2 of spades / T of diamonds / 2 of diamonds 
/ T of clubs / 3 of clubs / 8 of hearts / 


K of spades / Q of spades / J of spades / T of spades / 9 of spades / 8 of spade
s / 7 of spades / 6 of spades / 5 of spades / 4 of spades / 3 of spades / 2 of s
pades / A of spades / K of hearts / Q of hearts / J of hearts / T of hearts / 9 
of hearts / 8 of hearts / 7 of hearts / 6 of hearts / 5 of hearts / 4 of hearts 
/ 3 of hearts / 2 of hearts / A of hearts / K of diamonds / Q of diamonds / J of
 diamonds / T of diamonds / 9 of diamonds / 8 of diamonds / 7 of diamonds / 6 of
 diamonds / 5 of diamonds / 4 of diamonds / 3 of diamonds / 2 of diamonds / A of
 diamonds / K of clubs / Q of clubs / J of clubs / T of clubs / 9 of clubs / 8 o
f clubs / 7 of clubs / 6 of clubs / 5 of clubs / 4 of clubs / 3 of clubs / 2 of 
clubs / A of clubs / 

K of diamonds / K of hearts / Q of clubs / T of hearts / J of diamonds / 5 of cl
ubs / Q of hearts / 4 of diamonds / 8 of spades / 6 of spades / A of diamonds / 
A of clubs / 8 of clubs / 2 of hearts / 2 of diamonds / 6 of diamonds / 7 of clu
bs / A of hearts / 3 of hearts / 7 of spades / 3 of diamonds / 3 of spades / 2 o
f clubs / A of spades / 9 of hearts / 6 of hearts / 5 of spades / 9 of diamonds 
/ 4 of spades / J of clubs / T of diamonds / T of spades / 8 of hearts / 2 of sp
ades / 7 of diamonds / Q of spades / Q of diamonds / J of spades / 8 of diamonds
 / K of spades / J of hearts / 3 of clubs / K of clubs / 9 of clubs / 6 of clubs
 / 7 of hearts / 4 of hearts / 4 of clubs / 9 of spades / T of clubs / 5 of hear
ts / 5 of diamonds / 


How many hands? (1 - 10, please): 
5

Here are the hands, from the unshuffled deck: 
Hand = ( K of spades, 8 of spades, 3 of spades, J of hearts, 6 of hearts, A of h
earts, 9 of diamonds, 4 of diamonds, Q of clubs, 7 of clubs, 2 of clubs )

Hand = ( Q of spades, 7 of spades, 2 of spades, T of hearts, 5 of hearts, K of d
iamonds, 8 of diamonds, 3 of diamonds, J of clubs, 6 of clubs, A of clubs )

Hand = ( J of spades, 6 of spades, A of spades, 9 of hearts, 4 of hearts, Q of d
iamonds, 7 of diamonds, 2 of diamonds, T of clubs, 5 of clubs )

Hand = ( T of spades, 5 of spades, K of hearts, 8 of hearts, 3 of hearts, J of d
iamonds, 6 of diamonds, A of diamonds, 9 of clubs, 4 of clubs )

Hand = ( 9 of spades, 4 of spades, Q of hearts, 7 of hearts, 2 of hearts, T of d
iamonds, 5 of diamonds, K of clubs, 8 of clubs, 3 of clubs )


Here are the hands, from the SHUFFLED deck: 
Hand = ( A of clubs, J of diamonds, 7 of spades, 4 of clubs, 8 of clubs, 4 of sp
ades, 9 of spades, 7 of diamonds, K of clubs, 8 of spades, 5 of hearts )

Hand = ( 3 of clubs, 3 of spades, 3 of hearts, 9 of clubs, 6 of hearts, A of dia
monds, T of hearts, Q of spades, Q of clubs, Q of diamonds, 3 of diamonds )

Hand = ( J of clubs, 2 of clubs, 2 of diamonds, A of hearts, Q of hearts, 4 of d
iamonds, 9 of diamonds, 6 of diamonds, 6 of clubs, 7 of hearts )

Hand = ( K of diamonds, K of hearts, T of spades, J of spades, A of spades, 5 of
 spades, T of clubs, 5 of diamonds, 9 of hearts, 5 of clubs )

Hand = ( T of diamonds, 4 of hearts, 2 of hearts, J of hearts, 8 of hearts, 8 of
 diamonds, 2 of spades, K of spades, 7 of clubs, 6 of spades )

****************************************************************************/
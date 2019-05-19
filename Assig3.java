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
      testCardClass();
      testHandClass();
   }

   /**
    * Runs the tests required to confirm Phase 1
    *
    */
   private static void testCardClass()
   {
      System.out.println("Testing Phase 1");
      // instantiate three cards, two legally, and one illegally 
      Card card1 = new Card();
      Card card2 = new Card('Z', Card.Suit.diamonds);
      Card card3 = new Card('Q', Card.Suit.hearts);
      printThreeCards(card1, card2, card3);
      
      // make good card bad by set() with an illegal value, and second card vice versa
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
      System.out.println("Testing playCard()");
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
      System.out.println("Testing inspectCard()");
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
      else // if good values are passed, they are stored and errorFlag is set to false
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
      Card newCard = new Card();
      if (newCard.set(card.getValue(), card.getSuit()))
      {
         this.myCards[this.numCards] = newCard;
         this.numCards++;
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
      this.masterPack = new Card[52];
      allocateMasterPack();
      haveAllocatedMasterPack = true;
   }
   
   public Deck()
   {
      this.numPacks = 1;
      init(numPacks);
      this.masterPack = new Card[52];
      allocateMasterPack();
      haveAllocatedMasterPack = true;
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
         
         // re-populate cards[] with the standard 52 × numPacks cards
         for(int k = 0; k < numPacks; k++)
         {
            for(int i = (52 * k), j = 0; i < (52 * k + 52); i++, j++)
            {
               cards[i] = masterPack[j];
            }
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
      topCard-- ;
      
      return remCard;
   }
   
   /** this is a private method that will be called by the constructor; will not 
    *  allow itself to be executed more than once
    */
   private static void allocateMasterPack()
   {
      int m, n, i;
      char value;
      Card.Suit suit;
      
      if (haveAllocatedMasterPack)
         return;
      
      haveAllocatedMasterPack = true;
      
      // allocate masterPack
      masterPack = new Card[52];
      
      for (m = 0; m < 52; m++)
        masterPack[m] = new Card();
      
      i = 52 / 4; // number of values per suit
      
      for (m = 0; m < 4; m++)
      {
        suit = Card.Suit.values()[m];
        
        // set all the values for the suit defined
        // start with number cards
        for (value = '2', n = 1; value <= 9; value++, n++)
          masterPack[i * m + n] .set(value, suit);
        
        // set Letter cards
        masterPack[i * m + 9].set('T', suit);
        masterPack[i * m + 10].set('J', suit);
        masterPack[i * m + 11].set('Q', suit);
        masterPack[i * m + 12].set('K', suit);
        masterPack[i * m].set('A', suit);
      }
   }
}
/* Team 1
 * Austin Ah Loo
 * Ramon Lucindo
 * Mikie Reed
 * Mitchell Saunders
 * Nick Saunders
 * CST 338 - Module 3: Deck of Cards
 */

/** PHASE 1 **/

// import java.*;

public class Assig3 {

  public static void main(String[] args)
  {
	// instantiate three cards, two legally, and one illegally 
	Card card1 = new Card();
	Card card2 = new Card('Z', Card.Suit.diamonds);
	Card card3 = new Card('Q', Card.Suit.hearts);
	
	// Print all three out and confirm
    System.out.println("/* -------------------------------------------------------");
    System.out.println(card1.toString());
    System.out.println(card2.toString());
    System.out.println(card3.toString());
    
    // make good card bad by set() with an illegal value, and second card vice versa
    card1.set('X', Card.Suit.clubs);
    card2.set('T', Card.Suit.diamonds);
    
    // Print all three out and confirm
    System.out.println("");
    System.out.println(card1.toString());
    System.out.println(card2.toString());
    System.out.println(card3.toString());
    System.out.println("--------------------------------------------------------*/");

  }

}

// Card class definition
class Card
{
  // enum Suit definition
  public enum Suit
  {
    clubs, diamonds, hearts, spades;
  }
  
  // Card class variables
  private char value;
  private Suit suit;
  private boolean errorFlag;
  
  // constructors with the required member parameters, or no parameters(default settings)
  public Card()
  {
    this('A', Suit.spades);
  }
  
  public Card( char value, Suit suit )
  {
    // set error flag to true if 
	if (!isValid(value, suit))
	  this.errorFlag = true;
	else
	  this.errorFlag = false;
	// call mutators for card properties
	//setValue(value);
	//setSuit(suit);
	this.value = value;
	this.suit = suit;
	//this.errorFlag = false;
	
  }
  
//Checks if the value is a digit (2 - 9) or (T(10), J, Q, K, A)
  private boolean isValid( char value, Suit suit )
  {
    if ((Character.isDigit(value) && value != '0' && value != '1') || value == 'T' || value == 'J' || 
    		value == 'Q' || value == 'K' || value == 'A')
    	
      return true;
    
    return false;
  }
  
  public char getValue()
  {
    return this.value;
  }
  
  /* MUTATOR NOT NEEDED
  public void setValue( char value )
  {
    if (!isValid(value, suit))
      throw new RuntimeException("Invalid value provided.");
    this.value = value;
      
  }
  */
  public Suit getSuit()
  {
    return this.suit;
  }
  /* MUTATOR NOT NEEDED
  public void setSuit( Suit suit )
  {
    if (suit == null)
      throw new RuntimeException("Suit cannot be empty.");
    this.suit = suit;
  }
  */
  public boolean getErrorFlag()
  {
    return this.errorFlag;
  }
  
  @Override
  public String toString()
  {
    if (errorFlag)
      return "INVALID";
    
    return this.value + " of " + this.suit;
  }
  
  // mutator that accepts the legal values established in the earlier section
  public boolean set( char value, Suit suit )
  {
    this.value = value;
    this.suit = suit;
    
    // When bad values are passed, errorFlag is set to true
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
  
  // returns true if all the fields (members) are identical and false, otherwise
  public boolean equals( Card card )
  {
    if (this.value == card.getValue() && this.suit == card.getSuit() && this.errorFlag == card.getErrorFlag())
      return true;
    else
      return false;
  }
  
}



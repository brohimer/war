/**
* The Card class creates a playing card with a value and suit.
* @author Curren Taber
*/

public class Card
{
  private String m_value;
  private String m_suit;

  /**
  * Default constructor for making a Card object
  */
  public Card()
  {
    m_value = "0";
    m_suit = "0";
  }

  /**
  * Overloaded constructor for making a Card object
  * @param v Card value
  * @param s Card suit
  */
  public Card(String v, String s)
  {
    m_value = v;
    m_suit = s;
  }

  /**
  * Copy constructor for making a Card object
  * @param c Card object
  */
  public Card(Card c)
  {
    m_value = c.m_value;
    m_suit = c.m_suit;
  }

  /**
  * Accessor for value attribute
  * @return Returns the Card value
  */
  public String getValue()
  {
    return m_value;
  }

  /**
  * Accessor for suit attribute
  * @return Returns the Card suit
  */
  public String getSuit()
  {
    return m_suit;
  }

  /**
  * This method returns a String.
  * @return Returns a String containing the Card value and suit
  */
  public String toString()
  {
    return "(Value: " + m_value + ", Suit: " + m_suit + ")";
  }

  /**
  * This method compares the value and suit of two Cards.
  * @param c Card object
  * @return Returns true if the Cards are equivalent
  */
  public boolean equals(Card c)
  {
    return m_value == c.m_value && m_suit == c.m_suit;
  }
}

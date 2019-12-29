import java.util.LinkedList;

/**
* The Player class creates a Player with its own Deck
* @author Curren Taber
*/

public class Player
{
  private int m_number;
  private LinkedList<Card> m_deck;
  private int m_lengthOfList;

  /**
  * Default constructor for making a Player object
  */
  public Player()
  {
    m_number = 0;
    m_deck = new LinkedList<Card>();
    m_lengthOfList = m_deck.size();
  }

  /**
  * Overloaded constructor for making a Player object
  * @param n The Player number (1 or 2)
  */
  public Player(int n)
  {
    m_number = n;
    m_deck = new LinkedList<Card>();
    m_lengthOfList = m_deck.size();
  }

  /**
  * Copy constructor for making a Player object
  * @param p Player object
  */
  public Player(Player p)
  {
    m_number = p.m_number;
    m_deck = p.m_deck;
    m_lengthOfList = p.m_lengthOfList;
  }

  /**
  * Accessor for the Player's number (1 or 2)
  * @return Returns the Player's number
  */
  public int getNumber()
  {
    return m_number;
  }

  /**
  * Accessor for the list of cards in a Player's Deck
  * @return Returns the list of cards
  */
  public LinkedList<Card> getDeck()
  {
    return m_deck;
  }

  /**
  * Accessor for a specific card in a Player's Deck
  * @param n Index of the Card
  * @return Returns the Card
  */
  public Card getCard(int n)
  {
    return m_deck.get(n);
  }

  /**
  * Accessor for the amount of cards in a Player's Deck
  * @return Returns the amount of cards in the deck
  */
  public int getLength()
  {
    return m_lengthOfList;
  }

  /**
  * This method removes and returns the first card from a Player's Deck. If
  * the Deck is empty, an empty card (Value: 0, Suit: 0) is returned.
  * @return Returns a Card
  */
  public Card flip()
  {
    if (getLength() > 0)
    {
      Card temp = m_deck.get(0);
      m_deck.remove(0);
      m_lengthOfList = m_deck.size();
      return temp;
    }
    else
    {
      Card temp = new Card();
      return temp;
    }
  }

  /**
  * This method adds a Card to the end of a Player's Deck and adjusts the
  * length of the Deck.
  * @param c Card object
  */
  public void collect(Card c)
  {
    m_deck.add(c);
    m_lengthOfList = m_deck.size();
  }

  /**
  * This method determines if a Player has won.
  * @return Returns true if the player has won
  */
  public boolean hasWon()
  {
    return m_lengthOfList == 52;
  }

  /**
  * This method checks the length of the Player's Deck and returns between
  * 0 and 4 cards for a war against the other Player.
  * @return Returns a LinkedList of Cards
  */
  public LinkedList<Card> war()
  {
    LinkedList<Card> temps = new LinkedList<Card>();
    switch(m_lengthOfList)
    {
      case 0:
        Card temp = new Card();
        temps.add(temp);
        break;
      case 1:
        temps.add(flip());
        break;
      case 2:
        temps.add(flip());
        temps.add(flip());
        break;
      case 3:
        temps.add(flip());
        temps.add(flip());
        temps.add(flip());
        break;
      default:
        for (int x = 0; x < 4; x++)
        {
          temps.add(flip());
        }
        break;
    }
    return temps;
  }
}

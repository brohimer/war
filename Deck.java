import java.util.LinkedList;
import java.util.Random;

/**
* The Deck class creates a Deck of 52 Cards.
* @author Curren Taber
*/

public class Deck
{
  private LinkedList<Card> m_listOfCards;
  private static String[] m_arrayOfValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};;
  private String[] m_arrayOfSuits = {"C", "D", "H", "S"};;
  private int m_lengthOfList;

  /**
  * Default constructor for making a Deck object
  */
  public Deck()
  {
    m_listOfCards = new LinkedList<Card>();
    for (String s : m_arrayOfSuits)
    {
      for (String v : m_arrayOfValues)
      {
        Card c = new Card(v, s);
        m_listOfCards.add(c);
      }
    }
    m_lengthOfList = m_listOfCards.size();
  }

  /**
  * Copy constructor for making a Deck object
  * @param d Deck object
  */
  public Deck(Deck d)
  {
    m_listOfCards = d.m_listOfCards;
    m_lengthOfList = d.m_lengthOfList;
  }

  /**
  * Accessor for the list of cards in the Deck
  * @return Returns a list of cards
  */
  public LinkedList<Card> getCards()
  {
    return m_listOfCards;
  }

  /**
  * Accessor for the length of the list of Cards in the Deck
  * @return Returns the length of the list
  */
  public int getLength()
  {
    return m_lengthOfList;
  }

  /**
  * This method picks a random Card from the Deck, removes that Card,
  * and adjusts the length of the Deck.
  * @return Returns a random card from the Deck
  */
  public Card deal()
  {
    Random randomGenerator = new Random();
    int i = randomGenerator.nextInt(m_lengthOfList);
    Card temp = m_listOfCards.get(i);
    m_listOfCards.remove(i);
    m_lengthOfList = m_listOfCards.size();
    return temp;
  }

  /**
  * This method returns an array of universal Card values.
  * @return Returns the array of Card values
  */
  public static String[] getOrder()
  {
    String[] temp = new String[m_arrayOfValues.length];
    for (int x = 0; x < m_arrayOfValues.length; x++)
    {
      temp[x] = m_arrayOfValues[x];
    }
    return temp;
  }
}

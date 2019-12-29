import java.util.LinkedList;
import java.util.Collections;

/**
* The Game class creates a game of War with two Players.
* @author Curren Taber
*/

public class Game
{
  private Player m_p1;
  private Player m_p2;
  private int m_numBattles;
  private int m_numWars;
  private int m_numDoubleWars;

  /**
  * Default constructor for making a Game object
  */
  public Game()
  {
    m_p1 = new Player(1);
    m_p2 = new Player(2);
    m_numBattles = 0;
    m_numWars = 0;
    m_numDoubleWars = 0;
  }

  /**
  * Copy constructor for making a Game object
  * @param g Game object
  */
  public Game(Game g)
  {
    m_p1 = g.m_p1;
    m_p2 = g.m_p2;
    m_numBattles = g.m_numBattles;
    m_numWars = g.m_numWars;
    m_numDoubleWars = g.m_numDoubleWars;
  }

  /**
  * Accessor for Player 1
  * @return Returns a Player object for Player 1
  */
  public Player getPlayer1()
  {
    return m_p1;
  }

  /**
  * Accessor for Player 2
  * @return Returns a Player object for Player 2
  */
  public Player getPlayer2()
  {
    return m_p2;
  }

  /**
  * Accessor for the numbers of battles in the Game
  * @return Returns the number of battles
  */
  public int getNumBattles()
  {
    return m_numBattles;
  }

  /**
  * Accessor for the numbers of wars in the Game
  * @return Returns the number of wars
  */
  public int getNumWars()
  {
    return m_numWars;
  }

  /**
  * Accessor for the numbers of double wars in the Game
  * @return Returns the number of double wars
  */
  public int getNumDoubleWars()
  {
    return m_numDoubleWars;
  }

  private void gBattle()
  {
    m_numBattles++;
    Card c1 = m_p1.flip();
    Card c2 = m_p2.flip();
    int v1 = -1;
    int v2 = -1;

    for (int x = 0; x < Deck.getOrder().length; x++)
    {
      if (c1.getValue().equalsIgnoreCase(Deck.getOrder()[x]))
      {
        v1 = x;
      }
      if (c2.getValue().equalsIgnoreCase(Deck.getOrder()[x]))
      {
        v2 = x;
      }
    }

    if (v1 == -1)
    {
      m_p2.collect(c2);
    }
    else if (v2 == -1)
    {
      m_p1.collect(c1);
    }
    else if (v1 > v2)
    {
      m_p1.collect(c1);
      m_p1.collect(c2);
    }
    else if (v2 > v1)
    {
      m_p2.collect(c1);
      m_p2.collect(c2);
    }
    else
    {
      LinkedList<Card> newList = new LinkedList<Card>();
      newList.add(c1);
      newList.add(c2);
      gWar(newList);
    }
  }

  private void gWar(LinkedList<Card> list)
  {
    m_numWars++;
    LinkedList<Card> anotherList = new LinkedList<Card>(list);
    LinkedList<Card> list1 = new LinkedList<Card>(m_p1.war());
    LinkedList<Card> list2 = new LinkedList<Card>(m_p2.war());
    Card c1 = list1.getLast();
    Card c2 = list2.getLast();
    int v1 = -1;
    int v2 = -1;

    anotherList.addAll(list1);
    anotherList.addAll(list2);
    Collections.shuffle(anotherList);

    for (int x = 0; x < Deck.getOrder().length; x++)
    {
      if (c1.getValue().equalsIgnoreCase(Deck.getOrder()[x]))
      {
        v1 = x;
      }
      if (c2.getValue().equalsIgnoreCase(Deck.getOrder()[x]))
      {
        v2 = x;
      }
    }
    if (v1 == -1)
    {
      for (int x = 0; x < anotherList.size(); x++)
      {
        m_p2.collect(anotherList.get(x));
      }
    }
    else if (v2 == -1)
    {
      for (int x = 0; x < anotherList.size(); x++)
      {
        m_p1.collect(anotherList.get(x));
      }
    }
    else if (v1 > v2)
    {
      for (int x = 0; x < anotherList.size(); x++)
      {
        m_p1.collect(anotherList.get(x));
      }
    }
    else if (v2 > v1)
    {
      for (int x = 0; x < anotherList.size(); x++)
      {
        m_p2.collect(anotherList.get(x));
      }
    }
    else
    {
      m_numDoubleWars++;
      gWar(anotherList);
    }
  }

  /**
  * This method executes a full game between the two Players
  */
  public void play()
  {
    Deck d = new Deck();
    for (int x = 0; x < 26; x++)
    {
      m_p1.collect(d.deal());
      m_p2.collect(d.deal());
    }
    while (m_p1.hasWon() == false && m_p2.hasWon() == false)
    {
      gBattle();
    }
  }
}

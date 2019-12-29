/**
* The Simulation class simulates a specified number of War games and calculates
* the statistics from those games.
* @author Curren Taber
*/

public class Simulation
{
  private int m_totalBattles;
  private int m_totalWars;
  private int m_totalDoubleWars;
  private double m_avgBattles;
  private double m_avgWars;
  private double m_avgDoubleWars;
  private int m_maxBattles;
  private int m_minBattles;
  private int m_maxWars;
  private int m_minWars;
  private int m_numGames;

  /**
  * Default Constructor for making a Simulation object
  */
  public Simulation()
  {
    m_numGames = 1;
    m_totalBattles = 0;
    m_totalWars = 0;
    m_totalDoubleWars = 0;
    m_avgBattles = 0;
    m_avgWars = 0;
    m_avgDoubleWars = 0;
    m_maxBattles = 0;
    m_minBattles = 0;
    m_maxWars = 0;
    m_minWars = 0;
  }

  /**
  * Overloaded Constructor for making a Simulation object
  * @param n Number of games to simulate
  */
  public Simulation(int n)
  {
    m_numGames = n;
    m_totalBattles = 0;
    m_totalWars = 0;
    m_totalDoubleWars = 0;
    m_avgBattles = 0;
    m_avgWars = 0;
    m_avgDoubleWars = 0;
    m_maxBattles = 0;
    m_minBattles = 0;
    m_maxWars = 0;
    m_minWars = 0;
  }

  /**
  * This method executes the specified number of games of War.
  */
  public void simulate()
  {
    for (int x = 0; x < m_numGames; x++)
    {
      Game game = new Game();
      game.play();
      m_totalBattles += game.getNumBattles();
      m_totalWars += game.getNumWars();
      m_totalDoubleWars += game.getNumDoubleWars();

      if (x == 0)
      {
        m_maxBattles = game.getNumBattles();
        m_minBattles = game.getNumBattles();
        m_maxWars = game.getNumWars();
        m_minWars = game.getNumWars();
      }
      if (game.getNumBattles() > m_maxBattles)
      {
        m_maxBattles = game.getNumBattles();
      }
      if (game.getNumBattles() < m_minBattles)
      {
        m_minBattles = game.getNumBattles();
      }
      if (game.getNumWars() > m_maxWars)
      {
        m_maxWars = game.getNumWars();
      }
      if (game.getNumWars() < m_minWars)
      {
        m_minWars = game.getNumWars();
      }
    }
  }

  /**
  * This method calculates the averages for certain statistics from the games.
  */
  public void calculate()
  {
    m_avgBattles = m_totalBattles/m_numGames;
    m_avgWars = m_totalWars/m_numGames;
    m_avgDoubleWars = m_totalDoubleWars/m_numGames;
  }

  /**
  * This method provides the statistics from the simulation.
  * @return Returns a String of the statistics.
  */
  public String report()
  {
    String s = "------------\n";
    s += "Average number of battles per game: " + m_avgBattles + "\n";
    s += "Average number of wars per game: " + m_avgWars + "\n";
    s += "Average number of double wars per game: " + m_avgDoubleWars + "\n";
    s += "Max number of battles in a game: " + m_maxBattles + "\n";
    s += "Min number of battles in a game: " + m_minBattles + "\n";
    s += "Max number of wars in a game: " + m_maxWars + "\n";
    s += "Min number of wars in a game: " + m_minWars + "\n";
    return s;
  }

  /**
  * This is the main method for running the Simulation.
  * @param args[0] Integer number of games to simulate
  */
  public static void main(String[] args)
  {
    int n = Integer.parseInt(args[0]);
    Simulation s = new Simulation(n);
    s.simulate();
    s.calculate();
    System.out.println(s.report());
  }
}

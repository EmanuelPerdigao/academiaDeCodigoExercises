public class Player
{

    private int guess;
    private String name;

    public int guessNumber (int guess)
    {
        this.guess = guess;
        System.out.println("Player "+this.name+" guessed: "+ guess);
        return guess;
    }

    public Player(String player)
    {
        this.name = player;
    }

    public String getName()
    {
        return this.name;
    }

}

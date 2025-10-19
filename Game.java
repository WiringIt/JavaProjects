import java.util.Scanner;
public class Game
{
  public static void GuessingGame()
  {
    Scanner sc=new Scanner(System.in);
    int number=1+(int)(100*Math.random());
    int attempts=0;
    int maxattempt=5;
    boolean guessedcorrectly=false;
    System.out.println("A number has been chosen between 1 and 100");
    System.out.println("You have "+maxattempt+" attempts to guess the correct number");
    while(!guessedcorrectly)
    {
        for(int i=0;i<maxattempt;i++)
        {
            System.out.println("Enter your guess: ");
            int guess=sc.nextInt();
            attempts++;
            if(guess==number)
            {
               System.out.println("You guess the correct number in "+ attempts+ " attempts!");
               guessedcorrectly=true;
               break;
            }
            else if(guess<number)
            {
                System.out.println("The number is greater than "+ guess);
            }
            else 
            {
                System.out.println("The number is less than " + guess);
            }
        }
        if(!guessedcorrectly)
        {
            System.out.println("You have used all "+maxattempt+" attempts");
            System.out.println("Wanna continue?(Y/N)");
            char response=sc.next().charAt(0);
            if(response=='N'||response=='n')
            {
                System.out.println("Game over! Correct number: "+number);
                break;
            }
        }
    }
    sc.close();
}
public static void main(String[] args)
{
    GuessingGame();
}
}

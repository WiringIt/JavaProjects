import java.util.*;
public class TicTacToe {
    static String[] board;
    static String turn;
    static String checkWinner()
    {
        for(int a=0;a<8;a++)//checking for winning conditions
        //3 rows,3 cols, 2 diagonals thus 8 possibilities
        {
            String line=null;
            switch(a)
            {
                case 0: 
                line=board[0]+board[1]+board[2];
                break;
                case 1:
                line=board[3]+board[4]+board[5];
                break;
                case 2:
                line=board[6]+board[7]+board[8];
                break;
                case 3:
                line=board[0]+board[3]+board[6];
                break;
                case 4:
                line=board[1]+board[4]+board[7];
                break;
                case 5:
                line=board[2]+board[5]+board[8];
                break;
                case 6:
                line=board[0]+board[4]+board[8];
                break;
                case 7:
                line=board[2]+board[4]+board[6];
                break;
            }
            if(line.equals("XXX"))
            {return "X";}
            else if(line.equals("OOO"))
            {return "O";}
        }
        for(int a=0;a<9;a++)//check for draw
        {
            if(Arrays.asList(board).contains(String.valueOf(a+1)))
            //Arrays.asList(board) temporarily wraps the board array into a List object, giving us access to the handy .contains() method just for that one line of code.
            {
                break;
            }
            else if(a==8)
            {return "Draw";}
        }
    System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }
public static void main(String[] args)
{
  Scanner in=new Scanner(System.in);
  board=new String[9];
  turn="X";
  String winner=null;
  for(int a=0;a<9;a++)
  {
    board[a]=String.valueOf(a+1);
  }
  System.out.println("Hi there! I'm Sammie :P Welcome to 3x3 Tic Tac Toe.");
  printBoard();
  System.out.println("X will play first. Enter a slot number to place X in:");
  while(winner==null)
  {
    int num;
    try
    {
        num=in.nextInt();
        if(!(num>0 && num<=9))
        {
        System.out.println("Invalid input; re-enter slot number:");
        continue;
        }
        if(board[num-1].equals(String.valueOf(num)))
        {
        board[num-1]=turn;
        turn=turn.equals("X")?"O":"X";
        printBoard();
        winner=checkWinner();
        }
        else
        {
        System.out.println("Slot already taken; re-enter slot number:");
        }
    }
    catch(InputMismatchException e)
    {
        System.out.println("Invalid input; re-enter slot number:");
        in.nextLine();
    }
  } 
  if(winner.equals("Draw"))
  {
    System.out.println("It's a draw!");
  }
  else
  {
    System.out.println(winner + " wins!");
  }
  in.close();
}
}
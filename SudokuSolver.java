public class SudokuSolver
{
   int[] board;
   int counter;

   public SudokuSolver()
   {
      board = new int[81];
   }

   public int[] solve(int[] board)
   {
      counter = 0;
      long timeStart = System.currentTimeMillis();
      solve(0, board);
      toString(board);
      long timeFinish = System.currentTimeMillis();

      double time = (timeFinish - timeStart);
      time /= 1000;
      if (time >= 3600)
      {
         int hours = (int) (time / 3600);
         time = time % 3600;
         System.out.println("Time spent: " + hours + " h, " + (int) time / 60
               + " m, " + time % 60 + " s");
      }
      else if (time >= 60)
         System.out.println("Time spent: " + (int) time / 60 + " m, " + time
               % 60 + " s");
      else if (time >= 1)
         System.out.println("Time spent: " + time + " s");
      else
         System.out.println("Time spent: " + time * 1000 + " ms");

      return counter == 1 ? this.board : null;
   }

   private void solve(int pos, int[] board)
   {
      if (counter > 1)
         return;
      while (pos == board.length || board[pos] != 0)
      {
         if (pos == board.length)
         {
            for (int i = 0; i < board.length; i++)
               this.board[i] = board[i];
            counter++;
            return;
         }
         pos++;
      }

      for (int number = 1; number < 10; number++)
      {
         if (validNumber(pos, number, board))
         {
            board[pos] = number;

            solve(pos + 1, board);

            board[pos] = 0;
         }
      }
   }

   private boolean validNumber(int pos, int number, int[] board)
   {
      return validBox(pos, number, board) && validRow(pos, number, board)
            && validColumn(pos, number, board);
   }

   private boolean validRow(int pos, int number, int[] board)
   {
      for (int i = 9 * (pos / 9); i < 9 * (pos / 9) + 9; i++)
         if (i != pos && board[i] == number)
            return false;
      return true;
   }

   private boolean validColumn(int pos, int number, int[] board)
   {
      for (int j = pos % 9; j < board.length; j += 9)
         if (j != pos && board[j] == number)
            return false;
      return true;
   }

   private boolean validBox(int pos, int number, int[] board)
   {
      int check = 3 * (pos / 3);
      boolean b = true;

      do
      {
         switch (check)
         {
            case 0:
            case 3:
            case 6:
            case 27:
            case 30:
            case 33:
            case 54:
            case 57:
            case 60:
               b = false;
               break;
            default:
               check -= 9;
         }
      }
      while (b);

      for (int i = 0; i < 3; i++)
      {
         for (int j = 0; j < 3; j++)
         {
            if (check != pos && board[check] == number)
               return false;
            check++;
         }
         check += 6;
      }
      return true;
   }

   public boolean check(int[] board)
   {
      for (int i = 0; i < board.length; i++)
         if (!validNumber(i, board[i], board))
            return false;
      return true;
   }

   private void toString(int[] matrix)
   {
      int x = 0;

      for (int i = 0; i < 9; i++)
      {
         for (int j = 0; j < 9; j++)
            System.out.print(matrix[x] + " ");

         System.out.println();
      }
   }
}
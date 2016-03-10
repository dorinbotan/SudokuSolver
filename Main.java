public class Main
{
   public static void main(String[] args)
   {
      int[] matrix = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

      // Empty
      solve(matrix);
   }

   private static void solve(int[] matrix)
   {
      SudokuSolver solver = new SudokuSolver();
      int[] tmp;

      long timeStart = System.currentTimeMillis();
      tmp = solver.solve(matrix);
      long timeStop = System.currentTimeMillis();

//      System.out.println(tmp[1]);
//      toString(tmp);

      double time = (timeStop - timeStart) / (double) 1000;
      System.out.println("Time spent: "
            + (time >= 1 ? time + " s" : time * 1000 + " ms"));
      System.out.println();
   }

   private static void toString(int[] matrix)
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
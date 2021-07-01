// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class MinDominoRotations {
   /*
  Return min number of rotations 
  if one could make all elements in A or B equal to x.
  Else return -1.
  */
  public int check(final int x, final int[] A, final int[] B, final int n) {
      // how many rotations should be done
      // to have all elements in A equal to x
      // and to have all elements in B equal to x
      int rotations_a = 0, rotations_b = 0;
      for (int i = 0; i < n; i++) {
          // rotations coudn't be done
          if (A[i] != x && B[i] != x)
              return -1;
          // A[i] != x and B[i] == x
          else if (A[i] != x)
              rotations_a++;
          // A[i] == x and B[i] != x
          else if (B[i] != x)
              rotations_b++;
      }
      // min number of rotations to have all
      // elements equal to x in A or B
      return Math.min(rotations_a, rotations_b);
  }

  public int minDominoRotations(final int[] A, final int[] B) {
      int maxFreq = 0;

      for (int i = 1; i < 7; i++) {
          int freq = 0;
          for (int j = 0; j < A.length; j++) {
              if (i == A[j]) {
                  freq++;
              }
              if (i == B[j]) {
                  freq++;
              }
              if (freq >= A.length) {
                  maxFreq = i;
                  break;
              }
          }
      }
      return check(maxFreq, A, B, A.length);
  }

  public static void main(final String args[]) {
      final int A[] = { 3, 5, 1, 2, 3 };
      final int B[] = { 3, 6, 3, 3, 4 };

      final MinDominoRotations rotations = new MinDominoRotations();

      System.out.println(rotations.minDominoRotations(A, B));

  }
}
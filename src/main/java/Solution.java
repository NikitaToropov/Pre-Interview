public class Solution {
  /**
   * Дан массив чисел. Найдите 2 числа, сумма которых равна target.
   * Верните индексы этих чисел
   * <p>
   * Пример:
   * nums = new int{2, 7, 11, 15};
   * target = 9
   * result = {0, 1}
   * <p>
   * nums = new int{3,2,4};
   * target = 6
   * result = {1, 2}
   * <p>
   * nums = new int{3,3};
   * target = 6
   * result = {0, 1}
   *
   * @param nums   массив с числами
   * @param target то, чему должна быть равна сумма двух чисел
   * @return массив из двух индексов
   */
  public int[] twoSum(int[] nums, int target) {
    if (nums != null) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          try {
            int sum = Math.addExact(nums[i], nums[j]);
            if (sum == target) {
              return new int[] {i, j};
            }
          } catch (ArithmeticException ignore) {}
        }
      }
    }
    return new int[0];
  }


  /**
   * На вход даны два числа. Длина и Ширина будущего массива.
   * Заполните массив по спирали начиная с координат[0][0]
   * Пример:
   * length = 3, width = 3
   * Результат:
   * 1 2 3
   * 8 9 4
   * 7 6 5
   *
   * @param length длина получившегося массива
   * @param width ширина получившегося массива
   * @return заполненный массив
   */
  public int[][] fill(int length, int width) {
    int[][] matrix;
    if (width <= 0 || length <= 0) {
      return new int[0][0];
    }
    try {
      matrix = new int[width][length];
    } catch (OutOfMemoryError e) {
      return new int[0][0];
    }
    int lastElement = length * width;
    int t = 0;
    int b = width - 1;
    int l = 0;
    int r = length - 1;
    int val = 1;

    while (val <= lastElement) {
      for (int i = l; i <= r && val <= lastElement; i++) {
        matrix[t][i] = val++;
      }
      t++;
      for (int i = t; i <= b && val <= lastElement; i++) {
        matrix[i][r] = val++;
      }
      r--;
      for (int i = r; i >= l && val <= lastElement; i--) {
        matrix[b][i] = val++;
      }
      b--;
      for (int i = b; i >= t && val <= lastElement; i--) {
        matrix[i][l] = val++;
      }
      l++;
    }
    return matrix;
  }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  Solution solution;

  @BeforeEach
  void init() {
    solution = new Solution();
  }

  @org.junit.jupiter.api.Test
  void twoSum1() {
    final int[] ints = new int[] {2, 7, 11, 15};
    final int target = 9;
    final int[] result = solution.twoSum(ints, target);

    assertArrayEquals(new int[] {0, 1}, result);
  }


  @org.junit.jupiter.api.Test
  void twoSum2() {
    final int[] ints = new int[] {3, 2, 4};
    final int target = 6;
    final int[] result = solution.twoSum(ints, target);

    assertArrayEquals(new int[] {1, 2}, result);
  }

  @org.junit.jupiter.api.Test
  void twoSum3() {
    final int[] ints = new int[] {3, 3};
    final int target = 6;
    final int[] result = solution.twoSum(ints, target);

    assertArrayEquals(new int[] {0, 1}, result);
  }

  @ParameterizedTest
  @MethodSource
  void twoSumParametrized(int[] nums, int target, int[] expectedResult) {
    assertArrayEquals(solution.twoSum(nums, target), expectedResult);
  }

  private static Stream<Arguments> twoSumParametrized() {
    return Stream.of(
            Arguments.of(null, 0, new int[0]),
            Arguments.arguments(new int[] {2}, 2, new int[0]),
            Arguments.arguments(new int[] {2, 7, 11, 15}, Integer.MAX_VALUE, new int[0]),
            Arguments.arguments(new int[] {2, 7, 11, 15}, 0, new int[0]),
            Arguments.arguments(new int[] {2, 7, 11, 15}, 26, new int[] {2, 3}),
            Arguments.arguments(new int[] {2, Integer.MAX_VALUE, 11, 15}, 26, new int[] {2, 3}),
            Arguments.arguments(new int[] {2, 7, 11, 15}, 17, new int[] {0, 3}),
            Arguments.arguments(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1})
    );
  }


  @org.junit.jupiter.api.Test
  void fill1() {
    final int[][] expect = new int[][] {
        {1, 2, 3},
        {8, 9, 4},
        {7, 6, 5}
    };
    final int[][] result = solution.fill(3, 3);
    assertArrayEquals(expect, result);
  }

  @ParameterizedTest
  @MethodSource
  void fillParametrized(int length, int width, int[][] expectedResult) {
    int[][] result = solution.fill(length, width);
    assertArrayEquals(expectedResult, result);
  }

  private static Stream<Arguments> fillParametrized() {
    return Stream.of(
            Arguments.arguments(1, Integer.MAX_VALUE, new int[0][0]),
            Arguments.arguments(0, -100, new int[0][0]),
            Arguments.arguments(0, 0, new int[0][0]),
            Arguments.arguments(0, 1, new int[0][0]),
            Arguments.arguments(1, 0, new int[0][0]),
            Arguments.arguments(1, 1, new int[][] {
                    {1},
            }),
            Arguments.arguments(1, 3, new int[][] {
                    {1},
                    {2},
                    {3}
            }),
            Arguments.arguments(3, 1, new int[][] {
                    {1, 2, 3},
            }),
            Arguments.arguments(5, 3, new int[][] {
                    {1, 2, 3, 4, 5},
                    {12, 13, 14, 15, 6},
                    {11, 10, 9, 8, 7},
            }),
            Arguments.arguments(3, 5, new int[][] {
                    {1, 2, 3},
                    {12, 13, 4},
                    {11, 14, 5},
                    {10, 15, 6},
                    {9, 8, 7},
            }),
            Arguments.arguments(3, 3, new int[][] {
                    {1, 2, 3},
                    {8, 9, 4},
                    {7, 6, 5}
            }));
  }
}
package mv.workspace.snipplets.hackerrank.algorithms;

import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        System.out.println(diagonalDifference(List.of(
                List.of(11)
        )));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftRightDiagonal = 0;
        int rightLeftDiagonal = 0;

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> currentRow = arr.get(i);
            leftRightDiagonal = leftRightDiagonal + currentRow.get(i);
            rightLeftDiagonal = rightLeftDiagonal + currentRow.get(arr.size() - 1 - i);
        }

        return Math.abs(leftRightDiagonal - rightLeftDiagonal);
    }
}

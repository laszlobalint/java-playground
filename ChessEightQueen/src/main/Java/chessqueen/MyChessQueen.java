package chessqueen;

import java.util.Arrays;
import java.util.LinkedList;

public class MyChessQueen {
    private int[][] chessBoard = new int[8][8];
    private int[] queens = {1, 1, 1, 1, 1, 1, 1, 1};
    private static int queenNUm = 8;
    private static int variationNum;
    private static LinkedList<Integer> sorted = new LinkedList<>();
    private LinkedList<Integer> oddNums = new LinkedList(Arrays.asList(2, 4, 6, 8));
    private LinkedList<Integer> evenNums = new LinkedList(Arrays.asList(1, 3, 5, 7));

    private LinkedList<Integer> calculateVariations() {
        if ((queenNUm % 12) == 3 | (queenNUm % 12) == 9) {
            oddNums.removeFirst();
            oddNums.push(2);
            for (int k = 0; k < oddNums.size(); k++) {
                sorted.push(oddNums.get(k));
            }
            for (int k = 0; k < evenNums.size(); k++) {
                sorted.push(evenNums.get(k));
            }
        } else if ((queenNUm % 12) == 8) {
            for (int k = 0; k < oddNums.size(); k++) {
                sorted.push(oddNums.get(k));
            }
            sorted.push(evenNums.get(1));
            sorted.push(evenNums.get(0));
            sorted.push(evenNums.get(3));
            sorted.push(evenNums.get(2));
        }
        return sorted;
    }

    private void showBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }
}

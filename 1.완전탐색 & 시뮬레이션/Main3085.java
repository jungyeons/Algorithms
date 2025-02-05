import java.util.Scanner;

public class Main3085 {
    static void swapCandy(char[][] matrix, int i, int j, int i1, int j1) {
        char temp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = temp;
    }

    static int maxColumns(char[][] matrix) {
        int n = matrix.length;
        int maxColumn = 0;
        for (int c = 0; c < n; c++) {
            int len = 1;
            for (int r = 1; r < n; r++) {
                if (matrix[r][c] == matrix[r-1][c]) {
                    len++;
                } else {
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }

    static int maxRow(char[][] matrix) {
        int n = matrix.length;
        int maxRow = 0;
        for (int r = 0; r < n; r++) {
            int len = 1;
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == matrix[r][c-1]) {
                    len++;
                } else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 가로 방향 스왑 (좌우)
                if (j+1 < n) {
                    swapCandy(matrix, i, j, i, j+1);
                    ans = Math.max(ans, Math.max(maxColumns(matrix), maxRow(matrix)));
                    swapCandy(matrix, i, j, i, j+1);  // 원상 복구
                }
                // 세로 방향 스왑 (상하)
                if (i+1 < n) {
                    swapCandy(matrix, i, j, i+1, j);
                    ans = Math.max(ans, Math.max(maxColumns(matrix), maxRow(matrix)));
                    swapCandy(matrix, i, j, i+1, j);  // 원상 복구
                }
            }
        }
        System.out.println(ans);
    }
}

import java.util.Scanner;

class Main1730 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean[][] x_visited = new boolean[n][n];
        boolean[][] y_visited = new boolean[n][n];
        String way = sc.hasNext() ? sc.next() : "";
        //가로 세로 길이 지정해주기
        int curRow = 0;
        int curCol = 0;
        for (int i = 0; i < way.length(); i++) {
            char ch = way.charAt(i);
            if (ch == 'U') {

                if (curRow == 0) {
                    continue;
                }
                y_visited[curRow][curCol]  = y_visited[curRow - 1][curCol] = true;
                curRow--;
            } else if (ch == 'D') {
                if (curRow == n-1) {
                    continue;
                }
                y_visited[curRow][curCol]  = y_visited[curRow + 1][curCol] = true;
                curRow++;
            } else if (ch == 'L') {
                if (curCol == 0) {
                     continue;
                }
                x_visited[curRow][curCol]  = x_visited[curRow][curCol - 1] = true;
                curCol--;
            } else {
                if (curCol == n-1) {
                    continue;
                }
                x_visited[curRow][curCol]  = x_visited[curRow][curCol + 1] = true;
                curCol++;
            }


        }

        for (int i = 0; i < n; i++) {
            String ans ="";
            for (int j = 0; j < n; j++) {
                if (x_visited[i][j] && y_visited[i][j]) ans +="+";
                else if (y_visited[i][j]) ans += "|";
                else if (x_visited[i][j]) ans += "-";
                else ans +=".";
            }
            System.out.println(ans);
        }
    }
}

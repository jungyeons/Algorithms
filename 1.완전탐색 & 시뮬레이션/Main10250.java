import java.util.Scanner;

class Main10250
{

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
                int H = sc.nextInt();
                int W = sc.nextInt();
                int Room = sc.nextInt();

                int h = ((Room-1)/H)+1;
                int mh = ((Room-1)%H)+1;
                System.out.println(h*100+mh);

        }
    }
}

import java.util.Scanner;

public class Main11068 {
    public static boolean isPalindrome (int x, int i) {

        //백만이면 대충 2의 20승이 100만이 넘으니까 배열을 20정도로 설정하는게 좋을듯
        int[] digit = new int[20];
        int length = 0;
        //자릿수 계산
        while (x > 0) {
            digit[length] = x % i;
            //나누는 횟수 만큼 자릿수가 생김.
            length = length + 1;
            x = x / i;
        }
        //회문이 될 수 있는 지 대칭성 계산
        //예를 들어 6자리라고 하면 123453 이러면 0 1 2 까지만 회문인지 보면 됨.
        //그래서 length/2-1까지만 확인하면 됨.
        for (int j =0; j<length/2; j++){
            // 양끝부터 1씩 늘려가면서 확인하면 됨.
            if(digit[j] != digit[length-j-1]){
                //대칭이 아니니까 회문이 아님.
                return false;
            }

        }
        //모두가 회문인가
        return true;



    }

    public static void main (String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                while (T--> 0) {
                    int x = sc.nextInt();
                    boolean answer = false;
                    //2진법에서부터 64진법까지 계산해야해서
                    for (int i = 2; i <= 64; i++) {
                        if(isPalindrome(x,i)){
                            answer = true;
                            break;
                        }
                    }
                    System.out.println(answer ? 1 : 0);

            }
        }
    }



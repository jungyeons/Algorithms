import java.util.Scanner;

   public class Main10448 {
        // 의문점 1 -> 왜 배열의 크기를 이렇게 잡았을까 ?
        // -> 문제에서 1000 이하의 수에 대해 '유레카 숫자'인지 판별해야 하므로
        //    0~1000까지 포함할 수 있도록 크기를 1001로 설정
        static boolean[] isEurekaNumber = new boolean[1001];

        public static void preprocess() {
            // 의문점 2 -> 왜 배열의 크기를 이렇게 잡았을까 ?
            // -> 삼각수를 저장할 배열인데, 대략적으로 50개 정도면 1000을 초과하는 삼각수를 포함할 수 있음.
            int[] triangleNumbers = new int[50];
            int triangleNumberCount = 0;

            for (int i = 1; ; i++) {
                // 의문점 3 -> 왜 트라이앵글 넘버는 이렇게 구해질까 ?
                // -> 삼각수의 공식: n번째 삼각수 = n * (n + 1) / 2
                //    1, 3, 6, 10, 15, ... 이런 식으로 삼각형 모양으로 숫자가 늘어남.
                int triangleNumber = i * (i + 1) / 2;
                if (triangleNumber > 1000) break;  // 1000을 초과하면 저장할 필요 없음

                // 의문점 4 -> 이건 뭐하는걸까 ?
                // -> 구한 삼각수를 배열에 저장하고 개수를 증가시킴
                triangleNumbers[triangleNumberCount++] = triangleNumber;
            }

            // 의문점 5 -> 3중 반복문은 상당히 복잡도가 커 보이는데 개선방법이 있을까 ?
            // -> O(N^3)의 복잡도를 가짐. 하지만 N이 충분히 작기 때문에 (최대 1000)
            //    시간 초과 없이 실행될 가능성이 높음.
            // -> 개선 방법: 미리 가능한 유레카 숫자들을 저장해두고, 입력값이 들어올 때 즉시 판별
            //    (즉, 현재 코드처럼 미리 배열을 채워두는 것이 최적화 방법 중 하나)

            // 의문점 6 -> 범위 지정을 왜 이런 식으로 하는걸까 ?
            // -> i, j, k를 같은 값에서 시작하는 이유는 중복을 피하기 위해서.
            //    삼각수의 조합을 중복해서 계산하지 않도록 (예: 1+3+6과 3+1+6을 같은 것으로 처리)
            for (int i = 0; i < triangleNumberCount; i++)
                for (int j = i; j < triangleNumberCount; j++)
                    for (int k = j; k < triangleNumberCount; k++) {
                        int eurekaNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                        if (eurekaNumber > 1000) break;  // 1000을 초과하면 더 이상 저장할 필요 없음
                        isEurekaNumber[eurekaNumber] = true;  // 해당 숫자가 유레카 수임을 기록
                    }
        }

        public static void main(String[] args) {
            // 의문점 7 -> 왜 하는 걸까 ?
            // -> 유레카 수를 미리 계산해둠으로써, 이후 입력값에 대해 O(1)로 빠르게 판별하기 위해
            preprocess();

            // 의문점 8 -> preprocess를 입력보다 먼저하는 이유는?
            // -> 입력을 받을 때마다 유레카 수를 계산하면 비효율적이므로, 처음 한 번만 계산해서 배열에 저장해 둠.
            //    이후 입력이 들어오면 바로 판별 가능.

            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();  // 테스트 케이스 개수 입력받음

            // 의문점 9 -> while 문의 조건이 저런 이유는?
            // -> T가 1 이상일 때까지 실행되도록 설정 (T-- > 0 → T를 하나씩 감소시키면서 반복)
            while (T-- > 0) {
                int K = sc.nextInt();  // 유레카 수인지 판별할 값 입력
                System.out.println(isEurekaNumber[K] ? "1" : "0");  // 유레카 수이면 1, 아니면 0 출력
            }
        }
    }



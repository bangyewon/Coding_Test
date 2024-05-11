import java.util.*;

public class Main1 {
    // N개 모두 같은 길이의 랜선으로 만들것 -> k개의 랜선 자르기
    // 손실되는 길이는 없음
    // k : 갖고있는 랜선 개수 / N :필요한 랜선 개수
    // 주어진 랜선길이를 배열로 생각해서 이진탐색 해보자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] line = new int[K];

        long min = 0;
        long max = 0;
        // max 갱신해야함
        for (int i = 0; i < K; i++) {
            line[i] = sc.nextInt(); // 주어지는 길이
            if (max < line[i]) {
                max = line[i]; // max값 갱신
            }
        }
        ++max; // 반드시 1이상이여야하기에
        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0; // 구해야 하는 값
            for (int j = 0; j < line.length; j++) {
                count += (line[j] / mid);
            }
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}

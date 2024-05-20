import java.lang.reflect.Array;
import java.util.*;
public class Main5 {
    // 줄 서는 순서따라 시간 합이 달라짐
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 각 사람마다 걸리는 시간은 배열로!
        int[] P = new int[N];
        for(int i = 0; i<P.length; i++) {
            P[i] = sc.nextInt();
        }
        //입력받은 값들 정렬 필요!
        Arrays.sort(P);
        // 최소 시간 합 구하기
        int time = 0; // 현재사람 대기시간
        int sum = 0; // 총 대기시간
        for(int i = 0; i < P.length; i++) {
            time += P[i]; // 현재 사람 대기시간에 누적 후
            sum += time; // 총 대기시간에 누적해 더해줌
        }
        System.out.println(sum);
    }
}

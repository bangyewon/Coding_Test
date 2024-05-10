import java.util.*;
public class Solution1 {
    // 심사 칸 여러개 - 모두 심사 받는데 걸리는 시간 최소 원함 - 최종 끝나는 시간
    // 사람 수 : N / 심사 소요시간 : times[]
    //ex) [7,10] -> 1 : 7분 간격으로 심사대 빔 / 2 : 10분 간격으로 심사대 빔
    // 심사대가 비지만 심사 받지 않고 더 기다린 후에 다른 곳에서 심사받을 수 있음
    // answer : 마지막 사람이 들어간 시간 + 마지막 사람이 심사받는데 걸린시간
    //마지막 사람이 들어간 시간 : 1) 더 안기다리고 순서대로 들어감 2) 더 기다리고 골라서 들어감

    public long solution(int n, int[] times) {
        // 각 심사대 시간 파악
        Arrays.sort(times); // 배열 정렬해 심사대 시간 별 정렬하기
        long min = 0;
        long max = (long) times[times.length - 1] * n; //가장 오래 걸리는 심사대 * 사람 수
        long answer = max;
        //역전되지 않을 때까지 탐색
        while(min <= max) {
            long mid = (min + max) / 2;
            //중간 시간 내 심사 받을 수 있는 사람
            long count = 0;
            for(int time : times) {
                count += mid / time;
            }
            if(count >= n ) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }
}

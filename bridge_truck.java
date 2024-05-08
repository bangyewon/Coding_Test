import java.util.*;

public class Solution {
    // 트럭들 일차선 다리를 정해진 순으로 건넘 -> FIFO로 큐 이용하자
    // 다리에 트럭 최대 bridge_length 올라갈 수 있음, wegiht이하의 무게 견디기 가능
    // 트럭들 시간 구하기 : bridge_length + truck_weights.length로 구할 수 있음
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성 : birdge_length만큼 갖는 큐
        //초기화 시키기 - 아무것도 올라가있지 않은 다리 0으로 만들기
        for( int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        // -- 예외상황 생각해보기 --
        // 다리 길이가 1일 경우
        if(bridge_length == 1) {
            return truck_weights.length+1; // 건너야 하는 트럭 개수에 +1하면 시간 나옴 
        }
        // 트럭 수가 1일 경우
        if(truck_weights.length == 1) {
            return bridge_length +1; 
        }
        // -- weight 생각해주기  : 다리위의 트럭이 weight가 넘어간다면 ? -> 예외발생 : 0 반환 -- 
        // 다리 위의 존재하는 트럭의 무게 선언
        int bridge_truck_weight = 0;
        //트럭 개수만큼 계속 돌자 
        int j = 0;
        int truck = 0; // 진입 할 트럭
        while(j < truck_weights.length) {
            //맨 앞 트럭을 다리에서 나가게 한 후 새 트럭 진입한다면 ?
            bridge_truck_weight-= queue.poll(); // 현재 다리위의 트럭 무게에서 빼주기
            // 다음 트럭 진입
            truck++;
            // 다리 앞에 트럭이 있다면?
            if(bridge_truck_weight + truck_weights[j] <= weight) {
                queue.offer(truck_weights[j]);
                // 다음 트럭 진입
                bridge_truck_weight += truck_weights[j++];
            }
            else { // 다음 트럭이 진입 못할 경우 -> 다리가 버틸 수 있는 weight를 넘었다 / 진입할 트럭이 없다 (while문에서 조건걸었음 - 진입 할 트럭 없으면 끝내기로)
                queue.offer(0);
            }
        }
        return truck + bridge_length;
    }
}

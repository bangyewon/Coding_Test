import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 원을 그리며 앉음 -> 원형 큐 이용하자
    // 제거되는 순서 : 요세푸스 순열
    // 예시 :(7,3) -> <3,6,2,7,5,1,4>
    // 1st) 3번 사람이 제거되면 F가 해당 자리로 이동
    // 2nd) F가 4번 사람을 가리키는 시작점에서 다시 3번째의 사람 제거 후 F가 해당 자리로 이동 - 모두 제거될때까지 반복

    // enqueue로 N명의 원형 큐 만들기 -> Scanner로 입력값 받기 -> dequeue로 k번 사람 제거 반복(큐가 0일때까지)
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 생성 - 연결리스트 이용
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // n명의 사람
        int k = input.nextInt(); // k번째 제거
        //enqueue로 큐 채우기
        for(int i = 1; i <= n; i++) {
            queue.add(i); // enqueue
        }
        StringBuilder dvalue = new StringBuilder();
        dvalue.append('<');
        while (queue.size()>1) {
            // k배수가 아닌사람은 뽑고 다시 넣기
            for (int i = 0; i < k - 1; i++) {
                int value = queue.poll();
                queue.offer(value);
            }
            //뽑은 값 String 추가
            dvalue.append(queue.poll()).append(", ");
        }
        dvalue.append(queue.poll()).append('>');
        System.out.println(dvalue);
    }
}
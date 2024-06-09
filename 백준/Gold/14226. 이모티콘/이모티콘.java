import java.util.*;
public class Main {
    // 3가지 연산만 사용 ->S개
    static boolean[][] visited = new boolean[2001][2001]; // visited만 이용해서 currentEmotion 으로 해보자
    static int s; // 만들어야할 개수
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        System.out.println(bfs());

        // 1개 이미 입력했기에 1부터 시작
        for(int i = 1; i < s; i++) {
        }
    }
    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0}); // 현재 이모티콘 수, 클립보드 이모티콘 수
        visited[1][0] = true;
        min = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] current = queue.poll(); // 현재 위치 저장
                int cEmotion = current[0]; // 현재 이모티콘
                int clip = current[1]; // 클립보드 위치

                if(cEmotion == s) { //목표 이모티콘 개수 완료
                    return min;
                }
                // 1번 연산 (클립보드에 이모티콘 복사)
                if(!visited[cEmotion][cEmotion]) {
                    // 아직 방문하지 않았기에 
                    visited[cEmotion][cEmotion] = true;
                    queue.offer(new int[]{cEmotion,cEmotion});
                }
                // 2번 연산(클립보드 이모티콘 화면에 복사)
                // 2000개 최대
                if(clip > 0 && cEmotion + clip <= 2000) {
                    if(!visited[cEmotion + clip][clip]) {
                        visited[cEmotion + clip][clip] = true;
                        queue.offer(new int[]{cEmotion + clip,clip});
                    }
                }
                // 3번 연산(현재 이모티콘 중 하나 삭제)
                if(cEmotion - 1 >= 0) {
                    if(!visited[cEmotion - 1][clip]) {
                        visited[cEmotion - 1][clip] = true;
                        queue.offer(new int[]{cEmotion - 1,clip});
                    }
                }
            }
            min++;
        }
        return -1; //도달 불가능할때만 발생하도록
    }
}
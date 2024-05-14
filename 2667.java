import java.util.*;
public class Main3 {
    // 1 : 집이 있는 곳 0 : 집이 없는 곳
    //연결됨 -> 좌우/위아래 집 존재
    // 단절점을 찾는다 -> 단지로 묶을 수 있도록하는 지점 : DFS로 접근
    // DFS가 탐색할 수 있는 조건이 뭔지 생각해보자 -> 방문X,연결되있는 부분
    //DFS로 할땐 static이 많이 쓰임 -> 재귀여서 !
    static boolean[][] visited;
    static int[][] apt;
    static int count; // 각 단지의 크기 측정위함
    static int[] sizes; // count 저장해 각 단지의 크기 측정 배열
    // dx[0],dy[0] : 위로 / dx[1],dy[1] : 아래로 
    static int mx[] = {-1, 1, 0, 0}; // 좌우 움직이기 배열
    static int my[] = {0, 0, -1, 1}; // 상하 움직이기 배열 -> 내부 배열 값 순서 바꿔도 됨
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt(); // 정수형으로 바로 받음
        apt = new int[N][N]; 
        visited = new boolean[N][N]; 
        int result = 0;
        // 정사각형 채우기
        for(int i = 0; i < N; i++) { //width
            String line = sc.next();
            for(int j = 0; j < N; j++) { //height
                apt[i][j] = line.charAt(j) - 0; // 입력받은 String -> 정수형으로 바꿔서 배열 넣기
            }
        }
        sizes = new int[N * N]; // 최대 크기는 N*N
        //정사각형 채웠으면 이제 for루프 돌면서 연결되있는 부분 탐색 : 1인부분
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 방문 안했고 , 1이라면 ? -> 1만 따라서 쭉 가도록
                if(visited[i][j] == false && apt[i][j] == 1) {
                    count = 0;
                    DFS(i,j); // DFS로 탐색하도록 !
                    sizes[result++] = count;
                }
            }
            
        }
        sc.close();
        Arrays.sort(sizes, 0, result); // 단지의 크기 배열을 정렬
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(sizes[i]);
        }

    }
    //여기서 해당 함수는 위아래,좌우만 탐색 가능 하도록
    static void DFS(int x, int y) {
        visited[x][y] = true; // 초기화
        count ++;
        // 동서남북으로 움직이자
        for( int i = 0; i < 4; i++) {
            int X = mx[i] + x; // X축 : 가려는 방향에 몇만큼 x축으로 가는지 - 현재 X위치 갱신
            int Y = my[i] + y; // Y축 : 가려는 방향에 몇만큼 y축으로 가는지 - 현재 Y위치 갱신
            // DFS 탐색하는 조건 : 현재 X,Y위치가 0 ~ N 사이에 존재 & visited[x][y] == false & 연결되있어야함(1이어야 함)
            if(X >= 0 && Y >= 0 && visited[X][Y] == false && apt[X][Y] == 1) {
                DFS(X,Y); // 재귀함수로 연결되있는 부분 탐색하기
            }
        }
    }
}
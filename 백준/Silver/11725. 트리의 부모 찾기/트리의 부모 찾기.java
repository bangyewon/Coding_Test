
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
// 루트없는 트리 
// 각 노드의 부모 구하기 
    static boolean[] visited;
    static int N;
    static ArrayList<Integer> tree[];
    // 부모 노드를 한번에 출력해야하기에 부모 노드 배열도 생성필요
    static int parent[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수
        // 초기화
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        // 트리 구성 - 트리에 데이터 저장
        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        } // 입력 순서대로 데이터 저장됨
        
        // 탐색 시작 - 1번 노드부터
        for(int i = 1; i < N; i++) { // 처음 들어온 데이터 트리에 저장
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        dfs(1); // 부모노드 부터 탐색
        // 2노드부터 출력 - 문제 조건
        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void dfs(int v) {
        visited[v] = true;
        // tree 내 순회 
        for(int i : tree[v]) {
            if(visited[i] == false) {
                parent[i] = v;
                dfs(i);
            }
        }
    }
}

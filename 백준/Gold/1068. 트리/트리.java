import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 리프노드 개수 구하기 - 리프 노드 
    // 탐색하다가 제거할 노드 나오면 탐색 멈추기
    static ArrayList<Integer> tree[];
    static boolean[] visited;
    static int leaf = 0;
    static int dnode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수
        
        // 초기화
        tree = new ArrayList[N];
        visited = new boolean[N];
        int root = -1; // 부모노드 초기화
        
        // 트리 구성
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 연결
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            // 루트노드가 있다면 연결시키기
            if(p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            }
            else {
                root = i;
            }
        }
        
        dnode = Integer.parseInt(br.readLine()); // 삭제할 노드

        // 삭제할 노드가 루트인 경우 처리
        if(dnode == root) {
            System.out.println(0);
        }
        else {
            dfs(root);
            System.out.println(leaf); // 리프노드 출력
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        int cnode = 0; // 자식노드
        for(int i : tree[v]) {
            // 방문 안했을때, 삭제할 노드가 아닐때 탐색 중지
            if(!visited[i] && i != dnode) {
                cnode++;
                dfs(i);
            }
        }
        if(cnode == 0) {
            leaf++; // 자식노드가 하나도 없으면 리프노드!
        }
    }
}

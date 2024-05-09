import java.util.*;
public class Main {
    // 높이 H 지정 -> H미터 위로 올라감 -> 한줄 절단
    // 적어도 M미터 나무 갖고가기 위해 절단기에 설정할 수 있는 높이의 최댓값  구하기
    // 나무 절단을 뒤집어보면 배열의 특정 부분을 자르는 것과 같이 생각할 수 있음 -> 배열로 접근하자
    // 1) 나무의 수 : N 2) 집에 가져가야하는 나무 길이 : M
    // N,M 입력받기 -> 나무의 높이 (배열)
    // 나무의 높이들의 중간값 찾고 M을 만족하는지 아닌지로 판별해 이진탐색으로 Hmax에 접근해보자(1차 생각)
    // 입력받은 나무의 높이들을 인덱스별 하나씩 Hmax와 비교하면서 큰지 작은지 여부로 Hmax에 접근하기(2차 생각)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] tree = new int[N]; // 나무의 높이들 N맞게 공간할당
        int Hmax = 0; // 절단기 높이 최댓값 
        int Hmin = 0; // 절단기 높이 최솟값

        for(int i = 0; i < N; i++) {
            tree[i] = input.nextInt(); // 나무 높이들 입력받기
            
            if(Hmax < tree[i]) {
                Hmax = tree[i]; // 높이 갱신
            }
        }
        // 이진탐색 시작
        //mid < key : low = mid+1 / mid > key : high = mid-1
        while(Hmax > Hmin) {
            int Midtree = (Hmax + Hmin) / 2;
            long sum = 0; // 최종 나무의 길이 저장할 합계 -> M과 동일해져야함
            for(int Hight : tree) {
                // 0 이하인 경우는 안됨
                if(Hight - Midtree > 0) {
                    // 최종 나무의 길이 : Hight - Midtree
                    sum += Hight - Midtree;
                }
            }
            //M과 Sum이 동일해야함으로 비교해야함
            if(sum < M) {
                Hmax = Midtree;
            }
            else {
                Hmin = Midtree + 1;
            }
        }
        System.out.println(Hmin - 1); // Hmin은 M이상을 충족하기에 -1해서 실제로 만족하는 최소높이 되야함
    }
}

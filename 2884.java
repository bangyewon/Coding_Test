import java.util.*;
public class Solution {
//45분 알람 일찍 설정하기 
// 더 줄여서 해보기 re
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //설정한 알람시간 H,M
        int H = sc.nextInt();
        int M = sc.nextInt();
        // if(H !=0 && M < 45) {
        //     int h = H --;
        //     int m = 60-(45-M);
        //     System.out.println(h);
        //     System.out.println(m); 
        // }
        // else if( H != 0 && M >= 45) {
        //     int h = H;
        //     int m = M - 45;
        //     System.out.println(h);
        //     System.out.println(m); 
        // }
        // else if(H == 0 && M >= 45) {
        //     int h = 23;
        //     int m = M - 45;
        //     System.out.println(h);
        //     System.out.println(m); 
        // }
        // else if(H == 0 && M < 45) {
        //     int h = 23;
        //     int m = 60-(45-M);
        //     System.out.println(h);
        //     System.out.println(m); 
        // }
        if( M < 45) {
            H --;
            M = 60 - (45-M);
            if(H < 0) {
                H = 23;
            }
            System.out.println(H + " " + M);
        }else {
            System.out.println(H + " " + (M-45));
        }
    }

}

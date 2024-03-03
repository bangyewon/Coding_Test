import java.util.*;
public class Solution {
//사분면 문제 - 조건문 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(0 < x && 0 < y) {
            //1사분면
            System.out.println("1");
        }
        else if(0 > x && 0 < y) {
            System.out.println("2");
        }
        else if(0 > x && 0 > y) {
            System.out.println("3");
        }
        else if(0 < x && 0 > y) {
            System.out.println("4");
        }
    }

}

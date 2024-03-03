import java.time.Year;
import java.util.*;
public class Solution {
// 윤년 문제 2753
//scanner 이용 
    public static int leap_year(int year) {
        if(year % 4 == 0 && year % 100 !=0 || year % 400 == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(leap_year(year));
    }

}

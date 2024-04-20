import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    String sNum =sc.next(); // 문자로 받기
    char[] NumA = sNum.toCharArray();
    int sum = 0;

    for(int i = 0; i < NumA.length; i++) {
      sum += NumA[i] - '0'; // 정수형 변환
    }
    System.out.println(sum);

  }
    }

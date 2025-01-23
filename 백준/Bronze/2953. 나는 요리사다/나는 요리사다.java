import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
    // int[5][4] 배열 만들어서 각 row에 대해 합산 후 그 중 제일 큰 row 출력
    int[][] score = new int[5][4];
    int maxScore = 0;
    int winner = 0;
    for(int i = 0; i < 5; i++) {
      int totalScore = 0;
      for(int j = 0; j < 4; j++) {
        totalScore += sc.nextInt();
      }
      if(maxScore < totalScore) {
        maxScore = totalScore;
        winner = i + 1;
      }
    }
    System.out.println(winner + " "+ maxScore);
    }
}

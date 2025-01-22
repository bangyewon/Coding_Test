
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int[] alphabetCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 입력된 소문자 알파벳에 대해 아스키 코드에서 제외하면서 빈도수 계산
            alphabetCount[c - 'a']++;
        }
        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
    }
}

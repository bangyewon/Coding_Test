import java.io.*;
import java.util.Stack;
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine()); // 정수 개수
    int sum = 0;

    Stack<Integer> stack = new Stack<>(); // 스택 선언
    // data 집어넣기
    for(int i = 0; i < K; i++) {
      int money = Integer.parseInt(br.readLine());
      if(money == 0) {
        stack.pop();
      }
      else {
        stack.push(money);
      }
    }
    for(int i = 0; i < stack.size(); i++) {
      sum += stack.get(i);
    }
    System.out.println(sum);
  }
    }

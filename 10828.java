import java.util.*;
import java.util.Scanner;

public class Main {
    //stack 초기화 
    public static int[] stack;
    public static int size = 0;
    public static void main(String[] args) {
        //Scanner 값 받기
        Scanner input = new Scanner(System.in);
        //메모리 잡아먹지 않게 Stringbuilder로 값만 바꿔서 출력 가능하도록 
        StringBuilder b = new StringBuilder();

        int n = input.nextInt();
        //stack에 입력받은 n이 쌓일 것
        stack = new int[n];
        for(int i = 0; i < n; i++) {
            String str = input.next();
            //case 나눠서 해당 입력값 들어오면 들어가도록 
            switch(str) {
                case "push":
                push(input.nextInt());
                break;

                case "pop":
                b.append(pop()).append('\n');
                break;

                case "size":
                b.append(size()).append('\n');
                break;

                case "empty":
                b.append(empty()).append('\n');
                break;

                case "top":
                b.append(top()).append('\n');
                break;
            }
        }
        System.out.println(b);
    }
    //메소드
    public static int size() {
        //정수 개수 
        return size;
    }
    public static int top() {
        //맨 위 데이터 출력해야하나 아무것도 없을 시 -1
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1]; // 맨 위 값 return 
        }
    }
    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void push(int num) {
        //현재 stack의 맨위(Top)에 해당 num을 넣음 -> size ++
        stack[size] = num;
        size++;
    }
    public static int pop() {
        //가장 위에있는 것 빼야함으로 size가 0이면 안됨 !
        if(size == 0) {
            return -1;
        }
        else {
            int dnum = stack[size - 1]; // 삭제할 dnum에 최상위 값 넣기
            stack[size - 1] = 0; //최상위 값 0으로 삭제
            size--; // 스택 한칸 내리기
            return dnum; // 삭제한 값 return
        }
    }
}

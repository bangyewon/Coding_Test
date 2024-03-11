import java.util.*;
// import java.util.random.*;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    //1. 같은 눈 3개 : 10,000 + (같은 눈)*1000
    //2. 같은 눈 2개 : 1000+(같은 눈)*100
    //3. 모두 다른 눈 : (그중 가장 큰 눈)* 100

    // int r_dice1 = (int)(Math.random()*6)+1;
    // int r_dice2 = (int)(Math.random()*6)+1;
    // int r_dice3 = (int)(Math.random()*6)+1;

    Scanner sc = new Scanner(System.in);
    int r_dice1 = sc.nextInt();
    int r_dice2 = sc.nextInt();
    int r_dice3 = sc.nextInt();

    if(r_dice1 == r_dice2 && r_dice2 == r_dice3) {
      int money = 10000 + (r_dice1)*1000;
      System.out.println(money);
    }
    else if(r_dice1 == r_dice2 || r_dice1 == r_dice3) {
      int money = 1000 + r_dice1*100;
      System.out.println(money);
    }
    else if(r_dice2 == r_dice3) {
      int money = 1000 + r_dice2*100;
      System.out.println(money);
    }
    else {
      //Math.max 기억
      int money = Math.max(r_dice1, Math.max(r_dice2,r_dice3))*100;
      System.out.println(money);
    }
    sc.close();
  }
    }

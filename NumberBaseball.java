import java.util.Scanner;
import java.util.Random;

public class NumberBaseball {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int c1 = random.nextInt(9) + 1;
        int c2, c3;

        while (true){
            c2 = random.nextInt(9) + 1;
            if (c2 != c1) break;
        }
        while (true){
            c3 = random.nextInt(9) + 1;
            if (c3 != c1 && c3 != c2) break;
        }
        int turn = 0;
        System.out.println("** 숫자야구 게임을 시작합니다 **");

        while (true){
            System.out.println("숫자 3자리를 입력하세요!: ");
            String input = scanner.nextLine();

            if (input.equals("") || input.length() != 3){
                System.out.println("!!! 3자리 숫자를 입력하세요 !!!\n");
            }
            else{
                turn++;
                int strike = 0;
                int ball = 0;
                int userNum = Integer.parseInt(input);
                int u1 = userNum / 100;
                int u2 = (userNum / 10) % 10;
                int u3 = userNum % 10;

                if (u1 == c1) strike++;
                if (u2 == c2) strike++;
                if (u3 == c3) strike++;
                if (u1 == c2 || u1 == c3) ball++;
                if (u2 == c1 || u2 == c3) ball++;
                if (u3 == c1 || u3 == c2) ball++;
                if (strike ==3){
                    System.out.println("\t*** " + turn + "화면에 승리! ***\n");
                    break;
                }
                else if(turn == 9){
                    System.out.println("*** 모든 기회가 끝났습니다! ***");
                    System.out.println("*** 정답은 " + c1 + c2 + c3+ "입니다! ***");
                    break;
                }
                else {
                    System.out.println("\t" + ball + "볼-" + strike + " 스트라이크\n");
                }
            }
        }
          scanner.close();
    }
}

import java.util.Scanner; // 키보드 입력을 받기 위해 스캐너 클래스 임포트
import java.util.Random;  // 랜덤 숫자를 생성하기 위해 랜덤 클래스 임포트

public class NumberGuessGame {
    public static void main(String [] args){
        // [1] 입력 객체와 랜덤 객체를 준비함
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // [2] 1~100 사이의 임의의 정수를 하나 생성하여 comNum에 저장
        int comNum = random.nextInt(100) + 1;
        int userNum = 0; // 사용자가 입력할 숫자를 저장할 변수 (0으로 초기화)
        System.out.println("** 10번 동안 숫자 맞추기! **\n");

        // [3] for문을 사용하여 1회부터 10회까지 반복 실행
        for (int i = 1; i <= 10; i++){
            System.out.println("[" + i + "회차] 예상 숫자를 입력하세요: ");
            String input = scanner.nextLine(); // 사용자 입력을 문자열(String)로 받음

            // [4] 아무것도 입력하지 않고 엔터만 쳤을 경우(공백 체크)
            if(input.equals("")){
                System.out.println("!!! 값을 입력하세요 !!!\n");
            }
            else {
                // [5] 입력받은 문자열을 정수(int)형으로 변환
                userNum = Integer.parseInt(input);

                // [6] 입력값이 게임 범위(1~100)를 벗어났는지 확인
                if (userNum < 1 || userNum > 100){
                    System.out.println("1 ~ 100 사이의 숫자를 입력하세요!\n");
                }
                else {
                    // [7] 입력한 값과 정답(comNum)을 비교하여 힌트 제공
                    if (userNum < comNum){
                        // 입력값이 정답보다 작을 때
                        System.out.println("** 입력한 숫자가 더 작습니다. (UP)\n");
                    }else if (userNum > comNum){
                        // 입력값이 정답보다 클 때
                        System.out.println("** 입력한 숫자가 더 큽니다. (DOWN)\n");
                    }else{
                        // 정답을 맞혔을 때 반복문(for)을 즉시 종료
                        break;
                    }
                }
            }
        } // for 반복문 끝

        // [8] 반복문이 끝난 후, 정답 여부를 최종 판정
        if (userNum == comNum){
            // 정답을 맞춘 경우 (System.err를 사용해 강조 출력)
            System.err.println("정답!\n랜덤 숫자는 '" + comNum + "'입니다!\n");
        }else{
            // 10번 안에 맞추지 못한 경우
            System.out.println("10번의 기회가 끝났습니다!\n랜덤 숫자는 '"+comNum+"'입니다!\n");
        }
        
        // [9] 사용이 끝난 스캐너 자원을 닫아 메모리 효율을 높임
        scanner.close();
    }
}
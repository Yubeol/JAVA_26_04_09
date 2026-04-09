public class Game369 {
    public static void main(String[] args)    {
        // [1] 프로그램 시작 알림 (에러 스트림을 사용하여 강조 출력)
        System.err.println("--- 1부터 100까지 369 게임 (단일 박수 버전) ---");

        // [2] 1부터 100까지 반복문 실행
        for (int i = 1; i <= 100; i++){
            // [3] 현재 숫자(i)를 십의 자리(tens)와 일의 자리(ones)로 분리
            int tens = i / 10; // 예: 36 / 10 = 3
            int ones = i % 10; // 예: 36 % 10 = 6

            // [4] 첫 번째 조건문: 십의 자리나 일의 자리에 3, 6, 9가 하나라도 있는지 확인 (박수 칠 숫자인지 판단)
            if( tens == 3 || tens == 6 || tens == 9 || ones == 3 || ones == 6 || ones == 9){
                
                // [5] 두 번째 조건문 (중첩 if): 십의 자리 '그리고' 일의 자리가 모두 3, 6, 9인지 확인 (AND 연산)
                if(( tens == 3 || tens == 6 || tens == 9) && (ones == 3 || ones == 6 || ones == 9)){
                    // 두 자리 모두 3, 6, 9라면 박수 두 번 (예: 33, 36, 39, 63, 66, 69, 93, 96, 99)
                    System.out.println("짝짝");
                } else {
                    // 하나만 3, 6, 9라면 박수 한 번 (예: 3, 6, 13, 31, 49 등)
                    System.out.println("짝");
                }   
            } else {
                // [6] 3, 6, 9가 전혀 포함되지 않은 숫자일 경우에만 해당 숫자(i)를 출력
                // System.err를 사용하여 박수 소리(out)와 숫자를 시각적으로 분리함
                System.err.println(i);
            }
        }
    }
}
import java.util.Scanner;
import java.time.LocalDate;

public class age {
    public static void main(String [] args){
        // [1] 시스템의 현재 날짜 정보를 가져옴
        LocalDate today = LocalDate.now();
        int todayY = today.getYear();      // 현재 연도 (예: 2026)
        int todayM = today.getMonthValue(); // 현재 월 (1~12)
        int todayD = today.getDayOfMonth(); // 현재 일 (1~31)
        
        // [2] 2자리 연도 입력을 판단하기 위한 기준값 (현재 연도를 100으로 나눈 나머지)
        int baseLine = todayY % 100;

        // [3] 사용자 안내 메시지 출력
        System.out.println("\n 지금 관람하는 영화는 '20세이상관람가' 등급으로,");
        System.out.println("20세 이상은 누구나 관람할 수 있습니다.");
        System.out.println("***만 20세 미만의 경우 보호자 동반 시에만 관람할 수 있습니다.***\n");
        
        // [4] 입력을 받기 위한 스캐너 설정 (인코딩 UTF-8)
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.printf("생년월일 6자리를 입력하세요 (예: 050408): ");
        String birth = scanner.nextLine(); // 전체 생년월일을 문자열로 입력받음

        // [5] 입력받은 문자열을 2글자씩 잘라서 숫자로 변환
        int birthY = Integer.parseInt(birth.substring(0,2)); // 연도 부분 (0, 1번째)
        int birthM = Integer.parseInt(birth.substring(2,4)); // 월 부분 (2, 3번째)
        int birthD = Integer.parseInt(birth.substring(4,6)); // 일 부분 (4, 5번째)
        
        // [6] 2자리 연도를 4자리 연도로 확장하는 로직
        if (birthY > baseLine){
            // 입력값이 기준(26)보다 크면 1900년대생으로 간주 (에러 발생 가능 포인트: birth는 String임)
            birthY = 1900 + birthY; 
        }else {
            // 입력값이 기준(26)보다 작거나 같으면 2000년대생으로 간주
            birthY = 2000 + birthY;
        }
        
        // [7] 현재 연도와 태어난 연도의 차이 계산
        int ageDiff = todayY - birthY;

        // [8] 만 나이 판별 조건문 시작
        if (ageDiff == 20){
            // 연도 차이가 딱 20일 때, 생일이 지났는지 세부 확인
            if ((birthM <= todayM) && (birthD <= todayD)){
                System.out.println("\n만 20세 이상이므로, 해당 영화를 관람하실 수 있습니다.");
            }else{
                System.out.println("\n만 20세 미만이르모, 해당 영화를 관람하실 수 있습니다.");
            }
        }else{
            // 연도 차이가 20이 아닐 때
            if (ageDiff > 20){
                // 20보다 크면 통과
                System.out.println("\n만20세 이상이므로, 해당 영화를 관람하실 수 있습니다.");
            }else{
                // 20보다 작으면 미성년
                System.out.println("\n만 20세 미만이므로, 해당 영화를 관람하실 수 있습니다.");
            }
        }
        
        // [9] 스캐너 자원 해제
        scanner.close();
    }
}
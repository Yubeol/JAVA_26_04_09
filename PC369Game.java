import java.util.Scanner;

public class PC369Game {
    public static void main(String[] args)    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("컴퓨터와 하는 3,6,9 게임\n");
        int turn;
        do{
            System.out.println("게임 순서 - 선(0) / 후(1): ");
            turn = scanner.nextInt();
            scanner.nextLine();
            if (turn != 0 && turn != 1){
                System.out.println("!!! 게임을 먼저 할지(0), 나중에 할지(1) 정해주세요 !!!\n");
            }
        }while(turn != 0 && turn != 1);
        for (int count = 1; count <= 100; count++){
            int tens = count / 10;
            int ones = count % 10;
            boolean shouldClap = (tens == 3 || tens == 6 || tens == 9 || ones == 3 || ones == 6 || ones == 9);
            if ((turn + count) % 2 == 1){
                if(count == 1 && turn == 0) System.out.println("게임을 먼저 시작합니다!");
                System.out.println("\nUser - ");
                String user = scanner.nextLine();
                if (shouldClap){
                    if (!user.equals("짝")){
                        System.out.println("틀렸습니다! \nPC Win! ");
                        break;
                    }
                }else{
                        if(user.equals("짝") || !user.equals(String.valueOf(count))){
                            System.out.println("틀렸습니다!\nPC Win!");
                            break;
                        }
                    }
                }
                else{
                    if (count == 1 && turn == 1) System.out.println("게임을 나중에 시작합니다!");
                    if (shouldClap){
                        System.err.println("\nPC - 짝!");
                    }else{
                        System.err.println("\nPc - " + count);
                    }
                }
            }
            scanner.close();
        }
        
    }

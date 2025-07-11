package tamagotchi;

import java.util.Scanner;

/**
 * 다마고치 게임의 메인 클래스 (샘플 구현)
 * 게임의 전체적인 흐름을 제어합니다.
 */
public class MainSample {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new GameImplSample();
        
        System.out.println("🥚 다마고치 게임에 오신 것을 환영합니다! 🥚");
        System.out.println("=====================================");
        
        // 펫 이름 입력받기
        System.out.print("펫의 이름을 입력해주세요: ");
        String petName = scanner.nextLine();
        
        // 게임 시작
        game.start(petName);
        
        // 게임 루프
        while (game.isGameRunning()) {
            System.out.println("\n무엇을 하시겠습니까?");
            System.out.println("1. 상태 확인");
            System.out.println("2. 먹이 주기");
            System.out.println("3. 놀아주기");
            System.out.println("4. 재우기");
            System.out.println("5. 시간 보내기");
            System.out.println("6. 게임 종료");
            System.out.print("선택 (1-6): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    game.displayStatus();
                    break;
                case "2":
                    game.feedPet();
                    game.advanceTime();
                    break;
                case "3":
                    game.playWithPet();
                    game.advanceTime();
                    break;
                case "4":
                    game.putPetToSleep();
                    game.advanceTime();
                    break;
                case "5":
                    System.out.println("⏰ 시간이 흘러갑니다...");
                    game.advanceTime();
                    game.displayStatus();
                    break;
                case "6":
                    System.out.println("게임을 종료합니다. 안녕히 가세요!");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
            
            // 매 행동 후 펫이 죽었는지 확인
            if (!game.isGameRunning()) {
                System.out.println("\n게임이 종료되었습니다.");
                System.out.println("다시 플레이하려면 프로그램을 다시 실행해주세요.");
            }
        }
        
        scanner.close();
    }
}
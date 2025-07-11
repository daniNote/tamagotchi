package tamagotchi;

/**
 * Game 구현체를 테스트하는 클래스
 * 게임의 전반적인 흐름과 기능을 테스트합니다.
 */
public class GameTestSample {
    
    private static int testCount = 0;
    private static int passedCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== 다마고치 Game 테스트 시작 ===\n");
        
        GameTestSample test = new GameTestSample();
        
        test.testGameInitialization();
        test.testGameStart();
        test.testFeedingInGame();
        test.testPlayingInGame();
        test.testSleepingInGame();
        test.testTimeAdvancement();
        test.testGameOverByDeath();
        
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println("총 " + testCount + "개 중 " + passedCount + "개 통과");
        
        if (passedCount == testCount) {
            System.out.println("모든 테스트를 통과했습니다! 🎉");
        } else {
            System.out.println("일부 테스트가 실패했습니다. 구현을 다시 확인해주세요.");
        }
    }
    
    private void testGameInitialization() {
        System.out.println("테스트 1: 게임 초기화");
        try {
            Game game = new GameImpl();
            
            assertFalse(game.isGameRunning(), "초기에는 게임이 실행 중이 아니어야 합니다");
            assertNull(game.getPet(), "초기에는 펫이 없어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testGameStart() {
        System.out.println("테스트 2: 게임 시작");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            assertTrue(game.isGameRunning(), "게임 시작 후 실행 중이어야 합니다");
            assertNotNull(game.getPet(), "게임 시작 후 펫이 생성되어야 합니다");
            assertEquals("테스트펫", game.getPet().getName(), "펫 이름이 올바르게 설정되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testFeedingInGame() {
        System.out.println("테스트 3: 게임 내 먹이주기");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            int initialHunger = game.getPet().getHunger();
            game.feedPet();
            
            assertTrue(game.getPet().getHunger() < initialHunger, 
                "게임에서 먹이를 주면 배고픔이 감소해야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testPlayingInGame() {
        System.out.println("테스트 4: 게임 내 놀아주기");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            int initialHappiness = game.getPet().getHappiness();
            game.playWithPet();
            
            assertTrue(game.getPet().getHappiness() > initialHappiness, 
                "게임에서 놀아주면 행복도가 증가해야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testSleepingInGame() {
        System.out.println("테스트 5: 게임 내 재우기");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            // 에너지를 소모시킴
            game.playWithPet();
            int initialEnergy = game.getPet().getEnergy();
            
            game.putPetToSleep();
            
            assertTrue(game.getPet().getEnergy() > initialEnergy, 
                "게임에서 재우면 에너지가 회복되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testTimeAdvancement() {
        System.out.println("테스트 6: 시간 진행");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            int initialHunger = game.getPet().getHunger();
            game.advanceTime();
            
            assertTrue(game.getPet().getHunger() > initialHunger, 
                "시간이 진행되면 배고픔이 증가해야 합니다");
            assertTrue(game.isGameRunning(), "펫이 살아있으면 게임은 계속 진행되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testGameOverByDeath() {
        System.out.println("테스트 7: 펫 사망으로 게임 종료");
        try {
            Game game = new GameImpl();
            game.start("테스트펫");
            
            // 펫을 죽게 만듦
            for (int i = 0; i < 30; i++) {
                game.advanceTime();
            }
            
            assertFalse(game.getPet().isAlive(), "충분한 시간이 지나면 펫은 죽어야 합니다");
            assertFalse(game.isGameRunning(), "펫이 죽으면 게임은 종료되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    // Assert 메서드들
    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
    
    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }
    
    private static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " (예상: " + expected + ", 실제: " + actual + ")");
        }
    }
    
    private static void assertNull(Object obj, String message) {
        if (obj != null) {
            throw new AssertionError(message);
        }
    }
    
    private static void assertNotNull(Object obj, String message) {
        if (obj == null) {
            throw new AssertionError(message);
        }
    }
    
    private static void passed() {
        testCount++;
        passedCount++;
        System.out.println("   ✓ 통과\n");
    }
    
    private static void failed(Exception e) {
        testCount++;
        System.out.println("   ✗ 실패: " + e.getMessage() + "\n");
    }
}
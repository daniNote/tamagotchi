package tamagotchi;

/**
 * Pet 구현체를 테스트하는 클래스
 * 학생들은 모든 테스트를 통과하도록 PetImpl을 구현해야 합니다.
 */
public class PetTestSample {
    
    private static int testCount = 0;
    private static int passedCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== 다마고치 Pet 테스트 시작 ===\n");
        
        PetTestSample test = new PetTestSample();
        
        test.testInitialState();
        test.testFeed();
        test.testPlay();
        test.testPlayWithLowEnergy();
        test.testSleep();
        test.testTimePasses();
        test.testDeathByHunger();
        test.testDeathByUnhappiness();
        test.testMultipleActions();
        
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println("총 " + testCount + "개 중 " + passedCount + "개 통과");
        
        if (passedCount == testCount) {
            System.out.println("모든 테스트를 통과했습니다! 🎉");
        } else {
            System.out.println("일부 테스트가 실패했습니다. 구현을 다시 확인해주세요.");
        }
    }
    
    private void testInitialState() {
        System.out.println("테스트 1: 초기 상태 확인");
        try {
            Pet pet = new PetImplSample("타마");
            
            assertEquals("타마", pet.getName(), "이름이 올바르게 설정되어야 합니다");
            assertEquals(50, pet.getHunger(), "초기 배고픔은 50이어야 합니다");
            assertEquals(50, pet.getHappiness(), "초기 행복도는 50이어야 합니다");
            assertEquals(50, pet.getEnergy(), "초기 에너지는 50이어야 합니다");
            assertTrue(pet.isAlive(), "새로 생성된 펫은 살아있어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testFeed() {
        System.out.println("테스트 2: 먹이주기 기능");
        try {
            Pet pet = new PetImplSample("타마");
            int initialHunger = pet.getHunger();
            int initialHappiness = pet.getHappiness();
            
            pet.feed();
            
            assertTrue(pet.getHunger() < initialHunger, "먹이를 주면 배고픔이 감소해야 합니다");
            assertTrue(pet.getHappiness() > initialHappiness, "먹이를 주면 행복도가 증가해야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testPlay() {
        System.out.println("테스트 3: 놀아주기 기능");
        try {
            Pet pet = new PetImplSample("타마");
            int initialHappiness = pet.getHappiness();
            int initialEnergy = pet.getEnergy();
            
            pet.play();
            
            assertTrue(pet.getHappiness() > initialHappiness, "놀아주면 행복도가 증가해야 합니다");
            assertTrue(pet.getEnergy() < initialEnergy, "놀아주면 에너지가 감소해야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testPlayWithLowEnergy() {
        System.out.println("테스트 4: 에너지 부족 시 놀아주기");
        try {
            Pet pet = new PetImplSample("타마");
            
            // 에너지를 낮춤
            for (int i = 0; i < 5; i++) {
                pet.play();
            }
            
            int lowEnergyHappiness = pet.getHappiness();
            pet.play(); // 에너지가 부족한 상태에서 놀아주기
            
            assertTrue(pet.getHappiness() <= lowEnergyHappiness, 
                "에너지가 부족하면 놀 수 없어 행복도가 감소하거나 유지되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testSleep() {
        System.out.println("테스트 5: 재우기 기능");
        try {
            Pet pet = new PetImplSample("타마");
            pet.play(); // 에너지 소모
            int initialEnergy = pet.getEnergy();
            
            pet.sleep();
            
            assertTrue(pet.getEnergy() > initialEnergy, "잠을 자면 에너지가 회복되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testTimePasses() {
        System.out.println("테스트 6: 시간 경과");
        try {
            Pet pet = new PetImplSample("타마");
            int initialHunger = pet.getHunger();
            int initialHappiness = pet.getHappiness();
            int initialEnergy = pet.getEnergy();
            
            pet.timePasses();
            
            assertTrue(pet.getHunger() > initialHunger, "시간이 지나면 배고픔이 증가해야 합니다");
            assertTrue(pet.getHappiness() < initialHappiness, "시간이 지나면 행복도가 감소해야 합니다");
            assertTrue(pet.getEnergy() < initialEnergy, "시간이 지나면 에너지가 감소해야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testDeathByHunger() {
        System.out.println("테스트 7: 배고픔으로 인한 사망");
        try {
            Pet pet = new PetImplSample("타마");
            
            // 배고픔을 100까지 증가시킴
            for (int i = 0; i < 20; i++) {
                pet.timePasses();
            }
            
            assertFalse(pet.isAlive(), "배고픔이 100이 되면 펫은 죽어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testDeathByUnhappiness() {
        System.out.println("테스트 8: 불행으로 인한 사망");
        try {
            Pet pet = new PetImplSample("타마");
            
            // 에너지를 0으로 만들고 계속 놀아달라고 함
            for (int i = 0; i < 5; i++) {
                pet.play();
            }
            
            // 에너지가 부족한 상태에서 계속 놀아달라고 하면 행복도가 감소
            for (int i = 0; i < 20; i++) {
                pet.play();
                pet.timePasses();
            }
            
            assertFalse(pet.isAlive(), "행복도가 0이 되면 펫은 죽어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    private void testMultipleActions() {
        System.out.println("테스트 9: 복합적인 행동");
        try {
            Pet pet = new PetImplSample("타마");
            
            // 여러 행동을 수행
            pet.feed();
            pet.play();
            pet.sleep();
            pet.timePasses();
            pet.feed();
            
            assertTrue(pet.isAlive(), "적절한 관리로 펫은 살아있어야 합니다");
            assertTrue(pet.getHunger() < 100, "배고픔이 적절히 관리되어야 합니다");
            assertTrue(pet.getHappiness() > 0, "행복도가 적절히 관리되어야 합니다");
            assertTrue(pet.getEnergy() > 0, "에너지가 적절히 관리되어야 합니다");
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    
    // 간단한 assert 메서드들
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
    
    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " (예상: " + expected + ", 실제: " + actual + ")");
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
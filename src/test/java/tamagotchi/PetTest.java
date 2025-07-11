package tamagotchi;

/**
 * Pet 구현체를 테스트하는 클래스
 * 학생들은 PetImpl을 구현한 후 이 테스트를 실행하여 올바르게 동작하는지 확인할 수 있습니다.
 * 
 * 실행 방법:
 * javac -cp src/main/java src/main/java/tamagotchi/*.java src/test/java/tamagotchi/*.java
 * java -cp src/main/java:src/test/java test.java.tamagotchi.PetTest
 */
public class PetTest {
    
    private static int testCount = 0;
    private static int passedCount = 0;
    
    public static void main(String[] args) {
        System.out.println("=== 다마고치 Pet 테스트 시작 ===\n");
        
        PetTest test = new PetTest();
        
        // TODO: 테스트 메서드들을 호출하세요
        // 예: test.testInitialState();
        
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println("총 " + testCount + "개 중 " + passedCount + "개 통과");
        
        if (passedCount == testCount) {
            System.out.println("모든 테스트를 통과했습니다! 🎉");
        } else {
            System.out.println("일부 테스트가 실패했습니다. 구현을 다시 확인해주세요.");
        }
    }
    
    // TODO: 여기에 테스트 메서드들을 작성하세요
    // 힌트: PetTestSample.java를 참고하되, PetImpl을 사용하세요
    
    /*
    private void testInitialState() {
        System.out.println("테스트 1: 초기 상태 확인");
        try {
            // TODO: Pet 객체를 생성하고 초기 상태를 확인하세요
            
            passed();
        } catch (Exception e) {
            failed(e);
        }
    }
    */
    
    // 간단한 assert 메서드들 (이미 구현되어 있음)
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
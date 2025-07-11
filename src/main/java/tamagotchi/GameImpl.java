package tamagotchi;

/**
 * Game 인터페이스 구현체
 * 학생들이 이 클래스를 완성해야 합니다.
 * 
 * 구현 팁:
 * - Pet 객체를 생성하고 관리해야 합니다
 * - 게임 상태를 추적해야 합니다
 * - 사용자에게 적절한 피드백을 제공해야 합니다
 */
public class GameImpl implements Game {
    
    // TODO: 필요한 인스턴스 변수들을 선언하세요
    // 힌트: Pet 객체, 게임 실행 상태, 시간 카운터 등
    
    public GameImpl() {
        // TODO: 생성자를 구현하세요
        // 힌트: 초기값들을 설정하세요
    }
    
    @Override
    public void start(String petName) {
        // TODO: 게임 시작 로직을 구현하세요
        // 힌트: Pet 객체를 생성하고, 게임 상태를 시작으로 설정하세요
    }
    
    @Override
    public void displayStatus() {
        // TODO: 펫의 현재 상태를 출력하세요
        // 힌트: 배고픔, 행복도, 에너지, 생존 상태 등을 보여주세요
    }
    
    @Override
    public void feedPet() {
        // TODO: 펫에게 먹이 주기를 구현하세요
        // 힌트: 게임 상태를 확인하고, pet.feed()를 호출하세요
    }
    
    @Override
    public void playWithPet() {
        // TODO: 펫과 놀아주기를 구현하세요
        // 힌트: 에너지가 충분한지 확인하고, pet.play()를 호출하세요
    }
    
    @Override
    public void putPetToSleep() {
        // TODO: 펫 재우기를 구현하세요
        // 힌트: pet.sleep()을 호출하세요
    }
    
    @Override
    public void advanceTime() {
        // TODO: 시간 진행을 구현하세요
        // 힌트: 시간 카운터를 증가시키고, pet.timePasses()를 호출하세요
        // 펫이 죽었는지 확인하고 게임 종료 처리를 하세요
    }
    
    @Override
    public Pet getPet() {
        // TODO: 현재 펫 객체를 반환하세요
        return null;
    }
    
    @Override
    public boolean isGameRunning() {
        // TODO: 게임이 실행 중인지 반환하세요
        return false;
    }
    
    // TODO: 필요한 private 메서드들을 추가하세요
    // 예: checkGameState(), getStatusBar() 등
}
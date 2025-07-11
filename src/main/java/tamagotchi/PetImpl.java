package tamagotchi;

/**
 * Pet 인터페이스 구현체
 * 학생들이 이 클래스를 완성해야 합니다.
 * 
 * 구현 팁:
 * - 생성자에서 초기값을 설정하세요
 * - 각 행동은 펫의 상태를 변경해야 합니다
 * - 상태값은 0-100 범위를 유지해야 합니다
 * - 배고픔이 100이 되거나 행복도가 0이 되면 펫은 죽습니다
 */
public class PetImpl implements Pet {
    
    // TODO: 필요한 인스턴스 변수들을 선언하세요
    
    public PetImpl(String name) {
        // TODO: 생성자를 구현하세요
        // 힌트: 이름을 저장하고, 초기 상태값들을 설정하세요
    }
    
    @Override
    public void feed() {
        // TODO: 먹이주기 기능을 구현하세요
        // 힌트: 배고픔을 감소시키고 행복도를 증가시키세요
    }
    
    @Override
    public void play() {
        // TODO: 놀아주기 기능을 구현하세요
        // 힌트: 에너지가 충분한지 확인하고, 행복도를 증가시키고 에너지를 감소시키세요
    }
    
    @Override
    public void sleep() {
        // TODO: 재우기 기능을 구현하세요
        // 힌트: 에너지를 회복시키세요
    }
    
    @Override
    public String getName() {
        // TODO: 펫의 이름을 반환하세요
        return null;
    }
    
    @Override
    public int getHunger() {
        // TODO: 현재 배고픔 수치를 반환하세요
        return 0;
    }
    
    @Override
    public int getHappiness() {
        // TODO: 현재 행복도를 반환하세요
        return 0;
    }
    
    @Override
    public int getEnergy() {
        // TODO: 현재 에너지를 반환하세요
        return 0;
    }
    
    @Override
    public boolean isAlive() {
        // TODO: 펫이 살아있는지 반환하세요
        return true;
    }
    
    @Override
    public void timePasses() {
        // TODO: 시간 경과에 따른 상태 변화를 구현하세요
        // 힌트: 배고픔은 증가하고, 행복도와 에너지는 감소합니다
    }
    
    // TODO: 필요한 private 메서드들을 추가하세요
    // 예: checkHealth() 메서드로 펫의 생존 상태를 확인하는 것을 권장합니다
}
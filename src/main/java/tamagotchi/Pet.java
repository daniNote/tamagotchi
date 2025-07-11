package tamagotchi;

/**
 * 다마고치 펫 인터페이스
 * 학생들이 구현해야 할 기본적인 다마고치 기능을 정의합니다.
 */
public interface Pet {
    
    /**
     * 펫에게 먹이를 줍니다.
     * 배고픔 수치를 감소시키고 행복도를 증가시킵니다.
     */
    void feed();
    
    /**
     * 펫과 놀아줍니다.
     * 행복도를 증가시키고 에너지를 감소시킵니다.
     */
    void play();
    
    /**
     * 펫을 재웁니다.
     * 에너지를 회복시킵니다.
     */
    void sleep();
    
    /**
     * 펫의 이름을 반환합니다.
     * @return 펫의 이름
     */
    String getName();
    
    /**
     * 펫의 배고픔 수치를 반환합니다.
     * @return 배고픔 수치 (0-100, 100이 가장 배고픈 상태)
     */
    int getHunger();
    
    /**
     * 펫의 행복도를 반환합니다.
     * @return 행복도 (0-100, 100이 가장 행복한 상태)
     */
    int getHappiness();
    
    /**
     * 펫의 에너지를 반환합니다.
     * @return 에너지 (0-100, 100이 가장 활력있는 상태)
     */
    int getEnergy();
    
    /**
     * 펫이 살아있는지 확인합니다.
     * @return 살아있으면 true, 죽었으면 false
     */
    boolean isAlive();
    
    /**
     * 시간 경과에 따른 상태 변화를 적용합니다.
     * 배고픔이 증가하고, 행복도와 에너지가 감소합니다.
     */
    void timePasses();
}
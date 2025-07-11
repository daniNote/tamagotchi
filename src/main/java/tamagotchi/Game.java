package tamagotchi;

/**
 * 다마고치 게임 인터페이스
 * 게임의 기본 흐름과 상태를 관리합니다.
 */
public interface Game {
    
    /**
     * 게임을 시작합니다.
     * 펫을 생성하고 게임 루프를 시작합니다.
     * @param petName 펫의 이름
     */
    void start(String petName);
    
    /**
     * 현재 펫의 상태를 출력합니다.
     */
    void displayStatus();
    
    /**
     * 펫에게 먹이를 줍니다.
     */
    void feedPet();
    
    /**
     * 펫과 놀아줍니다.
     */
    void playWithPet();
    
    /**
     * 펫을 재웁니다.
     */
    void putPetToSleep();
    
    /**
     * 게임 시간을 진행시킵니다.
     * 일정 시간이 지나면 펫의 상태가 변화합니다.
     */
    void advanceTime();
    
    /**
     * 현재 펫 객체를 반환합니다.
     * @return 현재 게임의 펫
     */
    Pet getPet();
    
    /**
     * 게임이 계속 진행 중인지 확인합니다.
     * @return 게임이 진행 중이면 true, 끝났으면 false
     */
    boolean isGameRunning();
}
package tamagotchi;

/**
 * Game 인터페이스의 샘플 구현체
 * 다마고치 게임의 기본 로직을 구현합니다.
 */
public class GameImplSample implements Game {
    
    private Pet pet;
    private boolean gameRunning;
    private int timeCounter;
    
    public GameImplSample() {
        this.gameRunning = false;
        this.timeCounter = 0;
    }
    
    @Override
    public void start(String petName) {
        this.pet = new PetImplSample(petName);
        this.gameRunning = true;
        System.out.println("\n🥚 다마고치 " + petName + "이(가) 태어났습니다!");
        displayStatus();
    }
    
    @Override
    public void displayStatus() {
        if (pet == null) {
            System.out.println("아직 펫이 없습니다. 게임을 시작해주세요.");
            return;
        }
        
        System.out.println("\n===== " + pet.getName() + "의 상태 =====");
        System.out.println("배고픔: " + getStatusBar(pet.getHunger()) + " " + pet.getHunger() + "/100");
        System.out.println("행복도: " + getStatusBar(pet.getHappiness()) + " " + pet.getHappiness() + "/100");
        System.out.println("에너지: " + getStatusBar(pet.getEnergy()) + " " + pet.getEnergy() + "/100");
        System.out.println("상태: " + getPetCondition());
        System.out.println("시간: " + timeCounter + " 턴");
        System.out.println("========================\n");
    }
    
    @Override
    public void feedPet() {
        if (!checkGameState()) return;
        
        pet.feed();
        System.out.println("🍎 " + pet.getName() + "에게 먹이를 주었습니다!");
        displayStatus();
    }
    
    @Override
    public void playWithPet() {
        if (!checkGameState()) return;
        
        if (pet.getEnergy() < 20) {
            System.out.println("😴 " + pet.getName() + "이(가) 너무 피곤해서 놀 수 없습니다.");
        } else {
            pet.play();
            System.out.println("🎾 " + pet.getName() + "과(와) 놀아주었습니다!");
        }
        displayStatus();
    }
    
    @Override
    public void putPetToSleep() {
        if (!checkGameState()) return;
        
        pet.sleep();
        System.out.println("😴 " + pet.getName() + "이(가) 잠을 잡니다... Zzz");
        displayStatus();
    }
    
    @Override
    public void advanceTime() {
        if (!checkGameState()) return;
        
        timeCounter++;
        pet.timePasses();
        
        if (!pet.isAlive()) {
            gameRunning = false;
            System.out.println("\n💔 " + pet.getName() + "이(가) 하늘나라로 떠났습니다...");
            System.out.println("게임을 " + timeCounter + " 턴 동안 플레이했습니다.");
        }
    }
    
    @Override
    public Pet getPet() {
        return pet;
    }
    
    @Override
    public boolean isGameRunning() {
        return gameRunning;
    }
    
    private boolean checkGameState() {
        if (pet == null) {
            System.out.println("먼저 게임을 시작해주세요!");
            return false;
        }
        if (!pet.isAlive()) {
            System.out.println("펫이 이미 죽었습니다. 새 게임을 시작해주세요.");
            return false;
        }
        return true;
    }
    
    private String getStatusBar(int value) {
        int filled = value / 10;
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            if (i < filled) {
                bar.append("■");
            } else {
                bar.append("□");
            }
        }
        bar.append("]");
        return bar.toString();
    }
    
    private String getPetCondition() {
        if (!pet.isAlive()) {
            return "💀 죽음";
        }
        
        int hunger = pet.getHunger();
        int happiness = pet.getHappiness();
        int energy = pet.getEnergy();
        
        // 완벽한 상태 (가장 좋은 상태부터 체크)
        if (hunger <= 10 && happiness >= 90 && energy >= 90) {
            return "🤩 완벽함!";
        }
        
        // 매우 좋은 상태
        if (hunger <= 20 && happiness >= 80 && energy >= 80) {
            return "😄 매우 좋음";
        }
        
        // 좋은 상태
        if (hunger <= 30 && happiness >= 70 && energy >= 70) {
            return "😊 좋음";
        }
        
        // 위험 상태 체크 (가장 나쁜 상태)
        if (hunger >= 90 || happiness <= 10) {
            return "🚨 위험! 즉시 돌봐주세요!";
        }
        
        // 매우 나쁜 상태
        if (hunger >= 80 || happiness <= 20 || energy <= 10) {
            return "😰 매우 나쁨";
        }
        
        // 나쁜 상태
        if (hunger >= 70 || happiness <= 30 || energy <= 20) {
            return "😢 나쁨";
        }
        
        // 특정 상태 체크
        if (energy <= 30) {
            return "😴 피곤함";
        }
        
        if (hunger >= 60) {
            return "🤤 배고픔";
        }
        
        if (happiness <= 40) {
            return "😔 슬픔";
        }
        
        // 보통 상태
        return "😐 보통";
    }
}
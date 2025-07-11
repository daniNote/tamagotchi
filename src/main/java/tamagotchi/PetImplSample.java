package tamagotchi;

/**
 * Pet 인터페이스의 샘플 구현체
 * 이 코드는 테스트 및 빌드 확인용입니다.
 * 학생들은 PetImpl.java를 이와 유사하게 구현해야 합니다.
 */
public class PetImplSample implements Pet {
    
    private String name;
    private int hunger;
    private int happiness;
    private int energy;
    private boolean alive;
    
    public PetImplSample(String name) {
        this.name = name;
        this.hunger = 50;      // 중간 정도의 배고픔
        this.happiness = 50;   // 중간 정도의 행복
        this.energy = 50;      // 중간 정도의 에너지
        this.alive = true;
    }
    
    @Override
    public void feed() {
        if (!alive) return;
        
        hunger = Math.max(0, hunger - 20);
        happiness = Math.min(100, happiness + 10);
        checkHealth();
    }
    
    @Override
    public void play() {
        if (!alive) return;
        
        if (energy < 20) {
            // 에너지가 부족하면 놀 수 없음
            happiness = Math.max(0, happiness - 5);
        } else {
            happiness = Math.min(100, happiness + 20);
            energy = Math.max(0, energy - 15);
            hunger = Math.min(100, hunger + 10);
        }
        checkHealth();
    }
    
    @Override
    public void sleep() {
        if (!alive) return;
        
        energy = Math.min(100, energy + 30);
        hunger = Math.min(100, hunger + 10);
        checkHealth();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getHunger() {
        return hunger;
    }
    
    @Override
    public int getHappiness() {
        return happiness;
    }
    
    @Override
    public int getEnergy() {
        return energy;
    }
    
    @Override
    public boolean isAlive() {
        return alive;
    }
    
    @Override
    public void timePasses() {
        if (!alive) return;
        
        hunger = Math.min(100, hunger + 5);
        happiness = Math.max(0, happiness - 3);
        energy = Math.max(0, energy - 2);
        
        checkHealth();
    }
    
    private void checkHealth() {
        // 배고픔이 100이거나 행복도가 0이면 죽음
        if (hunger >= 100 || happiness <= 0) {
            alive = false;
        }
    }
}
# 다마고치 게임 프로젝트

자바 기초 교육을 위한 다마고치 게임 프로젝트입니다. 학생들은 주어진 인터페이스를 구현하여 완전한 다마고치 게임을 만들 수 있습니다.

## 프로젝트 구조

```
tamagotchi/
├── src/
│   ├── main/java/tamagotchi/
│   │   ├── Pet.java              # Pet 인터페이스 (제공됨)
│   │   ├── PetImpl.java          # Pet 구현체 (학생이 구현)
│   │   ├── PetImplSample.java    # Pet 구현 샘플 (참고용)
│   │   ├── Game.java             # Game 인터페이스 (제공됨)
│   │   ├── GameImpl.java         # Game 구현체 (학생이 구현)
│   │   ├── GameImplSample.java   # Game 구현 샘플 (참고용)
│   │   ├── Main.java             # 메인 클래스 (학생이 구현)
│   │   └── MainSample.java       # 메인 클래스 샘플 (참고용)
│   └── test/java/tamagotchi/
│       ├── PetTest.java          # Pet 테스트 (학생이 작성)
│       ├── PetTestSample.java    # Pet 테스트 샘플 (참고용)
│       └── GameTestSample.java   # Game 테스트 샘플 (참고용)
└── README.md
```

## 게임 규칙

### 펫의 상태
- **배고픔 (Hunger)**: 0-100 (100이 가장 배고픈 상태)
- **행복도 (Happiness)**: 0-100 (100이 가장 행복한 상태)
- **에너지 (Energy)**: 0-100 (100이 가장 활력있는 상태)

### 행동의 효과
1. **먹이주기 (Feed)**
   - 배고픔 -20
   - 행복도 +10

2. **놀아주기 (Play)**
   - 에너지가 20 이상일 때:
     - 행복도 +20
     - 에너지 -15
     - 배고픔 +10
   - 에너지가 부족할 때:
     - 행복도 -5

3. **재우기 (Sleep)**
   - 에너지 +30
   - 배고픔 +10

4. **시간 경과 (Time Passes)**
   - 배고픔 +5
   - 행복도 -3
   - 에너지 -2

### 게임 종료 조건
- 배고픔이 100이 되면 펫이 죽습니다
- 행복도가 0이 되면 펫이 죽습니다

## 구현 과제

### 1단계: Pet 인터페이스 구현
`PetImpl.java` 파일을 완성하세요:
- 모든 메서드를 구현
- 상태값은 0-100 범위 유지
- 죽음 조건 확인 로직 추가

### 2단계: Game 인터페이스 구현
`GameImpl.java` 파일을 완성하세요:
- Pet 객체 관리
- 게임 상태 추적
- 사용자 피드백 제공

### 3단계: Main 클래스 구현
`Main.java` 파일을 완성하세요:
- 사용자 입력 처리
- 게임 루프 구현
- 메뉴 시스템 구현

### 4단계: 테스트 작성 (선택사항)
`PetTest.java` 파일에 테스트를 작성하세요:
- 다양한 시나리오 테스트
- 경계값 테스트

## 컴파일 및 실행 방법

### 컴파일
```bash
# 모든 자바 파일 컴파일
javac -cp src/main/java src/main/java/tamagotchi/*.java

# 테스트 파일도 함께 컴파일
javac -cp src/main/java src/main/java/tamagotchi/*.java src/test/java/tamagotchi/*.java
```

### 실행
```bash
# 샘플 게임 실행
java -cp src/main/java main.java.tamagotchi.MainSample

# 학생이 구현한 게임 실행
java -cp src/main/java main.java.tamagotchi.Main

# 샘플 테스트 실행
java -cp src/main/java:src/test/java test.java.tamagotchi.PetTestSample

# 학생이 작성한 테스트 실행
java -cp src/main/java:src/test/java test.java.tamagotchi.PetTest
```

## 학습 목표

이 프로젝트를 통해 다음을 학습할 수 있습니다:
- 객체지향 프로그래밍 기초 (클래스, 인터페이스)
- 상태 관리와 캡슐화
- 메서드 구현과 로직 설계
- 사용자 입력 처리
- 테스트 작성 기초
- 프로그램 흐름 제어

## 도전 과제 (선택사항)

기본 구현을 완료한 후 도전해볼 수 있는 과제들:
1. 펫의 나이 추가 (시간이 지날수록 증가)
2. 다양한 펫 종류 추가 (각기 다른 특성)
3. 저장/불러오기 기능
4. 펫의 진화 시스템
5. 미니게임 추가 (가위바위보 등)
6. GUI 버전 만들기

## 평가 기준

- 모든 인터페이스 메서드가 올바르게 구현되었는가?
- 게임 규칙이 정확히 구현되었는가?
- 코드가 깔끔하고 읽기 쉬운가?
- 예외 상황을 적절히 처리하는가?
- (보너스) 창의적인 기능을 추가했는가?
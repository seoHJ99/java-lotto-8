package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;
    private static final String ERROR = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public BonusNumber(int bonusNumber) {
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ERROR);
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

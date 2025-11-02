package lotto.domain;

import lotto.exception.LottoNumberRangeException;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoNumberRangeException();
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

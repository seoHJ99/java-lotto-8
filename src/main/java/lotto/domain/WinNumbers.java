package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoNumberSizeException;

import java.util.List;

public class WinNumbers {

    private final List<Integer> winNumber;
    private BonusNumber bonusNumber;

    public WinNumbers(List<Integer> winNumber) {
        if (!validateNumberSize(winNumber, Lotto.LOTTO_NUMBER_SIZE)) {
            throw new LottoNumberSizeException();
        }

        if (!validateAllRanges(winNumber)) {
            throw new LottoNumberRangeException();
        }

        if (!validateDuplicateNumber(winNumber)) {
            throw new LottoNumberDuplicateException();
        }

        this.winNumber = winNumber;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        for (int num : winNumber) {
            if (num == bonusNumber.getBonusNumber()) {
                throw new LottoNumberDuplicateException();
            }
        }
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNum() {
        return bonusNumber.getBonusNumber();
    }

    private boolean validateAllRanges(List<Integer> numberss) {
        return !numberss.stream()
                .anyMatch(num -> num < 1 || num > 45);
    }

    private boolean validateNumberSize(List numberss, int size) {
        if (numberss.size() != size) {
            return false;
        }
        return true;
    }

    private boolean validateDuplicateNumber(List<Integer> winNumber) {
        if (winNumber.stream().distinct().count() != Lotto.LOTTO_NUMBER_SIZE) {
            return false;
        }
        return true;
    }
}

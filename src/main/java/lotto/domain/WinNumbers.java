package lotto.domain;

import java.util.List;

public class WinNumbers {

    private final List<Integer> winNumber;
    private BonusNumber bonusNumber;
    private static final int NUMBER_SIZE = 6;

    public WinNumbers(List<Integer> winNumber) {
        if(validateNumberSize(winNumber, NUMBER_SIZE)){
            throw new IllegalArgumentException();
        }

        if(validateAllRanges(winNumber)){
         throw new IllegalArgumentException();
        }

        this.winNumber = winNumber;
    }

    public void setBonusNumber(BonusNumber bonusNumber){
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
}

package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumbers {

    private final List<Integer> winNumber;
    private BonusNumber bonusNumber;
    private static final int NUMBER_SIZE = 6;
    private static final String NUMBER_SIZE_ERROR ="당첨 숫자는 6개 입니다.";
    private static final String NUMBER_RANGE_ERROR ="로또 숫자는 1-45사이의 숫자입니다.";
    private static final String NUMBER_DUPLICATE_ERROR ="로또 숫자는 중복될 수 없습니다.";

    public WinNumbers(List<Integer> winNumber) {
        if(!validateNumberSize(winNumber, NUMBER_SIZE)){
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR);
        }

        if(!validateAllRanges(winNumber)){
         throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }

        if(!validateDuplicateNumber(winNumber)){
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR);
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

    private boolean validateDuplicateNumber(List<Integer> winNumber){
        Set<Integer> numberSet = new HashSet<>(winNumber);
        if(numberSet.size() != winNumber.size()){
            return false;
        }
        return true;
    }
}

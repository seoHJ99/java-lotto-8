package lotto.domain;

import java.util.List;

public class WinNumbers {

    private final List<Integer> winNumber;
    private final BonusNumber bonusNumber;

    public WinNumbers(List<Integer> winNumber, int bonusNumber){
        this.winNumber = winNumber;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Integer> getWinNumber(){
        return winNumber;
    }

    public int getBonusNum(){
        return bonusNumber.getBonusNumber();
    }
}

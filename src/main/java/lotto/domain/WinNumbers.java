package lotto.domain;

import java.util.List;

public class WinNumbers {

    private final List<Integer> winNumber;
    private final int bonusNum;

    public WinNumbers(List<Integer> winNumber, int bonusNum){
        this.winNumber = winNumber;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getWinNumber(){
        return winNumber;
    }

    public int getBonusNum(){
        return bonusNum;
    }
}

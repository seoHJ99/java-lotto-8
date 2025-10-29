package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinNumbers;

import java.util.List;

public class LottoStore {

    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sellLotto(int money) {
        if (!isDivisibleByThousand(money))
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로만 입력해야 합니다.");
        return lottoGenerator.create(money / 1000);
    }

    private boolean isDivisibleByThousand(int num) {
        if (num % 1000 != 0)
            return false;
        return true;
    }

    private boolean isNaturalNum(int num) {
        if (num < 1)
            return false;
        return true;
    }

    public LottoRank getLottoRank(Lotto lotto, WinNumbers winNumbers){
        int correctCount = getMatchingCount(lotto, winNumbers);
        boolean bonusMatching = isBonusMatching(lotto, winNumbers);
        return LottoRank.getRank(correctCount, bonusMatching);
    }

    private boolean isBonusMatching(Lotto lotto, WinNumbers winNumbers){
        if(hasNum(lotto.getNumbers(), winNumbers.getBonusNum()))
            return true;
        return false;
    }

    private int getMatchingCount(Lotto lotto, WinNumbers winNumbers){
        int correctCount = 0;

        for (int num: lotto.getNumbers()) {
            if(hasNum(winNumbers.getWinNumber(), num)){
                correctCount++;
            }
        }
        return correctCount;
    }

    private boolean hasNum(List<Integer> nums, int compareNum) {
        if (nums.contains(compareNum))
            return true;
        return false;
    }
}

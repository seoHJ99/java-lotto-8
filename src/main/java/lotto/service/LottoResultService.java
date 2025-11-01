package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    public double getEarningRate(int spendMoney, Map<LottoRank, Integer> lottoRanks) {
        double rate = (double) sumAllPrize(lottoRanks) / spendMoney * 100;
        double rounded = Math.round(rate * 10) / 10.0;
        return rounded;
    }

    private long sumAllPrize(Map<LottoRank, Integer> lottoRanks) {
        return lottoRanks.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private LottoRank getLottoResult(Lotto lotto, WinNumbers winNumbers) {
        int correctCount = getMatchingCount(lotto, winNumbers);
        boolean bonusMatching = isBonusMatching(lotto, winNumbers);
        return LottoRank.getRank(correctCount, bonusMatching);
    }

    public Map<LottoRank, Integer> getAllLottoResult(List<Lotto> lottos, WinNumbers winNumbers) {
        Map<LottoRank, Integer> lottoRanks = new HashMap<>();

        for (Lotto lotto : lottos) {
            LottoRank rank = getLottoResult(lotto, winNumbers);
            int count = lottoRanks.getOrDefault(rank, 0);
            lottoRanks.put(rank, count + 1);
        }
        return lottoRanks;
    }

    private boolean isBonusMatching(Lotto lotto, WinNumbers winNumbers) {
        if (hasNum(lotto.getNumbers(), winNumbers.getBonusNum()))
            return true;
        return false;
    }

    private int getMatchingCount(Lotto lotto, WinNumbers winNumbers) {
        int correctCount = 0;

        for (int num : lotto.getNumbers()) {
            if (hasNum(winNumbers.getWinNumber(), num)) {
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

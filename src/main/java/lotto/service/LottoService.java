package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinNumbers;

import java.util.List;

public class LottoService {

    private final LottoSellerService lottoSellerService;
    private final LottoResultService lottoResultService;

    public LottoService(LottoSellerService lottoSellerService, LottoResultService lottoResultService){
        this.lottoSellerService = lottoSellerService;
        this.lottoResultService = lottoResultService;
    }

    public double buyLottoAndCalculateEarningRate(int purchaseMoney, WinNumbers winNumbers){
        List<Lotto> lottos = lottoSellerService.buyLotto(purchaseMoney);
        long sumPrize = lottoResultService.sumAllPrize(lottos, winNumbers);
        return getRaiseRates(purchaseMoney, sumPrize);
    }

    private double getRaiseRates(int original, long after) {
        double rate = (double) after / original * 100;
        double rounded = Math.round(rate * 10) / 10.0;
        return rounded;
    }
}

package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public class LottoSellerService {

    private final LottoGenerator lottoGenerator;

    public LottoSellerService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(int money) {
        return lottoGenerator.create(money / 1000);
    }


    private boolean isNaturalNum(int num) {
        if (num < 1)
            return false;
        return true;
    }
}

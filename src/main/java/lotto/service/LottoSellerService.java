package lotto.service;

import lotto.domain.BuyMoney;
import lotto.domain.Lotto;

import java.util.List;

public class LottoSellerService {

    private final LottoGenerator lottoGenerator;

    public LottoSellerService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(BuyMoney money) {
        return lottoGenerator.create(money.getMoney() / 1000);
    }


    private boolean isNaturalNum(int num) {
        if (num < 1)
            return false;
        return true;
    }
}

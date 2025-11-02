package lotto.service;

import lotto.domain.BuyMoney;
import lotto.domain.Lotto;

import java.util.List;

public class LottoSellerService {

    private final LottoGeneratorService lottoGeneratorService;

    public LottoSellerService(LottoGeneratorService lottoGeneratorService) {
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public List<Lotto> buyLotto(BuyMoney money) {
        return lottoGeneratorService.create(money.getMoney() / 1000);
    }

}

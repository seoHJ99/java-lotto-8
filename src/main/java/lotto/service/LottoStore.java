package lotto.service;

import lotto.domain.Lotto;

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

    private boolean isNaturalNum(int num){
        if(num < 1)
            return false;
        return true;
    }
}

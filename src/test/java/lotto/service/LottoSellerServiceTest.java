package lotto.service;

import lotto.domain.BuyMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSellerServiceTest {

    private LottoSellerService lottoSellerService;

    @BeforeEach
    void init() {
        lottoSellerService = new LottoSellerService(new LottoGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {3000, 10000})
    void 로또_판매_기능_테스트(int money) {
        BuyMoney buyMoney = new BuyMoney(money);
        assertThat(lottoSellerService.buyLotto(buyMoney).size()).isEqualTo(3);
        assertThat(lottoSellerService.buyLotto(buyMoney).size()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {11000, 200})
    void 로또_판매_예외_테스트(int money) {
        BuyMoney buyMoney = new BuyMoney(money);
        assertThatThrownBy(() -> lottoSellerService.buyLotto(buyMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

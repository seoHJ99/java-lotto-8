package lotto.service;

import lotto.domain.BuyMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @CsvSource({
            "3000, 3",
            "10000, 10"
    })
    void 로또_판매_기능_테스트(int money, int count) {
        BuyMoney buyMoney = new BuyMoney(money);
        assertThat(lottoSellerService.buyLotto(buyMoney).size())
                .isEqualTo(count);
    }
}

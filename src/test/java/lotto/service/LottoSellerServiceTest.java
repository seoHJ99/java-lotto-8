package lotto.service;

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

    @Test
    void 로또_판매_기능_테스트() {
        assertThat(lottoSellerService.buyLotto(3000).size()).isEqualTo(3);
        assertThat(lottoSellerService.buyLotto(10000).size()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {11000, 200})
    void 로또_판매_예외_테스트() {
        assertThatThrownBy(() -> lottoSellerService.buyLotto(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}

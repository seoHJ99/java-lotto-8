package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BuyMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1100, 200})
    void 로또_판매_예외_테스트(int money) {

        assertThatThrownBy(() -> new BuyMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
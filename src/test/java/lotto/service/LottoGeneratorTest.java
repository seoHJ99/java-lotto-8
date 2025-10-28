package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void init() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 로또_다중_생성_테스트() {
        assertThat(lottoGenerator.create(1).size())
                .isEqualTo(1);
        assertThat(lottoGenerator.create(10).size())
                .isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 로또_생성_예외_테스트(int count) {
        assertThatThrownBy(() -> lottoGenerator.create(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}

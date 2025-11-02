package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinNumbersTest {

    @Test
    void 당첨번호는_숫자_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호에_중복_숫자가_있으면_예외가_발생한다() {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> new WinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 47})
    void 당첨번호_숫자는_(int num) {
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, num);
        assertThatThrownBy(() -> new WinNumbers(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
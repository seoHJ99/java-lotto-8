package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.LottoNumberSizeException;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberSizeException();
        }

        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberDuplicateException();
        }

        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(num -> num < 1 || num > 45);
        if (hasInvalidNumber) {
            throw new LottoNumberRangeException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

package lotto.domain;

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
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }

        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(num -> num < 1 || num > 45);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    @Override
    public String toString(){
        return numbers.toString();
    }
}

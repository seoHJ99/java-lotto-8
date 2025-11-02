package lotto.exception;

public class LottoNumberRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또 숫자는 1-45사이의 숫자입니다.";

    public LottoNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}

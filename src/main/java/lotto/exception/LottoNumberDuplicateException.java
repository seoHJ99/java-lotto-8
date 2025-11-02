package lotto.exception;

public class LottoNumberDuplicateException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "로또 숫자는 중복될 수 없습니다.";

    public LottoNumberDuplicateException() {
        super(ERROR_MESSAGE);
    }
}

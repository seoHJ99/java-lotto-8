package lotto.exception;

public class LottoNumberSizeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "당첨 숫자는 6개 입니다.";

    public LottoNumberSizeException() {
        super(ERROR_MESSAGE);
    }
}

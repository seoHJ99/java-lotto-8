package lotto;

import lotto.controller.LottoController;
import lotto.infra.InputView;
import lotto.infra.OutputView;
import lotto.service.LottoGenerator;
import lotto.service.LottoResultService;
import lotto.service.LottoSellerService;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        LottoSellerService lottoSellerService = new LottoSellerService(new LottoGenerator());
        LottoResultService lottoResultService = new LottoResultService();

        LottoController lottoController =
                new LottoController(
                        inputView,
                        outputView,
                        lottoSellerService,
                        lottoResultService);

        lottoController.run();
    }
}

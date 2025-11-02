package lotto.controller;

import lotto.domain.*;
import lotto.infra.InputView;
import lotto.infra.OutputView;
import lotto.service.LottoResultService;
import lotto.service.LottoSellerService;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoSellerService sellerService;
    private final LottoResultService resultService;

    public LottoController(InputView inputView, OutputView outputView, LottoSellerService sellerService, LottoResultService resultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.sellerService = sellerService;
        this.resultService = resultService;
    }

    public void run() {
        BuyMoney money = inputMoney();
        List<Lotto> lottos = sellerService.buyLotto(money);
        outputView.outputAllLotto(lottos);

        WinNumbers winNumbers = inputWinNum();
        inputBonusNum(winNumbers);

        Map<LottoRank, Integer> lottoRanks = resultService.getAllLottoResult(lottos, winNumbers);
        double earningRate = resultService.getEarningRate(money, lottoRanks);
        outputView.outputStatistics(lottoRanks);
        outputView.outputTotalEarningRate(earningRate);
    }

    private WinNumbers inputWinNum() {
        while (true) {
            try {
                List<Integer> numbers = inputView.inputWinNumbers();
                return new WinNumbers(numbers);
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private void inputBonusNum(WinNumbers winNumbers) {
        while (true) {
            try {
                int bonus = inputView.inputBonus();
                winNumbers.setBonusNumber(new BonusNumber(bonus));
                return;
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }

    private BuyMoney inputMoney() {
        while (true) {
            try {
                int money = inputView.inputMoney();
                return new BuyMoney(money);
            } catch (IllegalArgumentException ex) {
                outputView.outputError(ex.getMessage());
            }
        }
    }


}

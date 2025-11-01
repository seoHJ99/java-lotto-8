package lotto.infra;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String ERROR = "[ERROR] ";
    private static OutputView outputView;

    public static OutputView getInstance(){
        if(outputView == null){
            outputView = new OutputView();
        }
        return outputView;
    }

    public void outputError(String message) {
        System.out.println(ERROR + message);
    }

    public void outputAllLotto(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다.%n", lottos.size()));
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void outputStatistics(Map<LottoRank, Integer> lottoRanks) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계%n");
        sb.append("---%n");
        for (LottoRank rank : LottoRank.values()) {
            sb.append(String.format(
                    "%d개 일치 (%d원) - %d개%n",
                    rank.matchingCount,
                    rank.prize,
                    lottoRanks.getOrDefault(rank, 0)
            ));
        }
        System.out.println(sb);
    }

    public void outputTotalEarningRate(double earningRate){
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));
    }
}

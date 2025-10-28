package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

     public List<Lotto> create(int count){
         List<Lotto> lottos = new ArrayList<>();

         for(int i =0; i<count; i++){
             lottos.add(create());
         }
         return lottos;
     }

    private Lotto create(){
        return new Lotto(getSixNumber());
    }

    private List<Integer> getSixNumber(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}

package kr.co.woobi.imyeon.dustinfo.model.fine_dust;

import java.util.List;

public class Weather {
    private List<Dust> dust;

    public List<Dust> getDust() {
        return dust;
    }

    public void setDust(List<Dust> dust) {
        this.dust = dust;
    }
}

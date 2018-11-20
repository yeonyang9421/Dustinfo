package kr.co.woobi.imyeon.dustinfo.dust;

import kr.co.woobi.imyeon.dustinfo.model.fine_dust.FineDust;

public class FineDustContract {
   public interface View{
        void showFineDustResult(FineDust fineDust);
        void  showLoadError(String message);
        void  loadingStart();
        void loadingEnd();
        void reload(double lat, double lng);
    }
  public   interface  UserActionListener{
        void loadFinedustData();
    }
}

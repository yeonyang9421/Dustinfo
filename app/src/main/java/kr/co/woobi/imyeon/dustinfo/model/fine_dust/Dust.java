package kr.co.woobi.imyeon.dustinfo.model.fine_dust;

public class Dust {
     private Station station;
     private String timeObservation;
     private  Pm10 pm10;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getTimeObservation() {
        return timeObservation;
    }

    public void setTimeObservation(String timeObservation) {
        this.timeObservation = timeObservation;
    }

    public Pm10 getPm10() {
        return pm10;
    }

    public void setPm10(Pm10 pm10) {
        this.pm10 = pm10;
    }
}

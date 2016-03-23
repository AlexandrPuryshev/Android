package data;


import java.util.ArrayList;

public class Weather {
    private String timeFrom;
    private String timeTo;
    private double temperature;
    private String temperatureUnit;
    private int humidity;
    private String humUnit;
    private String cloudsName;


    public Weather(ArrayList<String> weather){
//            (String timeFrom, String timeTo, double temperature, String temperatureUnit,
//                   int humidity, String humUnit){

        this.timeFrom = weather.get(0).replace("T", " ");
        this.timeTo = weather.get(1).replace("T", " ");
        this.temperature = Double.parseDouble(weather.get(2));
        this.temperatureUnit = weather.get(3);
        this.humidity = Integer.parseInt(weather.get(4));
        this.humUnit = weather.get(5);
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getHumUnit() {
        return humUnit;
    }

    public void setHumUnit(String humUnit) {
        this.humUnit = humUnit;
    }

    public String getStringTime(){
        return "Time: " + timeFrom + " to " + timeTo;
    }

    public String getStringTemperature(){
        return String.valueOf(temperature) + " " + temperatureUnit;
    }

    public String getHumidityWithUnit() {
        return humidity + humUnit;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getCloudsName() {
        return cloudsName;
    }

    public void setCloudsName(String cloudsName) {
        this.cloudsName = cloudsName;
    }
}

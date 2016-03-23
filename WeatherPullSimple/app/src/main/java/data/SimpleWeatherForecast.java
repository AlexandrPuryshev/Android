package data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "weatherdata", strict = false)
public class SimpleWeatherForecast {

    @Element(name = "forecast", required = false)
    private Forecast forecast;

    public Forecast getForecast() {
        return forecast;
    }

    @Root(name = "forecast", strict = false)

    public static class Forecast{

        @ElementList(name = "time", required = false, inline = true)
        private ArrayList<WeatherForecast> forecasts;

        public ArrayList<WeatherForecast> getForecasts() {
            return forecasts;
        }

        @Root(name = "time", strict = false)
        public static class WeatherForecast{
            @Attribute(name = "from", required = false)
            private String timeFrom;

            @Attribute(name = "to", required = false)
            private String timeTo;

            @Element(name = "temperature", required = false)
            private Temperature temperature;

            @Element(name = "humidity", required = false)
            private Humidity humidity;

            public String getTimeFrom() {
                return timeFrom;
            }

            public String getTimeTo() {
                return timeTo;
            }

            public Temperature getTemperature() {
                return temperature;
            }

            public Humidity getHumidity() {
                return humidity;
            }

            @Root(name = "temperature", strict = false)
            public static class Temperature{
                @Attribute
                private String unit;

                @Attribute
                private String value;

                public String getUnit() {
                    return unit;
                }

                public String getValue() {
                    return value;
                }
            }

            @Root(name = "humidity", strict = false)
            public static class Humidity{
                @Attribute
                private String value;

                @Attribute
                private String unit;

                public String getUnit() {
                    return unit;
                }

                public String getValue() {
                    return value;
                }
            }


            static class Clouds {
                @Attribute
                private String value;
                @Attribute
                private String name;

                public String getValue() {
                    return value;
                }

                public String getName() {
                    return name;
                }
            }

            @Override
            public String toString() {
                String out = "";
                out += "Weather forecast: \n";
                out += "Country: " + city.getCountry() + "\n";
                out += "City: " + city.getName() + "\n";
                out += "Sunrise: " + city.getSun().getRise() + "\n";
                out += "Temperature: " + temperature.getValue() + temperature.getUnit() + "\n";
                out += "Humidity: " + humidity.getValue() + humidity.getUnit() + "\n";
                out += "Pressure: " + pressure.getValue() + pressure.getUnit() + "\n";
                out += "Wind Speed: " + wind.getSpeed().getValue() + " " + wind.getDirection().getName() + "\n";
                out += "Clouds: " + clouds.getName() + "\n";
                out += "LastUpdate: " + lastupdate.getValue();
                out += "Temperature: " + temperature.getValue() + " " + temperature.getUnit();

                return  out;
            }
        }
    }
}

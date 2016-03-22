package Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="current", strict = false)
public class SimpleWeather {

//    @Element(name = "city", required = false)
//    private SimpleCity city;

    @Element(name = "temperature", required = false)
    private Temperature temperature;

//    @Element(name = "humidity", required = false)
//    private Humidity humidity;
//
//    @Element(name = "pressure", required = false)
//    private Pressure pressure;
//
//    @Element(name = "wind", required = false)
//    private SimpleWind wind;
//
//    @Element(name = "clouds", required = false)
//    private Clouds clouds;
//
//    @Element(name = "visibility", required = false)
//    private Visibility visibility;
//
//    @Element(name = "precipitation", required = false)
//    private Precipitation precipitation;
//
//    @Element(name = "weather", required = false)
//    private Weather weather;
//
//    @Element(name = "lastupdate", required = false)
//    private Lastupdate lastupdate;

//    public SimpleCity getCity() {
//        return city;
//    }

    public Temperature getTemperature() {
        return temperature;
    }

//    public Humidity getHumidity() {
//        return humidity;
//    }
//
//    public Pressure getPressure() {
//        return pressure;
//    }
//
//    public SimpleWind getWind() {
//        return wind;
//    }
//
//    public Clouds getClouds() {
//        return clouds;
//    }
//
//    public Visibility getVisibility() {
//        return visibility;
//    }
//
//    public Precipitation getPrecipitation() {
//        return precipitation;
//    }
//
//    public Weather getWeather() {
//        return weather;
//    }
//
//    public Lastupdate getLastupdate() {
//        return lastupdate;
//    }

//    @Override
//    public String toString() {
//        String out = "";
//        out += "Weather forecast: \n";
//        out += "Country: " + city.getCountry() + "\n";
//        out += "City: " + city.getName() + "\n";
//        out += "Sunrise: " + city.getSun().getRise() + "\n";
//        out += "Temperature: " + temperature.getValue() + temperature.getUnit() + "\n";
//        out += "Humidity: " + humidity.getValue() + humidity.getUnit() + "\n";
//        out += "Pressure: " + pressure.getValue() + pressure.getUnit() + "\n";
//        out += "Wind Speed: " + wind.getSpeed().getValue() + " " + wind.getDirection().getName() + "\n";
//        out += "Clouds: " + clouds.getName() + "\n";
//        out += "LastUpdate: " + lastupdate.getValue();
//
//        return  out;
//    }


    @Override
    public String toString() {
        return "Temperature: " + temperature.getValue() + " " + temperature.getUnit();
    }

    ////////////////////////
    @Root(name = "temperature", strict = false)
    static class Temperature {
        @Attribute
        private String value;

//        @Attribute
//        private String min;
//
//        @Attribute
//        private String max;

        @Attribute
        private String unit;

        public String getValue() {
            return value;
        }

//        public String getMin() {
//            return min;
//        }
//
//        public String getMax() {
//            return max;
//        }

        public String getUnit() {
            return unit;
        }
    }

    static class Humidity {
        @Attribute
        private String value;

        @Attribute
        private String unit;

        public String getValue() {
            return value;
        }

        public String getUnit() {
            return unit;
        }
    }

    static class Pressure {
        @Attribute
        private String value;

        @Attribute
        private String unit;

        public String getValue() {
            return value;
        }

        public String getUnit() {
            return unit;
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

    static class Visibility {
        @Attribute (required = false)
        private String value;

        public String getValue() {
            return value;
        }
    }

    static class Precipitation {
        @Attribute
        private String mode;

        public String getMode() {
            return mode;
        }
    }

    static class Weather {
        @Attribute
        private int number;
        @Attribute
        private String value;
        @Attribute
        private String icon;

        public int getNumber() {
            return number;
        }

        public String getValue() {
            return value;
        }

        public String getIcon() {
            return icon;
        }
    }

    static class Lastupdate {
        @Attribute
        private String value;

        public String getValue() {
            return value;
        }
    }
 }
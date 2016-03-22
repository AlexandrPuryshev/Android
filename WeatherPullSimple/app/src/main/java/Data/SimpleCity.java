package Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="city", strict = false)
public class SimpleCity {
    @Attribute(name = "id", required = false)
    private int id;

    @Attribute(name = "name", required = false)
    private  String name;

    @Element(name="coord", required = false)
    private Coord coord;

    @Element(name="country", required = false)
    private String country;

    @Element(name="sun", required = false)
    private Sun sun;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sun getSun() {
        return sun;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //static class
    public static class Coord {
        @Attribute(name="lon", required = false)
        private String longitude;

        @Attribute(name = "lat", required = false)
        private String latitude;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }

    public static class Sun {
        @Attribute(name="rise", required = false)
        private String rise;

        @Attribute(name = "set", required = false)
        private String set;

        public String getRise() {
            return rise;
        }

        public void setRise(String rise) {
            this.rise = rise;
        }

        public String getSet() {
            return set;
        }

        public void setSet(String set) {
            this.set = set;
        }
    }

}

package Data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "wind", strict = false)
public class SimpleWind {

    @Element(name = "speed", required = false)
    private Speed speed;

    @Element(name = "gusts", required = false)
    private Qusts qusts;

    @Element(name = "direction", required = false)
    private Direction direction;

    public Speed getSpeed() {
        return speed;
    }

    public Qusts getQusts() {
        return qusts;
    }

    public Direction getDirection() {
        return direction;
    }

    static class Speed {
        @Attribute(name = "value", required = false)
        private String value;

        @Attribute(name = "name", required = false)
        private String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    static class Qusts {

    }

    static class Direction {
        @Attribute(name = "value")
        private String value;

        @Attribute(name = "code")
        private String code;

        @Attribute(name = "name")
        private String name;

        public String getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
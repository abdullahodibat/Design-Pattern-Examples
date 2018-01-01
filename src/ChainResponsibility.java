/**
 * Created by abdullahodibat.
 */
public class ChainResponsibility {

    public static void main(String[] args) {
        City berlin = new Berlin();
        City hamburg = new Hamburg();
        City munich = new Munich();
        berlin.setNextCity(hamburg);
        hamburg.setNextCity(munich);

        berlin.tagCity("munich");
        System.out.println(munich);

    }

    abstract static class City {
        String name;
        boolean isTagged;

        City nextCity;

        public void setNextCity(City nextCity) {
            this.nextCity = nextCity;
        }

        void tagCity(String cityName) {
            if (cityName.equals(this.name))
                isTagged = true;
            else {
                if (nextCity != null) {
                    nextCity.tagCity(cityName);
                }
            }
        }

        @Override
        public String toString() {
            return "name: " + name + ", isTagged: " + isTagged;
        }
    }

    static class Berlin extends City {
        public Berlin() {
            name = "berlin";
            isTagged = false;
        }
    }

    static class Hamburg extends City {
        public Hamburg() {
            name = "hamburg";
            isTagged = false;
        }
    }

    static class Munich extends City {
        public Munich() {
            name = "munich";
            isTagged = false;
        }
    }
}

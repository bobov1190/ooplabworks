import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Championship {

    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, GP> gps = new HashMap<>();

    public Driver createDriver(String name) {
        Driver d = new Driver(name);
        drivers.put(name, d);
        return d;
    }


    public Collection<Driver> getDrivers() {
        return drivers.values();
    }

    public Driver getDriver(String name) {
        return drivers.get(name);
    }

    /**
     * @param GP name (Es. "Monza")
     * @return the corresponding GP object
     */

    public GP defineGrandPrix(String name) {
        GP gp = new GP(name);
        gps.put(name, gp);
        return gp;
    }

    /**
     * @param GP name
     * @return the corresponding GP object
     */

    public GP getGrandPrix(String name) {
        return gps.get(name);
    }

    /**
     * @param gp
     * @param r
     * @param hours
     * @param min
     * @param sec
     * @param cent
     * @return Time object
     */

    public Time setTime(GP gp, Driver r, int hours, int min, int sec, int cent) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return drivers ranking sorted according to their points
     */

    public List<Driver> getChampionshipRanking() {
        // TODO Auto-generated method stub
        return null;
    }

}

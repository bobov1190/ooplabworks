import java.util.Collection;

public class Driver {

    private final String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * @return List of raced GPs
     */

    public Collection<GP> getRaced() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * The ranking is computed according to this rule:
     * <pre>
     * Ranking  Points
     * 	1			25
     * 	2			18
     * 	3			15
     * 	4			12
     * 	5			10
     * 	6			 8
     * 	7			 6
     * 	8			 4
     *  9			 2
     *  10			 1
     * @return the total points earned by the driver during the championship
     */

    public int getPoints() {
        // TODO Auto-generated method stub
        return 0;
    }

}
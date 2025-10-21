import junit.framework.TestCase;

import java.util.Collection;

public class TestR1_Drivers extends TestCase {

    public void testCreateDriver(){

        Championship c = new Championship();
        Driver d = c.createDriver("Sebastian Vettel");

        assertTrue("createDriver() returned null",d!=null);
        assertEquals("Driver Name is wrong","Sebastian Vettel",d.getName());

    }

    public void testDriversList(){

        Championship c = new Championship();

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");

        Collection<Driver> p = c.getDrivers();

        assertTrue("There is no drivers collection (==null)",p!=null);

        assertTrue("Vettel unavailable",p.contains(r));
        assertTrue("Hamilton unavailable",p.contains(d));

    }

    public void testGetDriver(){

        Championship c = new Championship();

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");

        Collection<Driver> p = c.getDrivers();

        Driver rr = c.getDriver("Vettel");
        Driver dd = c.getDriver("Hamilton");

        assertTrue("getDriver() did not find the driver",rr!=null);

        assertTrue("getDriver() did not find the driver",dd!=null);

        assertSame("method getDriver DID NOT returned the right object",r,rr);

        assertSame("method getDriver DID NOT returned the right object",d,dd);

    }

}

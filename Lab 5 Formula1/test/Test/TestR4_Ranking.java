import junit.framework.TestCase;

import java.util.Collection;
import java.util.List;

public class TestR4_Ranking extends TestCase {

    public void testPosition() throws Exception {

        Championship c = new Championship();

        String nome = "Monza";

        GP gp = c.defineGrandPrix(nome);

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");

        int hours = 0;
        int min = 50;
        int sec = 10;
        int cent = 33;

        c.setTime(gp,r,hours,min,sec,cent);
        sec+=15;
        c.setTime(gp,d,hours,min,sec,cent);

        int pr = gp.getPosition(r);
        int pd = gp.getPosition(d);

        assertEquals("The driver should be in the first position",1,pr);
        assertEquals("The driver should be in the second position",2,pd);

    }

    public void testGPRaced() throws Exception {

        Championship c = new Championship();

        GP monza = c.defineGrandPrix("Monza");
        GP monaco = c.defineGrandPrix("Monaco");

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");
        Driver s = c.createDriver("Massa");

        int hours = 0;
        int min = 50;
        int sec = 10;
        int cent = 33;

        c.setTime(monza,r,hours,min,sec,cent);
        sec+=15;
        c.setTime(monza,d,hours,min,sec+15,cent);
        c.setTime(monza,s,hours,min,sec-5,cent);

        c.setTime(monaco,r,hours+1,min,sec,cent);
        sec+=15;
        c.setTime(monaco,d,hours+1,min,sec+5,cent);

        Collection<GP> disp = r.getRaced();

        assertTrue("List of GP is incomplete",disp.contains(monza));
        assertTrue("List of GP is incomplete",disp.contains(monaco));

        Collection<GP> ds = s.getRaced();

        assertTrue("List of GP is incomplete",ds.contains(monza));
        assertFalse("There are too many GPs",ds.contains(monaco));

    }

    public void testPoints() throws Exception {

        Championship c = new Championship();

        GP monza = c.defineGrandPrix("Monza");
        GP monaco = c.defineGrandPrix("Monaco");

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");
        Driver s = c.createDriver("Massa");

        int hours = 0;
        int min = 50;
        int sec = 10;
        int cent = 33;

        c.setTime(monza,r,hours,min,sec,cent);
        c.setTime(monza,d,hours,min,sec+15,cent);
        c.setTime(monza,s,hours,min,sec-5,cent);

        c.setTime(monaco,r,hours+1,min,sec,cent);
        c.setTime(monaco,d,hours+1,min,sec+5,cent);
        c.setTime(monaco,s,hours+1,min,sec+15,cent);

        assertEquals("Wrong points",18+25,r.getPoints());
        assertEquals("Wrong points",15+18,d.getPoints());
        assertEquals("Wrong points",25+15,s.getPoints());

    }

    public void testRanking() throws Exception {

        Championship c = new Championship();

        GP monza = c.defineGrandPrix("Monza");
        GP monaco = c.defineGrandPrix("Monaco");

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");
        Driver s = c.createDriver("Massa");

        int hours = 0;
        int min = 50;
        int sec = 10;
        int cent = 33;

        c.setTime(monza,r,hours,min,sec,cent);
        c.setTime(monza,d,hours,min,sec+15,cent);
        c.setTime(monza,s,hours,min,sec-5,cent);

        c.setTime(monaco,r,hours+1,min,sec,cent);
        c.setTime(monaco,d,hours+1,min,sec+5,cent);
        c.setTime(monaco,s,hours+1,min,sec+15,cent);

        List<Driver> championshipRanking = c.getChampionshipRanking();

        assertSame("First position is wrong",r,championshipRanking.get(0));
        assertSame("Second position is wrong",s,championshipRanking.get(1));
        assertSame("Third position is wrong",d,championshipRanking.get(2));

    }

}

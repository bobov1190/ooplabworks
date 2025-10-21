import junit.framework.TestCase;

import java.util.List;

public class TestR3_Time extends TestCase {

    private static String t2s(int hours, int min, int sec, int cent){
        return hours+":"+min+":"+sec+"."+cent;
    }

    public void testSetRaceTime() throws Exception {

        Championship c = new Championship();

        String nome = "Monza";

        GP gp = c.defineGrandPrix(nome);

        Driver r = c.createDriver("Vettel");
        Driver d = c.createDriver("Hamilton");

        int hours = 0;
        int min = 50;
        int sec = 10;
        int cent = 33;

        Time t = c.setTime(gp,r,hours,min,sec,cent);

        assertTrue("setTime() returned null",t!=null);

        String result = t.toString();
        String expected = t2s(hours,min,sec,cent);

        assertEquals(expected,result);

    }

    public void testGPRanking() throws Exception {

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

        List<Driver> ranking = gp.getGPRanking();

        assertSame("First position is wrong",r,ranking.get(0));
        assertSame("Second position is wrong",d,ranking.get(1));

    }

}

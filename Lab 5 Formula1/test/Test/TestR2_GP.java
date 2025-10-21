import junit.framework.TestCase;

import java.lang.reflect.Method;

public class TestR2_GP extends TestCase {


    String callGetName(GP gp) throws Exception {

        Method mtd = gp.getClass().getMethod("getName",new Class[0]);
        Object result = mtd.invoke(gp,new Object[0]);
        return (String)result;

    }

    public void testCreateGP() throws Exception{

        Championship c= new Championship();

        String name = "Monza";
        GP gp = c.defineGrandPrix(name);

        assertTrue("defineGrandPrix() returned null",gp!=null);
        assertEquals("GP name is wrong",name,callGetName(gp));

    }

    public void testGetGP() throws Exception{

        Championship c= new Championship();

        String name = "Monza";
        c.defineGrandPrix(name);

        GP gp = c.getGrandPrix(name);

        assertTrue("GP not found (==null)",gp!=null);
        assertEquals("Wrong GP name",name,callGetName(gp));

    }

}

    import junit.framework.Test;
    import junit.framework.TestSuite;

    public class AllTests {
        public static Test suite() {
            TestSuite suite = new TestSuite("Test for formula1 package");
            //$JUnit-BEGIN$
            suite.addTestSuite(TestR1_Drivers.class);
            suite.addTestSuite(TestR2_GP.class);
            suite.addTestSuite(TestR3_Time.class);
            suite.addTestSuite(TestR4_Ranking.class);
            //$JUnit-END$
            return suite;
        }
    }

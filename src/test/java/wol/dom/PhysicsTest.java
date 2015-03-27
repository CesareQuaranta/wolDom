package wol.dom;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;

import wol.dom.phisycs.Acceleration;
import wol.dom.phisycs.Force;
import wol.dom.space.Position;
import wol.dom.space.Vector;

/**
 * Unit test for simple App.
 */
public class PhysicsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PhysicsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PhysicsTest.class );
    }

    @org.junit.Test
	public void testSumForces() {
		Force f1=new Force(1D,new Acceleration(new Vector(1,0,0)));
		Force f2=new Force(1D,new Acceleration(new Vector(-1,0,0)));
		f1.sum(f2);
		Assert.assertTrue("Errore somma forze contrapposte",f1.isEmpty());
	}
}

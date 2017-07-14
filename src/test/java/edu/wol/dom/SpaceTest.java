package edu.wol.dom;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;

import edu.wol.dom.space.Position;
import edu.wol.dom.space.Vector3f;

/**
 * Unit test for simple App.
 */
public class SpaceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SpaceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SpaceTest.class );
    }

    @org.junit.Test
	public void testSumVector() {
		float px = 2139095f;
		Position p1 = new Position(px,0,0);
		p1.add(new Vector3f(-1.5f,-0.9f,1.001f));
		Assert.assertTrue("Subtractive test x axis failed",p1.getX()<px);
		Assert.assertTrue("Subtractive test y axis failed",p1.getY()==-0.9f);
		Assert.assertTrue("Additive test z axis failed",p1.getZ()==1.001f);
	}
}

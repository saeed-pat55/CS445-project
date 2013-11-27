import static org.junit.Assert.*;

import org.junit.Test;


public class TestResult {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test_set_getId()
		{
		System.out.println("Testing setter/getter for Id...");
		Result r = new Result();
		r.setId("111");
		assertEquals("111", r.getId());
		}
	
	@Test
	public void test_set_getPosition()
		{
		System.out.println("Testing setter/getter for position...");
		Result r = new Result();
		r.setPosition("1,3,5");
		assertEquals("1,3,5", r.getPosition());
		}
	
	@Test
	public void test_set_getTotal()
		{
		System.out.println("Testing setter/getter for total...");
		Result r = new Result();
		r.setTotal(24.50);
		assertEquals(24.50, r.getTotal(), DELTA);
		}
	
	@Test
	public void test_set_getDateRange()
		{
		System.out.println("Testing setter/getter for dateRange...");
		Result r = new Result();
		r.setDateRange("20130203-20121010");
		assertEquals("20130203-20121010", r.getDateRange());
		}
	
	@Test
	public void test_set_getNumOfBeds()
		{
		System.out.println("Testing setter/getter for numOfBeds...");
		Result r = new Result();
		r.setNumOfBeds(5);
		assertEquals(5, r.getNumOfBeds());
		}

}

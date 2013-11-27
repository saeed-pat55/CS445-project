import static org.junit.Assert.*;

import org.junit.Test;


public class TestBed {
	
	private static final double DELTA = 1e-2;
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Asserting that all default values are as defined in the class
	 */
	@Test
	public void test_defaultConstructor() 
		{
		System.out.println("Testing default contructor...");
		Bed bed = new Bed();
		assertEquals("x", bed.getId());
		assertEquals("1", bed.getRoom());
		assertEquals("99999999", bed.getDate());
		assertEquals(0, bed.getPrice(), DELTA);
		assertEquals("USD", bed.getCurrency());
		assertEquals(false, bed.getBooked());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using non-default constructor
	 * Asserting that all default values are same as the arguments 
	 * given to the non-default constructor
	 */
	@Test
	public void test_non_defaultCustructor() 
		{
		System.out.println("Testing non-default contructor...");
		Bed bed = new Bed("1", "5", "2013/xx/xx","EU",49.99, true);
		assertEquals("1", bed.getId());
		assertEquals("5", bed.getRoom());
		assertEquals("2013/xx/xx", bed.getDate());
		assertEquals(49.99, bed.getPrice(), DELTA);
		assertEquals("EU", bed.getCurrency());
		assertEquals(true, bed.getBooked());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the id using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getId()
		{
		System.out.println("Testing getter/setter for 'id'...");
		Bed bed = new Bed();
		bed.setId("1A");
		assertEquals("1A", bed.getId());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the room using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getRoom()
		{
		System.out.println("Testing getter/setter for 'room'...");
		Bed bed = new Bed();
		bed.setRoom("55");
		assertEquals("55", bed.getRoom());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the date using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getDate()
		{
		System.out.println("Testing getter/setter for 'date'...");
		Bed bed = new Bed();
		bed.setDate("2013/10/24");
		assertEquals("2013/10/24", bed.getDate());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the currency using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getCurrency()
		{
		System.out.println("Testing getter/setter for 'currency'...");
		Bed bed = new Bed();
		bed.setCurrency("AUS");
		assertEquals("AUS", bed.getCurrency());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the price using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getPrice()
		{
		System.out.println("Testing getter/setter for 'price'...");
		Bed bed = new Bed();
		bed.setPrice(99.99);
		assertEquals(99.99, bed.getPrice(), DELTA);
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the booked using the setter
	 * Asserting that the getter returns the new value
	 */
	@Test
	public void test_set_getBooked()
		{
		System.out.println("Testing getter/setter for 'booked'...");
		Bed bed = new Bed();
		bed.setBooked(true);
		assertEquals(true, bed.getBooked());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the booked = true using the setter 
	 * Asserting that the ifAvailable() method returns false
	 */
	@Test
	public void test_ifAvailable0()
		{
		System.out.println("Testing ifAvailable method when" +
						   "'booked = true'...");
		Bed bed = new Bed();
		bed.setBooked(true);
		assertEquals(false, bed.ifAvailable());
		}
	
	/**
	 * Instantiating a Bed 'bed' object using default constructor
	 * Setting the booked = false using the setter 
	 * Asserting that the ifAvailable() method returns true
	 */
	@Test
	public void test_ifAvailable1()
		{
		System.out.println("Testing ifAvailable method when" +
						   "'booked = false'...");
		Bed bed = new Bed();
		assertEquals(true, bed.ifAvailable());
		}
}

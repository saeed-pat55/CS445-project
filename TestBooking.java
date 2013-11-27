import static org.junit.Assert.*;

import org.junit.Test;


public class TestBooking {

	private static final double DELTA = 1e-2;
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Asserting all the attribute values
	 */
	@Test
	public void test_defaultConstructor()
		{
		System.out.println("Testing default constructor...");
		Booking booking = new Booking();
		assertEquals("", booking.getId());
		assertEquals("", booking.getBedId());
		assertEquals("", booking.getCustomerEmail());
		assertEquals(0, booking.getTotal(), DELTA);
		assertEquals("", booking.getDateRange());
		assertEquals("", booking.getLocation());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * non-default constructor
	 * Asserting all the attribute values
	 */
	@Test
	public void test_non_DefaultConstructor()
		{
		System.out.println("Testing non-default constructor...");
		Booking booking = new Booking("1", "abc@xyz.com","1-1",10,
									"20140701-20140702", "Chicago");
		assertEquals("1", booking.getId());
		assertEquals("1-1", booking.getBedId());
		assertEquals("abc@xyz.com", booking.getCustomerEmail());
		assertEquals(10, booking.getTotal(), DELTA);
		assertEquals("20140701-20140702", booking.getDateRange());
		assertEquals("Chicago", booking.getLocation());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting id value using setId()
	 * Asserting the value using getId()
	 */
	@Test
	public void test_set_getId()
		{
		System.out.println("Testing setter/getter for id...");
		Booking booking = new Booking();
		booking.setId("25");
		assertEquals("25", booking.getId());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting email value using setCustomerEmail()
	 * Asserting the value using getCustomerEmail()
	 */
	@Test
	public void test_set_getCustomerEmail()
		{
		System.out.println("Testing setter/getter for email...");
		Booking booking = new Booking();
		booking.setCustomerEmail("a@b.com");
		assertEquals("a@b.com", booking.getCustomerEmail());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting bedId value using setBedId()
	 * Asserting the value using getBedId()
	 */
	@Test
	public void test_set_getBedId()
		{
		System.out.println("Testing setter/getter for bedId...");
		Booking booking = new Booking();
		booking.setBedId("25-5");
		assertEquals("25-5", booking.getBedId());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting total value using setTotal()
	 * Asserting the value using getTotal()
	 */
	@Test
	public void test_set_getTotal()
		{
		System.out.println("Testing setter/getter for total...");
		Booking booking = new Booking();
		booking.setTotal(49.99);
		assertEquals(49.99, booking.getTotal(), DELTA);
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting dateRange value using setDateRange()
	 * Asserting the value using getDateRange()
	 */
	@Test
	public void test_set_getDateRange()
		{
		System.out.println("Testing setter/getter for dateRange...");
		Booking booking = new Booking();
		booking.setDateRange("20131225-20131231");
		assertEquals("20131225-20131231", booking.getDateRange());
		}
	
	/**
	 * Instantiating Booking booking object using
	 * default constructor
	 * Setting location value using setLOcation()
	 * Asserting the value using getLocation()
	 */
	@Test
	public void test_set_getLocation()
		{
		System.out.println("Testing setter/getter for location...");
		Booking booking = new Booking();
		booking.setLocation("San Francisco");
		assertEquals("San Francisco", booking.getLocation());
		}

}

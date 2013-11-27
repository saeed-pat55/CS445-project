import static org.junit.Assert.*;

import org.junit.Test;


public class TestCustomer {

	@Test
	public void test_set_get_id()
		{
		System.out.println("Testing setter/getter for id...");
		Customer customer = new Customer();
		customer.setId("12345");
		assertEquals("12345", customer.getId());
		}
	
	@Test
	public void test_set_getName()
		{
		System.out.println("Testing setter/getter for name...");
		Customer customer = new Customer();
		customer.setFirstName("John");
		customer.setLastName("Chaser");
		assertEquals("John", customer.getFirstName());
		assertEquals("Chaser", customer.getLastName());
		}
	
	@Test
	public void test_set_getEmail()
		{
		System.out.println("Testing setter/getter for email...");
		Customer customer = new Customer();
		customer.setEmail("abc@xyz.com");
		assertEquals("abc@xyz.com", customer.getEmail());
		}
	
	@Test
	public void test_set_getCC()
		{
		System.out.println("Testing setter/getter for CC...");
		Customer customer = new Customer();
		customer.setCC("12345678910");
		customer.setCCExpiration("201607");
		customer.setCCCode("125");
		assertEquals("12345678910", customer.getCC());
		assertEquals("201607", customer.getCCExpiration());
		assertEquals("125", customer.getCCcode());
		}
	
	@Test
	public void test_set_getPhone()
		{
		System.out.println("Testing setter/getter for phone...");
		Customer customer = new Customer();
		customer.setPhone("7731234567");
		assertEquals("7731234567", customer.getPhone());
		}
	
	@Test
	public void test_set_getFbTwitIds()
		{
		System.out.println("Testing setter/getter for fb/twit id...");
		Customer customer = new Customer();
		customer.setTwitId("jchaser");
		customer.setFbId("johnc");
		assertEquals("jchaser", customer.getTwitId());
		assertEquals("johnc", customer.getFbId());
		}
	
	
}

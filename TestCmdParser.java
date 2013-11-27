import static org.junit.Assert.*;

import org.junit.Test;


public class TestCmdParser {

	@Test
	public void test_parseXMLName()
		{
		System.out.println("Testing parseXMLName() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseXMLName("'hostel.xml'");
		assertEquals("hostel.xml", result);
		}
	
	@Test
	public void test_parseCity()
		{
		System.out.println("Testing parseCity() method...");
		CmdParser cmd = new CmdParser();
		String str = "--city \"San Francisco\" -";
		String result = cmd.parseCity(str);
		assertEquals("san francisco", result);
		}
	
	@Test
	public void test_parseSearchId()
		{
		System.out.println("Testing parseSearchId() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseSearchId("--search_id 1214 ");
		assertEquals("1214", result);
		}
	
	@Test
	public void test_parseUserId()
		{
		System.out.println("Testing parseUserId() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseUserId("--user_id 200580");
		assertEquals("200580", result);
		}
	
	@Test
	public void test_parseBeds()
		{
		System.out.println("Testing parseCCNumber() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseBeds("--beds 5 ");
		assertEquals("5", result);
		}
	
	@Test
	public void test_parseId()
		{
		System.out.println("Testing parseId() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseId("--user_id 12345 ");
		assertEquals("12345", result);
		}
	
	@Test
	public void test_parseBookingId()
		{
		System.out.println("Testing parseBookingId() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseBookingId("--booking_id 112");
		assertEquals("112", result);
		}
	
	@Test
	public void test_parseStartDate()
		{
		System.out.println("Testing parseStartDate() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseStartDate("--start_date 20111111 ");
		assertEquals("20111111", result);
		}
	
	@Test
	public void test_parseEndDate()
		{
		System.out.println("Testing parseEndDate() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseEndDate("--end_date 20121212 ");
		assertEquals("20121212", result);
		}

	@Test
	public void test_parseEndDate1()
		{
		System.out.println("Testing parseEndDate() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseEndDate1("--end_date 20121212 ");
		assertEquals("20121212", result);
		}
	
	@Test
	public void test_parseFirstName()
		{
		System.out.println("Testing parseFirstName() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseFirstName("--first_name John -");
		assertEquals("John", result);
		}
	
	@Test
	public void test_parseLastName()
		{
		System.out.println("Testing parseLastName() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseLastName("--last_name Chaser -");
		assertEquals("Chaser", result);
		}
	
	@Test
	public void test_parseEmail()
		{
		System.out.println("Testing parseEmail() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseEmail("--email abc@xyz.com ");
		assertEquals("abc@xyz.com", result);
		}
	
	@Test
	public void test_parseEmailForView()
		{
		System.out.println("Testing parseEmailForView() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseEmailForView("--email abc@xyz.com ");
		assertEquals("abc@xyz.com", result);
		}
	
	@Test
	public void test_parseCCNumber()
		{
		System.out.println("Testing parseCCNumber() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseCCNumber("--cc_number 123456789 ");
		assertEquals("123456789", result);
		}
	@Test
	public void test_parseCCExpiration()
		{
		System.out.println("Testing parseCCExpiration() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseCCExpiration("--expiration_date 201607 ");
		assertEquals("201607", result);
		}
	
	@Test
	public void test_parseCCCode()
		{
		System.out.println("Testing parseCCCode() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parseCCCode("--security_code 123 ");
		assertEquals("123", result);
		}
	
	@Test
	public void test_parsePhone()
		{
		System.out.println("Testing parsePhone() method...");
		CmdParser cmd = new CmdParser();
		String result = cmd.parsePhone("--phone 7731234567 ");
		assertEquals("7731234567", result);
		}
	
}

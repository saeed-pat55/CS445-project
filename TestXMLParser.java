import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestXMLParser {
	
	/**
	 * Instantiating a XMLParser 'xml' object
	 * Calling the getAvailability() method with argument 
	 * "hostel.xml"(the sample file)
	 * Saving the String[] returned from the method in String[] arr
	 * Asserting 'arr' != null and length == 5,
	 * Asserting that the contents of 'arr' are the expected strings
	 */
/*	@Test
	public void test_getAvailability()
		{	
		XMLParser xml = new XMLParser();
		String[] arr = xml.getAvailability("hostel.xml");
		assertTrue(arr != null && arr.length == 4);
		assertEquals("2, 1, 20131003, 25", arr[0]);
		assertEquals("7, 2, 20131004, 31", arr[1]);
		}
	*/
	/**
	 * Instantiating a XMLParser 'xml' and ArrayList<Bed> bedList objects
	 * Creating a string filename = "hostel.xml"
	 * Calling the loadAvailability(filename, bedLIst)
	 * Asserting bedList.size() == 5,
	 * Asserting that the contents of 'bedList' are the expected strings
	 */
/*	@Test
	public void test_loadAvailability()
		{
		XMLParser xml = new XMLParser();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList<Bed> bedList = new ArrayList();
		String filename = "hostel.xml";
		xml.loadAvailability(filename, bedList);
		assertEquals(4, bedList.size());
		assertTrue("2, 1, 20131003, 25.0, USD, false".equals
								((bedList.get(0).toString())));
		assertTrue("7, 2, 20131004, 31.0, USD, false".equals
								((bedList.get(1).toString())));
		}
	*/
	
	/**
	 * Parsing hostel.xml file and getting the full address
	 * street + city + state + zip + country and saving it
	 * in String 'addressStr'
	 * Asserting addressStr != null
	 * Asserting addressStr doesn't contain "Error"
	 */
/*	@Test
	public void test_getFullAddress()
		{
		XMLParser xml = new XMLParser();
		String addressStr = xml.getFullAddress("hostel.xml");
		assertNotNull(addressStr);
		assertFalse(addressStr.contains("Error"));
		}
		*/
	
	/**
	 * Parsing city from hostel.xml and saving it in 
	 * String cityStr.
	 * Asserting cityStr equals "anytown" 
	 * 
	 */
/*	@Test
	public void test_getCity()
		{
		XMLParser xml = new XMLParser();
		String cityStr = xml.getCity("hostel.xml");
		assertEquals("anytown", cityStr);
		}
*/
	/**
	 * Parsing hostel.xml file and getting the full contact, ie,
	 * phone + email + website, etc
	 * Saving the result in String 'contactStr'
	 * Asserting contactStr != null
	 * Asserting contactStr doesn't contain "Error"
	 */
/*	@Test
	public void test_getContact()
		{
		XMLParser xml = new XMLParser();
		String contactStr = xml.getContact("hostel.xml");
		assertNotNull(contactStr);
		assertFalse(contactStr.contains("Error"));
		}
	*/
	/**
	 * Parsing name from hostel.xml and saving it in 
	 * String nameStr.
	 * Asserting cityStr equals "Hostel 21 - Romantic" 
	 * 
	 */
/*	@Test
	public void test_getName()
		{
		XMLParser xml = new XMLParser();
		String nameStr = xml.getName("hostel.xml");
		assertEquals("Hostel 21 - Romantic", nameStr);
		}
	*/
	/**
	 * Parsing hostel.xml file and getting all the data
	 * under <Restrictions> tag
	 * Saving the result in String 'restrStr'
	 * Asserting restrStr != null
	 * Asserting restrStr doesn't contain "Error"
	 */
/*	@Test
	public void test_getRestrictions()
		{
		XMLParser xml = new XMLParser();
		String restrStr = xml.getRestrictions("hostel.xml");
		assertNotNull(restrStr);
		assertFalse(restrStr.contains("Error"));
		} 
	*/
}

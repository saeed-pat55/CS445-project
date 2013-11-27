import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestTXTHandler {
	
	
	/**
	 * Instatiating Search 'search', XMLParser 'xml', 
	 * TXTHandler 'txt', ArrayList<Bed> 'bedList' objects
	 * Loading availability from hostel.xml to bedList
	 * Sorting bedList by date using search.sortListByDate()
	 * Parsing address from hostel.xml into STring 'address'
	 * Writing the address as the first line in a txt file, which
	 * also creates a txt file with name of city as the file name 
	 * if none exists.
	 * Writing the data from the bedList using toString method 
	 * of each Bed Object inside bedList. 
	 * Saving the return booleans for each write in 'result1' 
	 * and 'result2'
	 * Asserting that both are true
	 */
	/*@Test
	public void test_writeList()
		{
		System.out.println("Testing writeList() method...");
		Sort sort = new Sort();
		XMLParser xml = new XMLParser();
		TXTHandler txt = new TXTHandler();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		xml.loadAvailability("hostel.xml", bedList);
		bedList = sort.listByDate(bedList);
		String address = xml.getFullAddress("hostel.xml");
		String str = xml.getCity("hostel.xml").toLowerCase();
		boolean result1 = txt.write(str + ".txt", "# " + address);
		boolean result2 = txt.writeBedList(str + ".txt", bedList);
		assertEquals(true, result1);
		assertEquals(true, result2);
		}
	*/
	/**
	 * Instantiating a TXTHandler 'txt' and ArrayList<Bed> bedList objects
	 * Loading date from txt file to 
	 */
/*	@Test
	public void test_loadBedDate()
		{
		System.out.println("Testing loadBedData() method...");
		TXTHandler txt = new TXTHandler();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		txt.loadBedData("anytown.txt", bedList);
		assertEquals(4, bedList.size());
		}
*/
}

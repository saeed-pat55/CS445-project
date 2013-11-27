import static org.junit.Assert.*;

//import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.ArrayList;


public class TestSearch {
	
	/**
	 * Instantiating a Search 'search' object
	 * Searching for a customer using id in 'customer.txt' file and
	 * saving the return String in 'result'
	 * Searching for a customer using a id that doesn't exists and
	 * saving the return String in 'result1'
	 * Asserting that the result is != "0" => meaning a match found
	 * Asserting that result1 equals "0" => meaning no match found
	 */
/*	@Test
	public void test_searchCustomerById()
		{
		Search search = new Search();
		String result = search.customerById("37390", "customer.txt");
		String result1 = search.customerById("3730", "customer.txt");
		assertThat(result, not("0"));
		assertEquals("0", result1);
		}
	*/
	/**
	 * Instantiating a Search 'search' object
	 * Searching for a customer using email in 'customer.txt' file and
	 * saving the return String in 'result'
	 * Searching for a customer using email that doesn't exists and
	 * saving the return String in 'result1'
	 * Asserting that the result is != "0" => meaning a match was found
	 * Asserting that result1 equals "0" => meaning no match was found
	 */
/*	@Test
	public void test_searchCustomerByEmail()
		{
		Search search = new Search();
		String result = search.customerByEmail("luck@abc.com", "customer.txt");
		String result1 = search.customerByEmail("iit", "customer.txt");
		assertThat(result, not("0"));
		assertEquals("0", result1);
		}
	*/
	
	
	/**
	 * Test for getting all dates in a given range
	 * Actually, multiple methods are used/tested in this test:
	 * convertStringToDate(), getDatesInRange(), 
	 * convertDateListToString().
	 * The names of the above methods are self explanatory.
	 * 
	 */
	@Test
	public void test_parseDateRange()
		{
		System.out.println("Testing parseDateRange() method...");
		Search search = new Search();
		String start = "20131110";
		String end = "20131112";
		String[] dateArr = search.getDatesInRange(start, end);
		assertEquals(2, dateArr.length);
		assertEquals("20131110", dateArr[0]);
		assertEquals("20131111", dateArr[1]);
		}
	
	/**
	 * Instantiating Search search, ArrayList<Bed> bedList,
	 * and three Bed objects namely bed, bed1, bed2 using non-default
	 * constructor
	 * Adding the beds to the bedList 
	 * calling the search.bedForDate() method and saving the
	 * return int value in an int 'pos'
	 * Asserting that pos == 2
	 * 
	 */
	@Test
	public void test_bedForDate()
		{
		System.out.println("Testing bedForDate() method...");
		Search search = new Search();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed("1", "3", "20131110", "", 0, false);
		Bed bed1 = new Bed("1", "3", "20131111", "", 0, false);
		Bed bed2 = new Bed("1", "3", "20131112", "", 0, false);
		bedList.add(bed);
		bedList.add(bed1);
		bedList.add(bed2);
		int pos = search.bedForDate(0, "20131112", bedList);
		assertEquals(2, pos);
		}
	
	/**
	 * Instantiating Search search, ArrayList<Bed> bedList, and 
	 * six Bed objects using their non-default constructors
	 * Adding the beds to bedList
	 * Calling search.bedForDateRange() method starting at position 1
	 * in bedList and saving the return value into a String 'pos'
	 *  Calling search.bedForDateRange() method starting at position 2
	 * in bedList and saving the return value into a String 'pos1'
	 * Asserting that 'pos' is a concatenation of positions
	 * for the bed in that given date range
	 * Asserting that 'pos2' equals "null"
	 */
	@Test
	public void test_bedForDateRange()
		{
		System.out.println("Testing bedForDateRange() method...");
		Search search = new Search();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed("10", "5", "20131110", "", 0, false);
		Bed bed1 = new Bed("1", "3", "20131110", "", 0, false);
		Bed bed2 = new Bed("10", "5", "20131111", "", 0, false);
		Bed bed3 = new Bed("1", "3", "20131111", "", 0, false);
		Bed bed4 = new Bed("10", "5", "20131112", "", 0, false);
		Bed bed5 = new Bed("1", "3", "20131112", "", 0, false);
		bedList.add(bed);
		bedList.add(bed1);
		bedList.add(bed2);
		bedList.add(bed3);
		bedList.add(bed4);
		bedList.add(bed5);
		String pos = search.bedForRange("20131111", "20131113", 
											bedList, 0);
		String pos1 = search.bedForRange("20131110", "20131112", 
											bedList, 2);
		
		assertEquals("2,4", pos);
		assertEquals("null", pos1);
		}
	
	
	/**
	 * Instantiating the same objects as above
	 * Calling the multiBedsForRange method with various
	 * different arguments and saving the result in a String
	 * Asserting that the String returns the expected value
	 */
	@Test
	public void test_multiBedsForRange()
		{
		System.out.println("Testing multiBedsForRange() method...");
		Search search = new Search();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed("10", "5", "20131110", "", 0, true);
		Bed bed1 = new Bed("1", "3", "20131110", "", 0, false);
		Bed bed2 = new Bed("10", "5", "20131111", "", 0, false);
		Bed bed3 = new Bed("1", "3", "20131111", "", 0, false);
		Bed bed4 = new Bed("10", "5", "20131112", "", 0, false);
		Bed bed5 = new Bed("1", "3", "20131112", "", 0, false);
		bedList.add(bed);
		bedList.add(bed1);
		bedList.add(bed2);
		bedList.add(bed3);
		bedList.add(bed4);
		bedList.add(bed5);
		
		String pos = search.multiBedsForRange("20131110", "20131112",
											2, 0, bedList);
		String pos1 = search.multiBedsForRange("20131111", "20131113", 
												2, 0, bedList);
		String pos2 = search.multiBedsForRange("20131111", "20131112", 
												1, 3, bedList);
		assertEquals("null", pos);
		assertEquals("2,4-3,5", pos1);
		assertEquals("3", pos2);
		
		} 
	
	//Below test uses San Francisco date from 07/01/14-07/05/14(exclusive)
	//Needs a 'san francisco.txt' file with the above data to work
	/*
	@Test
	public void test_multi()
		{
		Search search = new Search();
		TXTHandler txt = new TXTHandler();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		txt.loadBedData("san francisco.txt", bedList);
		System.out.println(bedList.size());
		String result = search.multiBedsForRange("20140704", 
										"20140705", 3, 0, bedList);
		String result1 = search.multiBedsForRange("20140702", 
										"20140705", 2, 0, bedList);
		String result2 = search.multiBedsForRange("20140704", 
										"20140706", 2, 0, bedList);
		String result3 = search.multiBedsForRange("20140602", 
										"20140705", 2, 0, bedList);
		assertEquals("9-10-11", result);
		assertEquals("3,6,9-4,7,10-5,8,11", result1);
		assertEquals("null", result2);
		assertEquals("null", result3);
		}
	
	*/
	
	/**
	 * This small test check if a give txt file exists
	 * The method search.ifTxtFileExists() is called twice,
	 * once with a existing filename and once with filename that
	 * doesn't exists
	 */
	
/*	@Test
	public void test_txtFile()
		{
		Search search = new Search();
		assertFalse(search.ifTxtFileExists("a.txt"));
		assertTrue(search.ifTxtFileExists("customer.txt"));
		}
	
	@Test
	public void test_txtFilesWithKey()
		{
		Search search = new Search();
		String currDir = search.currentDir();
		String[] files = search.txtFilesWithKey("customer", currDir);
		assertEquals("customer.txt", files[0]);
		}
	*/
	
	@Test
	public void test_countDays()
		{
		System.out.println("Testing countDays() method...");
		Search s = new Search();
		int count = s.countDaysInRange("20120101", "20120105");
		assertEquals(4, count);
		}
	
	@Test
	public void test_getResultById()
		{
		System.out.println("Testing getResultById() method...");
		ArrayList<Result> rList = new ArrayList<Result>();
		Result result = new Result("121", "1", 25.99, "20121212", 2);
		rList.add(result);
		Search s = new Search();
		int pos = s.resultById("121", rList);
		assertEquals(0, pos);
		}
	
	@Test
	public void test_getCancelPolicy()
		{
		System.out.println("Testing getCancelPolicy() method...");
		Search s = new Search();
		String str = "32, af, 32, 234, 24, 234";
		String cPolicy = s.getCancelPolicy(str);
		assertEquals("24", cPolicy);
		}
	
	@Test
	public void test_getAllBeds()
		{
		System.out.println("Testing getAllBeds() method...");
		Search s = new Search();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed();
		bed.setDate("20121201");
		Bed bed1 = new Bed();
		bed1.setDate("20121202");
		bedList.add(bed);
		bedList.add(bed1);
		String result = s.allBeds("20121201", "20121203", bedList);
		assertEquals(",0,1", result);
		}
	
	
	
	
}

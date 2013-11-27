import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestHostel {

	@Test
	public void test_set_getName()
		{
		System.out.println("Testing setter/getter for name...");
		Hostel h = new Hostel();
		h.setName("Hostel 21");
		assertEquals("Hostel 21", h.getName());
		}

	@Test
	public void test_set_getAddress()
		{
		System.out.println("Testing setter/getter for address...");
		Hostel h = new Hostel();
		h.setAddress("123 Main St");
		assertEquals("123 Main St", h.getAddress());
		}
	
	@Test
	public void test_set_getContact()
		{
		System.out.println("Testing setter/getter for contact...");
		Hostel h = new Hostel();
		h.setContact("54564654 hostel21.com");
		assertEquals("54564654 hostel21.com", h.getContact());
		}
	
	@Test
	public void test_set_getRestrictions()
		{
		System.out.println("Testing setter/getter for restrictions...");
		Hostel h = new Hostel();
		h.setRestrictions("N N");
		assertEquals("N N", h.getRestrictions());
		}

	@Test 
	public void test_set_getBedArrList()
		{
		System.out.println("Testing setter/getter for ArrayList<Bed> bedArrList...");
		Hostel h = new Hostel();
		Bed bed = new Bed();
		Bed bed1 = new Bed();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		bedList.add(bed);
		bedList.add(bed1);
		h.setBedArrList(bedList);
		assertEquals(bedList, h.getBedArrList());
		assertEquals(bedList.size(), h.getBedArrList().size());
		}





}

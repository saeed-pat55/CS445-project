
import java.util.ArrayList;

public class Hostel {
	
	/**
	 */
	private String name;
	private String address;
	private String contact;
	private String restrictions;
	private ArrayList<Bed> bedArrList;
	
	public Hostel()
		{
		name = "";
		address = "n/a";
		contact = "n/a";
		restrictions = "n/a";
		bedArrList = new ArrayList<Bed>();
		}
	
	public Hostel(String aName, String anAddress, String aContact, 
				  String aRestriction, ArrayList<Bed> aBedArrList)
		{
		name = aName;
		address = anAddress;
		contact = aContact;
		restrictions = aRestriction;
		bedArrList = aBedArrList;
		}

	public void setName(String aName)
		{name = aName;}

	public void setAddress(String anAddress)
		{address = anAddress;}

	public void setContact(String aContact)
		{contact = aContact;}

	public void setRestrictions(String aRestriction)
		{restrictions = aRestriction;}
	
	public void setBedArrList(ArrayList<Bed> aBedArrList)
		{bedArrList = aBedArrList;}

	public String getName()
		{return this.name;}

	public String getAddress()
		{return this.address;}

	public String getContact()
		{return this.contact;}

	public String getRestrictions()
		{return this.restrictions;}
	
	public ArrayList<Bed> getBedArrList()
		{return this.bedArrList;}
	
	public int size()
		{return this.bedArrList.size();}
	
	public Bed getBedAtPos(int position)
		{return this.bedArrList.get(position);}
	
	
	public void addBed(Bed aBed)
		{this.bedArrList.add(aBed);}
}

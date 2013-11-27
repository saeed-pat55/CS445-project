
public class Booking {
	
	/**
	 */
	private String id;
	/**
	 */
	private String customerEmail;
	private String bedId;
	private double total;
	private String dateRange;
	private String location;
	
	
	public Booking()
		{
		id = "";
		customerEmail = "";
		bedId = "";
		total = 0;
		dateRange = "";
		location = "";
		}
	
	public Booking(String anId, String aCustomerEmail, String aBedId, 
					double aTotal, String aDateRange, String aLocation)
		{
		id = anId;
		customerEmail = aCustomerEmail;
		bedId = aBedId;
		total = aTotal;
		dateRange = aDateRange;
		location = aLocation;
		}

	public void setId(String anId)
		{id = anId;}

	public void setCustomerEmail(String aCustomerEmail)
		{customerEmail = aCustomerEmail;}

	public void setBedId(String aBedId)
		{bedId = aBedId;}

	public void setTotal(double aTotal)
		{total = aTotal;}

	public void setDateRange(String aDateRange)
		{dateRange = aDateRange;}

	public void setLocation(String aLocation)
		{location = aLocation;}

	public String getId()
		{return this.id;}

	public String getCustomerEmail()
		{return this.customerEmail;}

	public String getBedId()
		{return this.bedId;}

	public double getTotal()
		{return this.total;}

	public String getDateRange()
		{return this.dateRange;}

	public String getLocation()
		{return this.location;}
	
	public String toString()
		{
		return this.id + ", " + this.customerEmail + ", " + this.bedId + ", " +
				this.total + ", " + this.dateRange + ", " + this.location;
				
				
		}
	

}


public class Bed {
	
	/**
	 */
	private String id;
	/**
	 */
	private String room;
	private String date;
	private double price;
	private String currency;
	private boolean booked;
	
	public Bed()
		{
		id = "x"; room = "1"; date = "99999999"; 
		price = 0;
		currency = "USD";
		booked = false;
		}
	
	public Bed(String anId, String aRoom, String aDate, 
			   String aCurrency, double aPrice, boolean aBooked)
		{
		id = anId;
		room = aRoom;
		date = aDate;
		price = aPrice;
		booked = aBooked;
		currency = aCurrency;
		}

	public void setId(String anId)
		{id = anId;}
	
	public void setRoom(String aRoom)
		{room = aRoom;}

	public void setDate(String aDate)
		{date = aDate;}

	public void setPrice(double aPrice)
		{price = aPrice;}

	public void setCurrency(String aCurrency)
		{currency = aCurrency;}

	public void setBooked(boolean aStatus)
		{booked = aStatus;}

	public String getId()
		{return this.id;}

	public String getRoom()
		{return this.room;}

	public String getDate()
		{return this.date;}

	public double getPrice()
		{return this.price;}

	public String getCurrency()
		{return this.currency;}
	
	public boolean getBooked()
		{return this.booked;}
	
	public boolean ifAvailable()
		{
		if(this.booked == false)
			return true;
		return false;
		}
	
	@Override
	public String toString()
		{
		return this.id + ", " + this.room + ", " +
			   this.date + ", " + this.price + ", " +
			   this.currency + ", " + this.booked;
		}
}

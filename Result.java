
public class Result {
	
	/**
	 */
	private String id; //This will contain both id and room(id:room)
	private String position; //The position of the bed in the list
	private double total;
	private String dateRange;
	private int numOfBeds;
	
	public Result()
		{
		id = "";
		position = "";
		total = 0;
		dateRange = "";
		numOfBeds = 0;
		}
	
	public Result(String anId, String aPosition, double aTotal, 
				String aDateRange, int aNumOfBeds)
		{
		id = anId;
		position = aPosition;
		total = aTotal;
		dateRange = aDateRange;
		numOfBeds = aNumOfBeds;
		}
	
	public void setId(String anId)
		{id = anId;}

	public void setPosition(String aPosition)
		{position = aPosition;}
	

	public void setTotal(double aTotal)
		{total = aTotal;}

	public void setDateRange(String aDateRange)
		{dateRange = aDateRange;}

	public void setNumOfBeds(int aNumOfBeds)
		{numOfBeds = aNumOfBeds;}

	public String getId()
		{return this.id;}
	
	public String getPosition()
		{return this.position;}

	public double getTotal()
		{return this.total;}

	public String getDateRange()
		{return this.dateRange;}

	public int getNumOfBeds()
		{
		return this.numOfBeds;
		}
	
	public String toString()
		{
		return this.id + ", " + this.position + ", " + this.total + 
				", " + this.dateRange + ", " + this.numOfBeds; 
		}
	
}

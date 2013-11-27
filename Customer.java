
public class Customer {
	
	/**
	 */
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String cc;
	private String cc_expiration;
	private String cc_code;
	private String phone;
	private String fbId;
	private String twitId;
	
	public Customer()
		{
		id = "n/a";
		firstname = "n/a";
		lastname = "n/a";
		email = "n/a";
		cc = "n/a";
		cc_expiration = "n/a";
		cc_code = "n/a";
		phone = "n/a";
		fbId = "n/a";
		twitId = "n/a";		
		}
	
	public Customer(String anId, String aFirst, String aLast, 
					String anEmail, String ccNum, String ccExp, String ccCode, 
					String aPhone, String aFbId, String aTwitId)
		{
		id = anId;
		firstname = aFirst;
		lastname = aLast;
		email = anEmail;
		cc = ccNum;
		cc_expiration = ccExp;
		cc_code = ccCode;
		phone = aPhone;
		fbId = aFbId;
		twitId = aTwitId;
		}

	public void setId(String anId)
		{id = anId;}
	
	public void setFirstName(String aFirst)
		{firstname = aFirst;}
	
	public void setLastName(String aLast)	
		{lastname = aLast;}

	public void setEmail(String anEmail)
		{email = anEmail;}
	
	public void setCC(String ccNum)
		{cc = ccNum;}
	
	public void setCCExpiration(String ccExp)
		{cc_expiration = ccExp;}
	
	public void setCCCode(String aCode)
		{cc_code = aCode;}

	public void setPhone(String aPhone)
		{phone = aPhone;}

	public void setFbId(String anId)
		{fbId = anId;}

	public void setTwitId(String anId)
		{twitId = anId;}

	public String getId()
		{return this.id;}
	
	public String getFirstName()
		{return this.firstname;}
	
	public String getLastName()
		{return this.lastname;}

	public String getEmail()
		{return this.email;}
	
	public String getCC()
		{return this.cc;}
	
	public String getCCExpiration()
		{return this.cc_expiration;}
	
	public String getCCcode()
		{return this.cc_code;}

	public String getPhone()
		{return this.phone;}
	
	public String getFbId()
		{return this.fbId;}

	public String getTwitId()
		{return this.twitId;}
	
	@Override
	public String toString()
		{
		return this.id + ", " + this.firstname + ", " +
			   this.lastname + ", " + this.email + ", " + 
			   this.cc + ", " + this.cc_expiration + ", " + 
			   this.cc_code + ", "+ this.phone  + ", " +
			   this.fbId + ", " + this.twitId;
		}
	
	
	
	

}

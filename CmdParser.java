import java.util.ArrayList;


public class CmdParser {
	
	public String parseXMLName(String arg)
		{
		try{
			String xmlFile = arg.substring(arg.indexOf("\'"));
			xmlFile = xmlFile.replace("\'", "");
			return xmlFile;
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseCity(String arg)
		{
		try{
			int offset = 7;
			int start = offset + arg.indexOf("--city");
			int end = arg.indexOf(" -", start);
			String city = arg.substring(start, end);
			return city.trim().replace("\"", "").toLowerCase();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseSearchId(String arg)
		{
		try{
			int offset = 12;
			int start = offset + arg.indexOf("--search_id");
			int end = arg.indexOf(" ", start);
			String searchId = arg.substring(start, end);
			return searchId.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseUserId(String arg)
		{
		try{
			int offset = 10;
			int start = offset + arg.indexOf("--user_id");
			String userId = arg.substring(start);
			return userId.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseBookingId(String arg)
		{
		try{
			int offset = 13;
			int start = offset + arg.indexOf("--booking_id");
			String userId = arg.substring(start);
			return userId.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseStartDate(String arg)
		{
		try{
			int offset = 13;
			int start = offset + arg.indexOf("--start_date");
			int end = arg.indexOf(" ", start);
			String date = arg.substring(start, end);
			return date.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseEndDate(String arg)
		{
		try{
			int offset = 11;
			int start = offset + arg.indexOf("--end_date");
			int end = arg.indexOf(" ", start);
			String date = arg.substring(start, end);
			return date.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseEndDate1(String arg)
		{
		try{
			int offset = 11;
			int start = offset + arg.indexOf("--end_date");
			String date = arg.substring(start);
			return date.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseBeds(String arg)
		{
		try{
			int offset = 7;
			int start = offset + arg.indexOf("--beds");
			String date = arg.substring(start);
			return date.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseId(String arg)
		{
		try{
			int offset = 10;
			int start = offset + arg.indexOf("--user_id");
			int end = arg.indexOf(" ", start);
			String id = arg.substring(start, end);
			return id.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseFirstName(String arg)
		{
		try{
			int offset = 13;
			int start = offset + arg.indexOf("--first_name");
			int end = arg.indexOf(" -", start);
			String name = arg.substring(start, end);
			return name.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseLastName(String arg)
		{
		try{
			int offset = 12;
			int start = offset + arg.indexOf("--last_name");
			int end = arg.indexOf(" -", start);
			String name = arg.substring(start, end);
			return name.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseEmail(String arg)
		{
		try{
			int offset = 8;
			int start = offset + arg.indexOf("--email");
			int end = arg.indexOf(" ", start);
			String email = arg.substring(start, end);
			return email.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseEmailForView(String arg)
		{
		try{
			int offset = 8;
			int start = offset + arg.indexOf("--email");
			String email = arg.substring(start);
			return email.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	
	public String parseCCNumber(String arg)
		{
		try{
			int offset = 12;
			int start = offset + arg.indexOf("--cc_number");
			int end = arg.indexOf(" ", start);
			String cc_number = arg.substring(start, end);
			return cc_number.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}	
		}
	
	public String parseCCExpiration(String arg)
		{
		try{
			int offset = 18;
			int start = offset + arg.indexOf("--expiration_date");
			int end = arg.indexOf(" ", start);
			String cc_exp = arg.substring(start, end);
			return cc_exp.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parseCCCode(String arg)
		{
		try{
			int offset = 16;
			int start = offset + arg.indexOf("--security_code");
			int end = arg.indexOf(" ", start);
			String cc_code = arg.substring(start, end);
			return cc_code.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public String parsePhone(String arg)
		{
		try{
			int offset = 8;
			int start = offset + arg.indexOf("--phone");
			int end = arg.indexOf(" ", start);
			if(end == -1)
				end = arg.indexOf("]", start);
			String phone = arg.substring(start, end);
			return phone.trim();
			}
		catch(IndexOutOfBoundsException e)
			{return null;}
		}
	
	public ArrayList<String> parseUserData(String arg)
		{
		ArrayList<String> userInfo = new ArrayList<String>();
		userInfo.add(this.parseId(arg));
		userInfo.add(this.parseFirstName(arg));
		userInfo.add(this.parseLastName(arg));
		userInfo.add(this.parseEmail(arg));
		userInfo.add(this.parseCCNumber(arg));
		userInfo.add(this.parseCCExpiration(arg));
		userInfo.add(this.parseCCCode(arg));
		userInfo.add(this.parsePhone(arg));
		return userInfo;
		}
}














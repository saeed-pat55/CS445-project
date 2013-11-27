import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Search {
	
	public String customerById(String id, String txtFile)
		{
		boolean check = this.ifTxtFileExists(txtFile);
		if(check)
			{
			try{
				Scanner read = new Scanner(new FileReader(txtFile));
				while(read.hasNextLine())
					{
					String customer = read.nextLine();
					String[] token = customer.split(", ");
					if(token[0].equals(id))
						{
						read.close();
						return customer;
						}
					}
				read.close();
				}
			catch(FileNotFoundException e)
				{return "-1";}
			}
		return "0";
		}
	
	public String customerByEmail(String email, String txtFile)
		{
		boolean check = this.ifTxtFileExists(txtFile);
		if(check)
			{
			try{
				Scanner read = new Scanner(new FileReader(txtFile));
				while(read.hasNextLine())
					{
					String customer = read.nextLine();
					if(customer.contains(email))
						{
						read.close();
						return customer;
						}
					}
				read.close();
				}
			catch(FileNotFoundException e)
				{return "-1";}
			}
		return "0";
		}
	/*
	public int searchCustByFbId(String fbId, String[] customers)
		{
		for(int i = 0; i < customers.length; i++)
			{
			if(customers[i].contains(fbId));
				return i;
			}
		return -1;
		}
	
	
	public int searchCustByTwitter(String twitterId, String[] customers)
		{
		for(int i = 0; i < customers.length; i++)
			{
			if(customers[i].contains(twitterId));
				return i;
			}
		return -1;
		}
	
	*/
	
	/*
	 * Will check the new date with old date for any matches.
	 * If found, overwrite the Bed date 
	 */
	public ArrayList<Bed> dataOverwrite(ArrayList<Bed> oldList, 
									ArrayList<Bed> newList)
		{
		boolean flag = true;
		int count = 0;
		int count1 = 0;
		for(int i = 0; i < newList.size(); i++)
			{
			flag = true;
			Bed newBed = newList.get(i);
			String newId = newBed.getId();
			String newRoom = newBed.getRoom();
			String newDate = newBed.getDate();
			double newPrice = newBed.getPrice();
			String newCurrency = newBed.getCurrency(); 
			for(int j = 0; j < oldList.size(); j++)
				{
				Bed oldBed = oldList.get(j);
				String oldId = oldBed.getId();
				String oldRoom = oldBed.getRoom();
				String oldDate = oldBed.getDate();
				boolean oldBooked = oldBed.getBooked();
				if(newId.equals(oldId) && newRoom.equals(oldRoom) &&
					newDate.equals(oldDate))
					{
					if(oldBooked)
						{
						count1++;
						flag = false;
						break;
						}
					oldBed.setPrice(newPrice);
					oldBed.setCurrency(newCurrency);
					oldList.set(j, oldBed);
					flag = false;
					count++;
					break;
					}
				}
			if(flag)
				oldList.add(newBed);
			}
		if(count > 0 || count1 > 0)
			System.out.println("Existing data was found!\n" +
								"Overwrite performed for " + count + " beds!\n" +
							    "Overwrite failed for " + count1 + " beds!(Reason: Booked)");
		return oldList;
		}
	
	
	public Date convertStringToDate(String aDate)
		{
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(aDate);
			} 
		catch (ParseException e) 
			{
			System.out.println("Error parsing String to Date!");
			}
		return date;
		}
	
	public String convertDatetoString(Date aDate)
		{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String date = df.format(aDate);
		return date;
		}
	
	public String[] convertDateListToString(List<Date> dateList)
		{
		String[] strArr = new String[dateList.size()];
		
		for(int i = 0; i < dateList.size(); i++)
			strArr[i] = convertDatetoString(dateList.get(i));
		
		return strArr;
		}
	
	public String[] getDatesInRange(String start, String end)
		{
		Date startDate = this.convertStringToDate(start);
		Date endDate = this.convertStringToDate(end);
		String[] dateArr;	
	    List<Date> dates = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
	
		while (calendar.getTime().before(endDate))
			{
			Date result = calendar.getTime();
			dates.add(result);
			calendar.add(Calendar.DATE, 1);
			}
		dateArr = convertDateListToString(dates);
		return dateArr;
		}
	
	public int countDaysInRange(String start, String end)
		{
		String[] dates = getDatesInRange(start, end);
		return dates.length;
		}
	
	public int bedForDate(int startpos, String date, ArrayList<Bed> bedList)
		{
		for(int i = startpos; i < bedList.size(); i++)
			{
			Bed bed = bedList.get(i);
			if(bed.ifAvailable() && bed.getDate().equals(date))
				return i;
			}
		return -1;
		}
	
	public String allBeds(String startDate, String endDate,
						  ArrayList<Bed> bedList)
	
		{
		String[] dates = this.getDatesInRange(startDate, endDate);
		String result = "";
		for(int i = 0; i < bedList.size(); i++)
			{
			Bed bed = bedList.get(i);
			if(bed.ifAvailable())
				{
				for(int j = 0; j < dates.length; j++)
					{
					if(bed.getDate().equals(dates[j]))
						{
						result += "," + i;
						break;
						}
					}
				}
			}
		return result;
		}
	
	
	/*
	 * WILL HAVE TO SORT LIST BY BED ID AND ROOM
	 */
	public String bedForRange(String startDate, String endDate, 
								ArrayList<Bed> bedList, int startPosition)
		{
		String positions = "";
		String[] dates = this.getDatesInRange(startDate, endDate);
		int check = 0, startPos = 0, temp = startPosition;
		boolean flag = true;
		
		if(dates.length == 1)
			{
			int pos = bedForDate(startPosition, dates[0], bedList);
			return (pos + "");
			}
		
		
		if(dates.length > bedList.size())
			return "null";
		
		/*
		if(startPosition == bedList.size() ||
				startPosition == (bedList.size() - 1))
			return "null";
		*/
		while(flag)
			{
			positions = "null";
			check = 0;
			startPos = this.bedForDate(temp, dates[0], bedList);
			if(startPos == -1)
				break;
			
			temp = startPos + 1;
			check++;
			positions = startPos + "";
			String id = bedList.get(startPos).getId();
			String room = bedList.get(startPos).getRoom();
				
			for(int j = startPos + 1; j < bedList.size(); j++)
				{
				if(bedList.get(j).ifAvailable() &&
				   bedList.get(j).getId().equals(id) &&
				   bedList.get(j).getRoom().equals(room) &&
				   bedList.get(j).getDate().equals(dates[check]))
						{
						positions += "," + j;
						check++;
						}
				if(check == dates.length)
						{
						flag = false;
						break;
						}
				}
			}
		return positions;
		}
	
	
	public String multiBedsForRange(String startDate, String endDate, 
								int numOfBeds, int startPosition,
								ArrayList<Bed> bedList)
		{
		int pos = startPosition;
		int count = 0;
		String result = "";
		
		while(true)
			{
			String temp = bedForRange(startDate, endDate, 
										  bedList, pos);
			
			if(temp.equals("null") || temp.equals("-1"))
				{
				break;
				}
			
			count++;
			result += "-" + temp;
			String[] token = temp.split(",");
			pos = Integer.parseInt(token[0]) + 1;
			}
		if(count >= numOfBeds)
			{
			result = result.replaceFirst("-", "");
			return result;
			}
		return "null";
		}
	
	public String getCancelPolicy(String restrictionStr)
		{
		String[] token = restrictionStr.split(", ");
		return token[4];
		}

	public int resultById(String searchId, ArrayList<Result> resultList)
		{
		for(int i = 0; i < resultList.size(); i++)
			{
			if(resultList.get(i).getId().equals(searchId))
				return i;
			}
		return -1;
		}
	
	
	public String bookingById(String aBookingId)
		{
		try {
			Scanner read = new Scanner(new FileReader("booking.txt"));
			while(read.hasNextLine())
				{
				String bookingStr = read.nextLine();
				String[] token = bookingStr.split(", ");
				if(token[0].equals(aBookingId))
					{
					read.close();
					return bookingStr;
					}
				}
			read.close();
			return "0";
			} 
		catch (FileNotFoundException e) 
			{return "-1";}
		}
	
	public String currentDir()
		{
		final String dir = System.getProperty("user.dir");
        return dir;
		}
	 
	//===============Methods for searching text files===============
	
	/**
	 * 
	 * @param pathArr A string array of txt file paths
	 * @return filenames a String array of txt file names
	 * 
	 * This methods takes a String array of txt file paths,
	 * splits each element/path at "/", and creates
	 * a new array with just the filenames, ie, last element
	 * of the token array.
	 */
	public String[] parseFileFromPath(String[] pathArr)
		{
		String[] tokens;
		String[] filenames = new String[pathArr.length];
		for(int i = 0; i < pathArr.length; i++)
			{
			tokens = pathArr[i].split("/");
			filenames[i] = tokens[tokens.length - 1];
			}
		return filenames;
		}
	
	 /**
	  * 
	  * @param dirName the directory to search for
	  * @return fileArr an array of txt files in the dir
	  * 
	  * This method takes in a directory path and searches
	  * it for txt files, and then returns an array of all
	  * txt filenames.
	  */
	 public String[] txtFiles(String aDirPath)
	  	{
	    File dir = new File(aDirPath);
	    File[] txtFiles = dir.listFiles(new FilenameFilter(){ 
	    	            public boolean accept(File dir, String filename)
	    	              { return filename.endsWith(".txt"); }
	    				} );
	    String[] pathArr = new String[txtFiles.length];
	    for(int i = 0; i < txtFiles.length; i++)
	    	{
	    	pathArr[i] = txtFiles[i] + "";
	    	}
	    String[] fileArr = this.parseFileFromPath(pathArr);
	    return fileArr;
	    }
	
	 //Searches if the given file exists in current working dir
	 public boolean ifTxtFileExists(String filename)
	 	{
		String[] files = this.txtFiles(this.currentDir());
		for(int i = 0; i < files.length; i++)
			{
			if(files[i].equals(filename))
				return true;
			}
		return false;
	 	}
	 public String[] txtFilesWithKey(String key, String aDirPath)
	 	{
		 String files = "";
		 String[] allFiles = this.txtFiles(aDirPath);
		 for(int i = 0; i < allFiles.length; i++)
		 	{
			 if(allFiles[i].contains(key))
				 files += "," + allFiles[i];
		 	}
		 files = files.replaceFirst(",", "");
		 String[] keyFiles = files.split(",");
		 return keyFiles;
	 	}
}

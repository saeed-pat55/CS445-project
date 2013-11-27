import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class ProcessBooking {
	
	//Generate an int between 1 and max and 
		//pad it with desired amount of zeros 
		public String generateId(int max, int idLength)
			{
			Random ran = new Random();
			int x = ran.nextInt(max + 1);
			String id = padZeros(x, idLength);
			return id;
			}
		
		public String padZeros(int number, int padAmount)
			{
			String pad = "%0" + padAmount + "d";
			return String.format(pad, number);
			}
		
		public int[] convertStrToInt(String[] strArr)
			{
			int[] intArr = new int[strArr.length];
			try{
				for(int i = 0; i < strArr.length; i++)
					intArr[i] = Integer.parseInt(strArr[i]);
			   }
			catch(NumberFormatException e){}
			return intArr;
			}
	
		//Process for a single bed for a single day
		//numBeds == 1 && dates.length == 1
		public void process1(String userId, Result result, Hostel hostel)
			{
			try{
				Search search = new Search();
				TXTHandler txt = new TXTHandler();
				String customer = search.customerById(userId, "customer.txt");
				if(customer.equals("0"))
					System.out.println("No customer found with ID: " + userId);
				else if(customer.equals("-1"))
					System.out.println("File customer.txt not found!");
				else
					{
					String[] custInfo = customer.split(", "); 
					int pos = Integer.parseInt(result.getPosition());
					hostel.getBedArrList().get(pos).setBooked(true);
					String id = generateId(999999, 6);
					String email = custInfo[3];
					String bedId = hostel.getBedArrList().get(pos).getId();
					String room = hostel.getBedArrList().get(pos).getRoom();
					double total = result.getTotal();
					String dateRange = result.getDateRange();
					Booking booking = new Booking(id, email, bedId +"-"+ room, total, 
												dateRange, hostel.getName());
					
						if(search.ifTxtFileExists("booking.txt"))
							{txt.writeAppend("booking.txt", booking.toString());}
						else
							{
							txt.createTxtFile("booking.txt");
							txt.write("booking.txt", booking.toString());
							}
					System.out.println("Booking was successful!\n" +
										" BOOKING ID: " + id + "\n" +
										" NAME: " + custInfo[1] + " " + custInfo[2] +
									  "\n TOTAL: " + total);
					
					}
				}
			catch(IndexOutOfBoundsException e)
				{System.out.println("Error in processBooking1() method!(IndexOutOfBounds)");}
			catch(NumberFormatException e)
				{System.out.println("Error in processBooking1() method!(NumberFormat)");}
			}
	
		//Process for a single bed for multiple days
		//numBeds == 1 && dates.length > 1(comma delimited string)
		public void process2(String userId, Result result, Hostel hostel)
			{
			try{
				Search search = new Search();
				TXTHandler txt = new TXTHandler();
				String customer = search.customerById(userId, "customer.txt");
				if(customer.equals("0"))
					System.out.println("No customer found with ID: " + userId);
				else if(customer.equals("-1"))
					System.out.println("File customer.txt not found!");
				else
					{
					String[] custInfo = customer.split(", "); 
					String[] posArrStr = result.getPosition().split(",");
					int[] posArr = this.convertStrToInt(posArrStr);
					for(int i = 0; i < posArr.length; i++)
						{
						hostel.getBedArrList().get(posArr[i]).setBooked(true);
						}																
						
					String id = generateId(999999, 6);
					String email = custInfo[3];
					String bedId = hostel.getBedArrList().get(posArr[0]).getId();
					String room = hostel.getBedArrList().get(posArr[0]).getRoom();
					double total = result.getTotal();
					String dateRange = result.getDateRange();
					Booking booking = new Booking(id, email, bedId +"-"+ room, total, 
												dateRange, hostel.getName());
						
					if(search.ifTxtFileExists("booking.txt"))
						{txt.writeAppend("booking.txt", booking.toString());}
					else
						{
						txt.createTxtFile("booking.txt");
						txt.write("booking.txt", booking.toString());
						}
					System.out.println("Booking was successful!");
					}
				}
			catch(IndexOutOfBoundsException e)
				{System.out.println("Error in processBooking2() method!(IndexOutOfBounds)");}
			catch(NumberFormatException e)
				{System.out.println("Error in processBooking2() method!(NumberFormat)");}
			}
		
		//Process for multiple beds for a single day
		//numBeds > 1 && dates.length == 1 (':' delimited Result position)
		public void process3(String userId, Result result, Hostel hostel)
			{
			try{
				Search search = new Search();
				TXTHandler txt = new TXTHandler();
				String customer = search.customerById(userId, "customer.txt");
				if(customer.equals("0"))
					System.out.println("No customer found with ID: " + userId);
				else if(customer.equals("-1"))
					System.out.println("File customer.txt not found!");
				else
					{
					String[] custInfo = customer.split(", "); 
					String[] posArrStr = result.getPosition().split(":");
					int[] posArr = this.convertStrToInt(posArrStr);
					String bedInfo = "";
					for(int i = 0; i < posArr.length; i++)
						{
						hostel.getBedArrList().get(posArr[i]).setBooked(true);
						String bedId = hostel.getBedArrList().get(posArr[i]).getId();
						String room = hostel.getBedArrList().get(posArr[i]).getRoom();
						bedInfo += ":" + bedId + "-" + room;
						}																
					bedInfo = bedInfo.replaceFirst(":", "");
					String id = generateId(999999, 6);
					String email = custInfo[3];
					double total = result.getTotal();
					String dateRange = result.getDateRange();
					Booking booking = new Booking(id, email, bedInfo, total, 
													dateRange, hostel.getName());
						
					if(search.ifTxtFileExists("booking.txt"))
						{txt.writeAppend("booking.txt", booking.toString());}
					else
						{
						txt.createTxtFile("booking.txt");
						txt.write("booking.txt", booking.toString());
						}
					System.out.println("Booking was successful!");
					}
				}
			catch(IndexOutOfBoundsException e)
				{System.out.println("Error in processBooking3() method!(IndexOutOfBounds)");}
			catch(NumberFormatException e)
				{System.out.println("Error in processBooking3() method!(NumberFormat)");}
			}
		
		//Process for multiple beds for multiple days
		//numBeds > 1 && dates.length > 1 (':' and ',' delimited Result position)
		public void process4(String userId, Result result, Hostel hostel)
			{
			try{
				Search search = new Search();
				TXTHandler txt = new TXTHandler();
				String customer = search.customerById(userId, "customer.txt");
				if(customer.equals("0"))
					System.out.println("No customer found with ID: " + userId);
				else if(customer.equals("-1"))
					System.out.println("File customer.txt not found!");
				else
					{
					String[] custInfo = customer.split(", "); 
					String[] bedsArr = result.getPosition().split(":");
					String bedInfo = "";
					for(int i = 0; i < bedsArr.length; i++)
						{
						String[] posArrStr = bedsArr[i].split(","); 
						int[] posArr = convertStrToInt(posArrStr);
						for(int j = 0; j < posArr.length; j++)
							{
							hostel.getBedArrList().get(posArr[j]).setBooked(true);
							}
						String bedId = hostel.getBedArrList().get(posArr[0]).getId();
						String room = hostel.getBedArrList().get(posArr[0]).getRoom();
						bedInfo += ":" + bedId + "-" + room;
						}
					bedInfo = bedInfo.replaceFirst(":", "");
					String id = generateId(999999, 6);
					String email = custInfo[3];
					double total = result.getTotal();
					String dateRange = result.getDateRange();
					Booking booking = new Booking(id, email, bedInfo, total, 
													dateRange, hostel.getName());
						
					if(search.ifTxtFileExists("booking.txt"))
						{txt.writeAppend("booking.txt", booking.toString());}
					else
						{
						txt.createTxtFile("booking.txt");
						txt.write("booking.txt", booking.toString());
						}
					System.out.println("Booking was successful!");
					}
				}
			catch(IndexOutOfBoundsException e)
				{System.out.println("Error in processBooking3() method!(IndexOutOfBounds)");}
			catch(NumberFormatException e)
				{System.out.println("Error in processBooking3() method!(NumberFormat)");}
			}
		
		public boolean checkLate(String dateToday, String bookingStart, 
									String policy)
			{
			Search search = new Search();
			int temp = Integer.parseInt(policy);
			double  policyDays = temp/24;
			int countDays = search.countDaysInRange(dateToday, bookingStart);
			if(policyDays > countDays)
				return true;
			return false;
			}
		
		public void cancel(String dateToday, String policy, 
							String aBookingId, ArrayList<Bed> bedList)
			{
			Search search = new Search();
			String booking = search.bookingById(aBookingId);
			if(booking.equals("0"))
				{System.out.println("No booking found with ID: " + aBookingId);}
			else if(booking.equals("-1"))
				{System.out.println("File booking.txt not found!");}
			else
				{
				String[] token = booking.split(", ");
				String[] range = token[4].split("-");	
				if(checkLate(dateToday, range[0], policy))
					System.out.println("Late fee was charged!");
				String[] dates = search.getDatesInRange(range[0], range[1]);
				String bedStr = token[2];
				if(bedStr.contains(":"))
					{
					int count = 0;
					String[] bedStrArr = bedStr.split(":");
					while(count < bedStrArr.length)
						{
						String[] bedInfo = bedStrArr[count].split("-");
						String bedId = bedInfo[0];
						String room = bedInfo[1];
						for(int i = 0; i < bedList.size(); i++)
							{
							Bed bed = bedList.get(i);
							if(bed.getId().equals(bedId) &&
							   bed.getRoom().equals(room))
								{
								for(int j = 0; j < dates.length; j++)
									{
									if(bed.getDate().equals(dates[j]))
										{
										bedList.get(i).setBooked(false);
										break;
										}
									}
								}
							}
						count++;
						}
					}
				else
					{
					String[] bedInfo = bedStr.split("-");
					String bedId = bedInfo[0];
					String room = bedInfo[1];
					for(int i = 0; i < bedList.size(); i++)
						{
						Bed bed = bedList.get(i);
						if(bed.getId().equals(bedId) &&
						   bed.getRoom().equals(room))
							{
							for(int j = 0; j < dates.length; j++)
								{
								if(bed.getDate().equals(dates[j]))
									{
									bedList.get(i).setBooked(false);
									break;
									}
								}
							}
						}
					}
				System.out.println("Cancellation succesful!");
				}
			}
		
		public void calculateRevenue(String bookingFile)
			{
			try{
				double total = 0;
				int bookCount = 0, cancelCount = 0;
				
				Scanner read = new Scanner(new FileReader(bookingFile));
				while(read.hasNextLine())
					{
					String info = read.nextLine();
					if(info.startsWith("*"))
						{cancelCount++;}
					else
						{
						String[] token = info.split(", ");
						total += Double.parseDouble(token[3]);
						bookCount++;
						}
					}
				System.out.println("===//REVENUE SUMMARY\\\\===\n" +
								   "Bookings: " + bookCount + "\n" +
								   	"  - Earnings: $" + total + "\n" +
								   "Cancellations: " + cancelCount);
				}
			catch(FileNotFoundException e)
				{System.out.println("Error calculateRevenue(), file not found!");}
			}
		
		public double calculateOccupancy(String filename, String dateStart, String dateEnd)
			{
			TXTHandler txt = new TXTHandler();
			ArrayList<Bed> bedList = new ArrayList<Bed>();
			txt.loadBedData(filename, bedList);
			
			int countBooked = 0, countFree = 0;
			for(int i = 0; i < bedList.size(); i++)
				{
				if(bedList.get(i).getDate().equals(dateStart))
						{
						int count = i;
						while(true)
							{
							if(bedList.get(count).ifAvailable())
								countFree++;
							else
								countBooked++;
							if(count == bedList.size() - 1)
								break;
							if(bedList.get(count + 1).getDate().equals(dateEnd))
								break;
							count++;
							}
						}
				break;
				}
			
			double total = countBooked + countFree;
			System.out.println("xx " + countBooked);
			double occupancy = (countBooked/total) * 100;
			occupancy = Math.round(occupancy * 100)/100;
			return occupancy;
			}
		
		
		
		
}

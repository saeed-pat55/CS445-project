import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;


public class Main {
	
	
	//This will write address, contact and restriction data from
		//XML file to txt file
	public static void writeHostelBackgroundData(String xmlFile, 
													String txtFile)
		{
		TXTHandler txt = new TXTHandler();
		txt.write(txtFile, getAddress(xmlFile));
		txt.writeAppend(txtFile, getContact(xmlFile));
		txt.writeAppend(txtFile, getRestrictions(xmlFile));
		}
	
	public static Customer createCustomer(String id, String arg)
		{
		CmdParser cmdParser = new CmdParser();
		Customer cust = new Customer(id, 
				cmdParser.parseFirstName(arg),
    			cmdParser.parseLastName(arg),
    			cmdParser.parseEmail(arg),
    			cmdParser.parseCCNumber(arg),
    			cmdParser.parseCCExpiration(arg),
    			cmdParser.parseCCCode(arg),
    			cmdParser.parsePhone(arg),
    			"n/a", "n/a");
		return cust;
		}
	
	public static void modifyCustomer(Customer customer, 
										ArrayList<String> newData)
		{
		customer.setFirstName(newData.get(1));
		customer.setLastName(newData.get(2));
		customer.setEmail(newData.get(3));
		customer.setCC(newData.get(4));
		customer.setCCExpiration(newData.get(5));
		customer.setCCCode(newData.get(6));
		customer.setPhone(newData.get(7));
		}
	
	public static void printCustomer(Customer customer)
		{
		System.out.println("====Customer info====");
		System.out.println("Id: " + customer.getId());
		System.out.println("Name: " + customer.getFirstName() + 
							" " + customer.getLastName());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("CC: " + customer.getCC() + " Expiration: " + 
						customer.getCCExpiration() + " Code: " + 
						customer.getCCcode());
		System.out.println("Phone: " + customer.getPhone());
		System.out.println("Facebook: " + customer.getFbId());
		System.out.println("Twitter: " + customer.getTwitId());
		}
	
	public static void printCustomerFrmStr(String custInfo)
		{
		String[] token = custInfo.split(", ");
		System.out.println("====Customer info====");
		System.out.println("Id: " + token[0]);
		System.out.println("Name: " + token[1] + " " + token[2]);
		System.out.println("Email: " + token[3]);
		System.out.println("CC: " + token[4] + " Expiration: " + 
						token[5] + " Code: " + token[6]);
		System.out.println("Phone: " + token[7]);
		System.out.println("Facebook: " + token[8]);
		System.out.println("Twitter: " + token[9]);
		}
	
	public static void printMultipleFilesMenu(String[] files)
		{
		TXTHandler txt = new TXTHandler();
		String address = txt.getAddresses(files);
		address = address.replaceFirst("# ", "");
		String[] addrArr = address.split("# ");
		System.out.println("\n***Multiple locations found for that city!***\n" +
						   "Select a location from below:");
		for(int i = 0; i < files.length; i++)
			{
			System.out.println(i + " = " + files[i] + " (" +
								addrArr[i] + ")");
			}
		}
	
	public static void printOverwriteMenu(String[] files)
		{
		TXTHandler txt = new TXTHandler();
		String address = txt.getAddresses(files);
		address = address.replaceFirst("# ", "");
		String[] addrArr = address.split("# ");
		System.out.println("\n***Existing Data for city found!***\n" +
						   "Select option to overwrite or create" +
						   " new txt file:");
		
		System.out.println(files.length + " = " + "Create new file");
		for(int i = 0; i < files.length; i++)
			{
			System.out.println(i + " = " + files[i] + " (" +
								addrArr[i] + ")");
			}
		}
	
	public static String formatDate(String date)
		{
		String year = date.substring(0,	4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		return month + "/" + day + "/" + year;
		}
	
	
	public static void printSearchResult(int[] posArr, String[] dateArr,
										ArrayList<Bed> bedList)
		{
		try{
			ArrayList<Bed> myList = new ArrayList<Bed>();
			
			String[] dates = new String[posArr.length];
			for(int i = 0; i < posArr.length; i++)
				{
				Bed bed = bedList.get(posArr[i]);
				dates[i] = formatDate(bed.getDate()) + ": ";
				myList.add(bed);
				}
			System.out.println("DATE \\ BED \\ ROOM \\ PRICE");
			for(int i = 0; i < dates.length; i++)
				{
				String[] token = myList.get(i).toString().split(", ");
				System.out.println(dates[i] + token[0] + "  " +
									token[1] + "  " + token[3]);
				}
			}
		catch(IndexOutOfBoundsException e){}
		}
	
	//Takes a soreted by total ArrayList<Result> of all the beds with 
	//which combinations can be made for grouping based on need, ie, numOfBeds.
	//The because the requirement for the project was to only display
	//the lowest priced combos, hence, some beds in the end of the list may
	//be ignored as they do form a complete group
	
	public static ArrayList<Result> groupBedsByAmount(int numOfBeds, 
												ArrayList<Result> resultList,
												String dateRange)
		{
		double temp = (resultList.size() / numOfBeds);
		String amount = "" + temp;
		String[] token = amount.split("\\.");
		int groupAmount = Integer.parseInt(token[0]);
		ArrayList<Result> newResultList = new ArrayList<Result>();
		
		for(int i = 0; i <= groupAmount; i += numOfBeds)
			{
			String id = generateId(9999, 4);
			String position = "";
			double total = 0;
			for(int j = i; j < (i + numOfBeds); j++)
				{
				position += ":" + resultList.get(j).getPosition();
				total += resultList.get(j).getTotal();
				}
			position = position.replaceFirst(":", "");
			Result result = new Result(id, position, total, dateRange, numOfBeds);
			newResultList.add(result);
			}
		return newResultList;
		}
	
	
	
	//When Result object contains only a bed for a single day
	public static void printResultObj(Result result, 
										ArrayList<Bed> bedList)
		{
		try{
			String[] tokens = result.toString().split(", ");
			int pos = Integer.parseInt(tokens[1]);
			String bedId = bedList.get(pos).getId();
			String room = bedList.get(pos).getRoom();
			System.out.println("  search_id: " + tokens[0] +
							   ", $" + tokens[2] + ", " +
								"bed #" + bedId + ", " + "room #" + room);
			}
		catch(NumberFormatException e)
			{System.out.println("Error! Main() printResultObj()");}
		catch(PatternSyntaxException e)
			{System.out.println("Error! Main() printResultObj()");}
		}
	
	
	//When Result object contains positions for a single bed for multiple
	//days(a comma delimited string) => numOfBeds == 1
	public static void printResultObj1(Result result,
										ArrayList<Bed> bedList)
		{
		String[] token = result.getPosition().split(",");
		try{
			int pos = Integer.parseInt(token[0]);
			String[] tokens = result.toString().split(", ");
			String bedId = bedList.get(pos).getId();
			String room = bedList.get(pos).getRoom();
			System.out.println("  search_id: " + tokens[0] +
						   ", $" + tokens[2] + ", " +
							"bed #" + bedId + ", " + "room #" + room);
			}
		catch(NumberFormatException e)
			{System.out.println("Error! Main() printResultObj1()");}
		catch(PatternSyntaxException e)
			{System.out.println("Error! Main() printResultObj1()");}
		catch(IndexOutOfBoundsException e)
			{System.out.println("Error! Main() printResultObj1()");}
		}
	
	//Printing info of all Result Objects in ArrayList<Result>, where
	//each is printed using the printResultObj1() method above
	public static void printMultiResultObj1(ArrayList<Result> resultList,
											 ArrayList<Bed> bedList)
		{
		for(int i = 0; i < resultList.size(); i++)
			{
			Result result = resultList.get(i);
			printResultObj1(result, bedList);
			}
		}
	
	//When each Result Object is a group of Beds , ie, numOfBeds > 1
	//for a single day
	//(A ':' delimited string for positions)
	public static void printGroupResultObj(Result result, 
										   ArrayList<Bed> bedList)
		{
		String[] token = result.getPosition().split(":");
		int[] posArr = convertStrToInt(token);
		String info = "search_id: " + result.getId() + ", $" + 
						result.getTotal() + ", ";
		for(int i = 0; i < posArr.length; i++)
			{
			String bedId = bedList.get(posArr[i]).getId();
			String room = bedList.get(posArr[i]).getRoom();
			info += "bed #" + bedId + " " + "room #" + room;
			if(i != (token.length - 1))
				info += " || ";
			}
		
		System.out.println(info);
		}
	
	
	//When each Result Object is a group of Beds , ie, numOfBeds > 1
	//for multiple days
	//(A ':' and ',' delimited string for positions)
	public static void printGroupResultObj1(Result result, 
											ArrayList<Bed> bedList)
		{
		try{
			String[] myToken = result.toString().split(", ");
			String[] token = myToken[1].split(":");
			String info = "search_id: " + result.getId() + ", $" + 
						  result.getTotal() + " ==> ";
			for(int i = 0; i < token.length; i++)
				{
				String[] tokens = token[i].split(",");
				int pos = Integer.parseInt(tokens[0]);
				String bedId = bedList.get(pos).getId();
				String room =  bedList.get(pos).getRoom();
				info += "bed #" + bedId + " " + "room #" + room;
				if(i != (token.length - 1))
					info += " || ";
					
				}
			System.out.println(info);
			}
		
		catch(NumberFormatException e)
			{System.out.println("Error! Main() printResultObj3()");}
		catch(PatternSyntaxException e)
			{System.out.println("Error! Main() printResultObj3()");}
		catch(IndexOutOfBoundsException e)
			{System.out.println("Error! Main() printResultObj3()");}
		}
	
//======================================================================
//========================//START OF MAIN\\=============================
//======================================================================	

	public static void main(String[] args)
		{
		Hostel hostel = new Hostel();
		CmdParser cmdParser = new CmdParser();
		Search search = new Search();
		Sort sort = new Sort();
		XMLParser xmlParser = new XMLParser();
		TXTHandler txtHandler = new TXTHandler();
		ProcessBooking processBook = new ProcessBooking();
		ArrayList<Result> resultList = new ArrayList<Result>();
		String currDir = search.currentDir();
		
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); 
		
		String request = "";
		String arg = "";
		
		System.out.println("=====//HOSTEL 21\\\\=====");
		
		while(true)
			{
			request = ""; arg = "";
			prompt();
			
			scan = new Scanner(System.in);
			arg = scan.nextLine();
			
			if(arg.equalsIgnoreCase("quit") || 
					arg.equalsIgnoreCase("exit"))
				{
				System.out.println("Exiting......\nGOODBYE!");
				break;
				}
			
			if(arg.contains("admin load"))
				request = "1.1";
			
			if(arg.contains("admin revenue"))
				request = "1.2";
			
			if(arg.contains("admin occupancy"))
				request = "1.3";
			
			if(arg.contains("search") && !(arg.contains("--beds")))
				request = "2.1";
			
			if(arg.contains("search") && arg.contains("--beds"))
				{
				request = "2.2";
				resultList.clear();
				}
			
			if(arg.contains("book add"))
				request = "2.3";
			
			if(arg.contains("book cancel"))
				request = "2.4";
			
			if(arg.contains("book view"))
				request = "2.5";
			
			if(arg.contains("user add"))
				request = "3.1";
			
			if(arg.contains("user change"))
				request = "3.2";
			
			if(arg.contains("user view"))
				request = "3.3";
		
		//###################################################
		//Switch statement for handling 'admin' commands
		//###################################################
			switch(request)
				{
				case "1.1":
					ArrayList<Bed> newList = new ArrayList<Bed>();
					ArrayList<Bed> oldList = new ArrayList<Bed>();
					
					String txtFile = "";
					String xmlFile = cmdParser.parseXMLName(arg);
					if(xmlFile == null)
						{
						System.out.println("Error! Make sure you use " +
											"single quotes around filename");
						break;
						}
					
					String key = xmlParser.getCity(xmlFile);
					String[] txtFiles = search.txtFilesWithKey(key, 
														search.currentDir());
					
					xmlParser.loadAvailability(xmlFile, newList);
					if(txtFiles[0].equals(""))
						{
						txtFile = key + ".txt";
						newList = sort.listByDate(newList);
						writeHostelBackgroundData(xmlFile, txtFile);
						txtHandler.writeBedList(txtFile, newList);
						System.out.println("New file \'" + txtFile + "\' created");
						break;
						}
					
					if(txtFiles.length >= 1)
						{
						printOverwriteMenu(txtFiles);
						System.out.print("Choice here: ");
						@SuppressWarnings("resource")
						Scanner myScan = new Scanner(System.in);
						int fileChoice = myScan.nextInt();
						if(fileChoice == txtFiles.length)  //New File created
							{
							txtFile = key + txtFiles.length + ".txt";
							newList = sort.listByDate(newList);
							writeHostelBackgroundData(xmlFile, txtFile);
							txtHandler.writeBedList(txtFile, newList);
							System.out.println("New file \'" + txtFile + 
												"\' created");
							break;
							}
						txtFile = txtFiles[fileChoice];
						txtHandler.loadBedData(txtFile, oldList);
						oldList = search.dataOverwrite(oldList, newList);
						oldList = sort.listByDate(oldList);
						writeHostelBackgroundData(xmlFile, txtFile);
						txtHandler.writeBedList(txtFile, oldList);
						break;
						}
					
				case "1.2":
					processBook.calculateRevenue("booking.txt");
					break;
					
				case "1.3":
					String start = cmdParser.parseStartDate(arg);
					String end = cmdParser.parseEndDate1(arg);
					String location = cmdParser.parseCity(arg);
					String filename = "";
					String[] allTxtFiles = search.txtFilesWithKey(location, 
									search.currentDir());
					if(allTxtFiles[0].equals(""))
						{
						System.out.println("No data for location exists");
						break;
						}
					if(allTxtFiles.length == 1)
						{
						filename = location + ".txt";
						}
					if(allTxtFiles.length > 1)
						{
						printMultipleFilesMenu(allTxtFiles);
						System.out.print("Choice here: ");
						@SuppressWarnings("resource")
						Scanner myScan = new Scanner(System.in);
						int fileChoice = myScan.nextInt();
						filename = allTxtFiles[fileChoice];
						}
					double occupancyRate = processBook.calculateOccupancy
							(filename, start, end);
					System.out.println("===//OCCUPANCY\\\\===" + "\n" +
										"=> " + occupancyRate + "%");
					
				}
			
		//###########################################################	
		//Switch statement for handling 'search' and 'book' commands
		//###########################################################
			switch(request)
				{
				case "2.1":
					String key = cmdParser.parseCity(arg);
					String start = cmdParser.parseStartDate(arg);
					String end = cmdParser.parseEndDate1(arg);
					String filename = "";
					String[] files = search.txtFilesWithKey(key, currDir);
					
					if(files.length > 1)
						{
						printMultipleFilesMenu(files);
						System.out.print("Choice here: ");
						@SuppressWarnings("resource")
						Scanner locScan = new Scanner(System.in);
						int loc = locScan.nextInt();
						filename = files[loc];
						}
					else
						{filename = key + ".txt";}
					
					ArrayList<Bed> bedList = new ArrayList<Bed>();
					txtHandler.loadBedData(filename, bedList);
					String result = search.allBeds(start, end, bedList);
					if(result.equals(""))
						break;
					result = result.replaceFirst(",", "");
					String[] tokens = result.split(",");
					int[] posArr = convertStrToInt(tokens);
					String[] dateArr = search.getDatesInRange(start, end);
					printSearchResult(posArr, dateArr, bedList);
					
					break;
					
				case "2.2":
					String key1 = cmdParser.parseCity(arg);
					String start1 = cmdParser.parseStartDate(arg);
					String end1 = cmdParser.parseEndDate(arg);
					String dateRange = start1 + "-" + end1;
					int numOfBeds = Integer.parseInt(cmdParser.parseBeds(arg)); 
				
					String filename1 = "";
					String[] files1 = search.txtFilesWithKey(key1, currDir);
					
					
					if(numOfBeds == 0)
						{
						System.out.println("Please enter bed amount > 0!");
						break;
						}
					
					if(start1.equals(end1))
						{
						System.out.println("Please enter a valid date range!");
						break;
						}
					
					if(files1.length > 1)
						{
						printMultipleFilesMenu(files1);
						System.out.print("Choice here: ");
						@SuppressWarnings("resource")
						Scanner locScan = new Scanner(System.in);
						int loc = locScan.nextInt();
						filename1 = files1[loc];
						}
					else
						{filename1 = key1 + ".txt";}
					
					ArrayList<Bed> bedList1 = new ArrayList<Bed>();
					//resultList = new ArrayList<Result>();
					txtHandler.loadBedData(filename1, bedList1);
					String address = txtHandler.getAddress(filename1);
					String contact = txtHandler.getContact(filename1);
					String restrictions = txtHandler.getRestrictions(filename1);
					hostel = new Hostel(filename1, address, contact, restrictions, bedList1);
					
					String result1 = search.multiBedsForRange(start1, end1, 
													numOfBeds, 0, bedList1);
					String[] dateArr1 = search.getDatesInRange(start1, end1);
					if(result1.equals("null"))
						{
						System.out.println("Not enough beds for range!");
						break;
						}
					
					
					
					if(numOfBeds == 1)
						{
						if(dateArr1.length == 1)
							{
							Result res = new Result();
							if(result1.contains("-"))
								{
								String[] token = result1.split("-");
								int[] posArr1 = convertStrToInt(token);
	
								System.out.println("\n=====//AVAILABILITY\\\\=====");
								for(int i = 0; i < posArr1.length; i++)
									{
									String id = generateId(9999, 4);
									double total = bedList1.get(posArr1[i]).getPrice();
									res = new Result(id, posArr1[i]+"", total, 
													dateRange, numOfBeds);
									resultList.add(res);
									printResultObj(res, hostel.getBedArrList());
									}
								resultList = sort.resultListByTotal(resultList);
								break;
								}
							else
								{
								String tempId = generateId(9999, 4);
								int aPos = Integer.parseInt(result1);
								double total = bedList1.get(aPos).getPrice();
								res = new Result(tempId, result1, total, dateRange, numOfBeds);
								resultList.add(res);
								System.out.println("\n=====//AVAILABILITY\\\\=====");
								printResultObj(res, hostel.getBedArrList());
								break;
								}
							}
						if(dateArr1.length > 1)
							{
							Result res = new Result();
							if(result1.contains("-"))
								{
								String[] token = result1.split("-");
	
								
								for(int i = 0; i < token.length; i++)
									{
									int[] posArr1 = convertStrToInt(token[i].split(","));
									String id = generateId(9999, 4);
									double total = 0;
									for(int j = 0; j < posArr1.length; j++)
										{
										total += bedList1.get(posArr1[j]).getPrice();
										}
									res = new Result(id, token[i], total, dateRange, numOfBeds);
									resultList.add(res);
									}
								resultList = sort.resultListByTotal(resultList);
								System.out.println("\n=====//AVAILABILITY\\\\=====");
								printMultiResultObj1(resultList, 
												hostel.getBedArrList());
								break;
								}
							else
								{
								int[] posArr1 = convertStrToInt(result1.split(","));
								String id = generateId(9999, 4);
								double total = 0;
								for(int i = 0; i < posArr1.length; i++)
									{
									total += bedList1.get(posArr1[i]).getPrice();
									}
								res = new Result(id, result1, total, dateRange, numOfBeds);
								resultList.add(res);
								System.out.println("\n=====//AVAILABILITY\\\\=====");
								printResultObj1(res, hostel.getBedArrList());
								break;
								}
							}
						}
					
					if(numOfBeds > 1)
						{
						if(dateArr1.length == 1)
							{
							String[] token = result1.split("-");
							int[] posArr1 = convertStrToInt(token);
							for(int i = 0; i < posArr1.length; i++)
								{
								String id = generateId(9999, 4);
								double total = bedList1.get(posArr1[i]).getPrice();
								Result res = new Result(id, posArr1[i]+"", total, 
														dateRange, numOfBeds);
								resultList.add(res);
								}
							resultList = sort.resultListByTotal(resultList);
							resultList = groupBedsByAmount(numOfBeds, resultList, dateRange);
							System.out.println("=====//AVAILABILITY\\\\=====");
							for(int i = 0; i < resultList.size(); i++)
								{
								printGroupResultObj(resultList.get(i),
													hostel.getBedArrList());
								}
							break;
							}

						if(dateArr1.length > 1)
							{
							String[] token = result1.split("-");
							for(int i = 0; i < token.length; i++)
								{
								double total = countTotal(token[i], bedList1);
								String pos = token[i];
								Result res = new Result("", pos, total, dateRange, numOfBeds);
								resultList.add(res);
								}
							resultList = sort.resultListByTotal(resultList);
							resultList = groupBedsByAmount(numOfBeds, resultList, dateRange);
							System.out.println("=====//AVAILABILITY\\\\=====");
							for(int i = 0; i < resultList.size(); i++)
								{
								printGroupResultObj1(resultList.get(i),
													hostel.getBedArrList());
								}
							break;
							}
						}
					break;
					
				case "2.3":
					String searchId = cmdParser.parseSearchId(arg);
					String userId = cmdParser.parseUserId(arg);
					int resultPos = search.resultById(searchId, resultList); 
					if(resultPos == -1)
						{
						System.out.println("Invalid --search_id!");
						break;
						}
					Result myResult = resultList.get(resultPos);
					int myNumOfBeds = myResult.getNumOfBeds();
					String myDateRange = myResult.getDateRange();
					String[] myDatesArr = myDateRange.split("-");
					String[] myDates = search.getDatesInRange(myDatesArr[0], 
															myDatesArr[1]);
					if(myNumOfBeds == 1 && myDates.length == 1)
						processBook.process1(userId, myResult, hostel);
					
					if(myNumOfBeds == 1 && myDates.length > 1)
						processBook.process2(userId, myResult, hostel);
					
					if(myNumOfBeds > 1 && myDates.length == 1)
						processBook.process3(userId, myResult, hostel);
					
					if(myNumOfBeds > 1 && myDates.length > 1)
						processBook.process4(userId, myResult, hostel);
					
					txtHandler.writeHostelData(hostel);
					break;
					
				case "2.4":
					String bookId = cmdParser.parseBookingId(arg);
					String bookingStr = search.bookingById(bookId);
					if(bookingStr.equals("0"))
						{
						System.out.println("No booking with ID: " + 
											bookId + " found!");
						break;
						}
					if(bookingStr.equals("-1"))
						{
						System.out.println("File booking.txt not found!");
						break;
						}
					
					Scanner dateScan = new Scanner(System.in);
					System.out.print("Enter today's date(yyyymmdd): ");
					String dateToday = dateScan.nextLine().trim();
					
					String[] bookArr = bookingStr.split(", ");
					String location = bookArr[5];
					String locAddress = txtHandler.getAddress(location);
					String locContact = txtHandler.getContact(location);
					String locRestrictions = txtHandler.getRestrictions(location);
					String cancelPolicy = search.getCancelPolicy(locRestrictions);
					ArrayList<Bed> myList = new ArrayList<Bed>(); 
					txtHandler.loadBedData(location, myList); 
					Hostel myHostel = new Hostel(location, locAddress, locContact, 
												locRestrictions, myList);
					processBook.cancel(dateToday, cancelPolicy, 
										bookId, myHostel.getBedArrList());
					txtHandler.modifyTxt(bookingStr, "*"+bookingStr, "booking.txt");
					txtHandler.writeHostelData(myHostel);
					break;
					
				case "2.5":
					String bookingId = cmdParser.parseBookingId(arg);
					String booking = search.bookingById(bookingId);
					if(booking.equals("0"))
						{
						System.out.println("No booking with ID: " + 
											bookingId + " found!");
						break;
						}
					if(booking.equals("-1"))
						{
						System.out.println("File booking.txt not found!");
						break;
						}
					
					String[] token = booking.split(", ");
					String customer = search.customerByEmail(token[1], 
															"customer.txt");
					String[] token1 = customer.split(", ");
					System.out.println("ID: " + token[0] + "\n" +
									   "NAME: " + token1[1] + " " + token1[2] + "\n" +
									   "BEDS(bed-room): " + token[2] + "\n" +
									   "TOTAL: $" + token[3] + "\n" +
									   "DATE RANGE: " + token[4] + "\n" + 
									   "LOCATION: " + token[5].replace(".txt", ""));
				break;
				}
				
		//####################################################	
		//Switch statement for handling 'user' commands
		//####################################################
			switch(request)
				{
				case "3.1":
					boolean check = search.ifTxtFileExists("customer.txt");
					if(check == false)
						txtHandler.createTxtFile("customer.txt");
					String id = generateId(99999, 5);
					String idCheck = search.customerById(id, "customer.txt");
					while(!(idCheck.equals("0")))
						id = generateId(99999, 5);
					Customer customer = createCustomer(id, arg);
					String custCheck = search.customerByEmail
											(customer.getEmail(),"customer.txt");
					if(custCheck.equals("-1"))
						{
						System.out.println("Cannot find file customer.txt!");
						break;
						}
					if(!(custCheck.equals("0")))
						{
						System.out.println("Customer exists! Use \"change\"" +
								" command instead!");
						printCustomerFrmStr(custCheck);
						break;
						}
					txtHandler.writeAppend("customer.txt", 
										  customer.toString());
					System.out.println("Customer added successfully!");
					printCustomer(customer);
					break;
				
				case "3.2":
					@SuppressWarnings({ "rawtypes", "unchecked" })
					ArrayList<Customer> custList = new ArrayList();
					txtHandler.loadCustomerData("customer.txt", custList);
					String newId = cmdParser.parseId(arg);
					for(int i = 0; i < custList.size(); i++)
						{
						if(custList.get(i).getId().equals(newId))
							{
							ArrayList<String> newData = 
											cmdParser.parseUserData(arg);
							modifyCustomer(custList.get(i), newData);
							
							txtHandler.deleteTxtFile("customer.txt");
							txtHandler.createTxtFile("customer.txt");
							txtHandler.writeCustomerList("customer.txt",
														custList);
							System.out.println("Customer modified successfully!\n");
							printCustomer(custList.get(i));
							break;
							}
						}
					break;
					
				case "3.3":
					String email = cmdParser.parseEmailForView(arg);
					String custInfo = search.customerByEmail(email, 
															"customer.txt");
					if(custInfo.equals("-1"))
						System.out.println("File 'customer.txt' not found!");
						
					if(custInfo.equals("0"))
						System.out.println("No customer exists with " +
										   "email: " + email);
					
					if(!(custInfo.equals("0")))
						printCustomerFrmStr(custInfo);
					break;
				}
			}
		
		}
	
//======================================================================
//========================//END OF MAIN\\=============================
//======================================================================

	public static void prompt()
		{System.out.print("$ ");}
	
	public static String getAddress(String filename)
		{
		XMLParser xml = new XMLParser();
		String str = "# " + xml.getFullAddress(filename);
		return str;	
		}
	
	public static String getContact(String filename)
		{
		XMLParser xml = new XMLParser();
		String str = "# " + xml.getContact(filename);
		return str;	
		}
	
	public static String getRestrictions(String filename)
		{
		XMLParser xml = new XMLParser();
		String str = "# " + xml.getRestrictions(filename);
		return str;
		}
	
	
	
	//Generate an int between 1 and max and 
	//pad it with desired amount of zeros 
	public static String generateId(int max, int idLength)
		{
		Random ran = new Random();
		int x = ran.nextInt(max + 1);
		String id = padZeros(x, idLength);
		return id;
		}
	
	public static String padZeros(int number, int padAmount)
		{
		String pad = "%0" + padAmount + "d";
		return String.format(pad, number);
		}
	
	public static int[] convertStrToInt(String[] strArr)
		{
		int[] intArr = new int[strArr.length];
		try{
			for(int i = 0; i < strArr.length; i++)
				intArr[i] = Integer.parseInt(strArr[i]);
		   }
		catch(NumberFormatException e){}
		return intArr;
		}
	
	public boolean ifContainsDash(String string)	
		{
		return string.contains("-");
		}
	
	public static int countDashes(String myString)
		{
		int count = 0;
		for(int i = 0; i < myString.length(); i++)
			{
			if(myString.charAt(i) == ('-'))
				count++;
			}
		return count;
		}
	
	//Find total for a comma-delimited String, ie, a single bed for multiple days
	public static double countTotal(String posString, ArrayList<Bed> bedList)
		{
		double total = 0;
		String[] token = posString.split(",");
		int[] posArr = convertStrToInt(token);
		
		for(int i = 0; i < posArr.length; i++)
			total += bedList.get(posArr[i]).getPrice();
		
		return total;
		}
	
	//Find total for a - and , delimited String, ie, multiple beds for range
	public static double countTotal1(String posString, ArrayList<Bed> bedList)
		{
		double total = 0;
		String[] token = posString.split(":");
		
		for(int i = 0; i < token.length; i++)
			total += countTotal(token[i],bedList);
		
		return total;
		}
}

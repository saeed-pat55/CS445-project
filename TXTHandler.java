import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TXTHandler {

	public void createTxtFile(String filename)
		{
		try{
		Search search = new Search();
		String dir = search.currentDir();
		boolean fileExists = new File(dir, filename).exists();
		if(fileExists);
			//System.out.println("File already Exists!!");
		else{	
			File file = new File(filename);
			file.createNewFile();
			System.out.println("New File:"+filename + " created!");
			}
		}
		catch(IOException e)
			{System.out.println("An error occurred creating " +
								"file" + filename);}
		}
	
	public void deleteTxtFile(String file)
		{
		File aFile = new File(file);
		if(aFile.delete())
			System.out.println("File:"+file+ 
							   " deleted successfully!");
		else
			System.out.println("Error! File deletion failed!");
		}
	
	public boolean write(String file, String myString)
		{
		try{
			BufferedWriter bw = new BufferedWriter
								(new FileWriter(file));
			String newLine = System.getProperty("line.separator");
			bw.write(myString + newLine);
			bw.flush();
			bw.close();
			return true;
			}
		catch(IOException e)
			{return false;}
		}
	
	public boolean writeAppend(String file, String myString)
		{
		try{
			BufferedWriter bw = new BufferedWriter
								(new FileWriter(file, true));
			String newLine = System.getProperty("line.separator");
			bw.append(myString + newLine);
			bw.flush();
			bw.close();
			return true;
			}
		catch(IOException e)
			{return false;}
		}
	
	public boolean writeArray(String file, String[] myArr)
		{
		try{
			BufferedWriter bw = new BufferedWriter
								(new FileWriter(file, true));
			String newLine = System.getProperty("line.separator");
			for(int i = 0; i < myArr.length; i++)
				bw.append(myArr[i] + newLine);
			bw.flush();
			bw.close();
			return true;
			}
		catch(IOException e)
			{return false;}
		}
	
	public boolean writeBedList(String filename, ArrayList<Bed> bedList)
		{
		try{
			BufferedWriter bw = new BufferedWriter
								(new FileWriter(filename, true));
			String newLine = System.getProperty("line.separator");
			for(int i = 0; i < bedList.size(); i++)
				{
				String bedInfo = bedList.get(i).toString() + newLine;
				bw.append(bedInfo);
				}
			bw.flush();
			bw.close();
			return true;
			}
		catch(IOException e)
			{return false;}
		}
	
	public boolean writeCustomerList(String filename, 
									ArrayList<Customer> custList)
		{
		try{
			BufferedWriter bw = new BufferedWriter
								(new FileWriter(filename, true));
			String newLine = System.getProperty("line.separator");
			for(int i = 0; i < custList.size(); i++)
				{
				String info = custList.get(i).toString() + newLine;
				bw.append(info);
				}
			bw.flush();
			bw.close();
			return true;
			}
		catch(IOException e)
			{return false;}
		}
	
	public void writeHostelData(Hostel hostel)
		{
			String filename = hostel.getName();
			write(filename, "# " + hostel.getAddress());
			writeAppend(filename, "# " + hostel.getContact());
			writeAppend(filename, "# " + hostel.getRestrictions());
			writeBedList(filename, hostel.getBedArrList());
		}
	
	public void modifyTxt(String key, String info, 
									String file)
		{
		try{
			String newLine = System.getProperty("line.separator");
			Scanner read = new Scanner(new FileReader(file));
			this.createTxtFile("temp.txt");
			BufferedWriter bw = new BufferedWriter
						(new FileWriter("temp.txt"));
			while(read.hasNextLine())
				{
				String temp = read.nextLine();
				if(temp.contains(key))
					bw.write(info + newLine);
				else
					bw.write(temp + newLine);
				}
			read.close();
			bw.flush();
			bw.close();
			File old = new File(file);
			old.delete();
			File tempFile = new File("temp.txt");
			File newFile = new File(file);
			tempFile.renameTo(newFile);
			System.out.println("Modify successful!");
			}
		catch(IOException e)
			{System.out.println("Error! Customer modify failed!");}
		}
	
	
	public void deleteTxt(String key, String file)
		{
		try{
			String newLine = System.getProperty("line.separator");
			Scanner read = new Scanner(new FileReader(file));
			createTxtFile("temp.txt");
			BufferedWriter bw = new BufferedWriter
					            (new FileWriter("temp.txt"));
			while(read.hasNextLine())
				{
				String temp = read.nextLine();
				if(temp.contains(key))
					continue;
				else
					bw.write(temp + newLine);
				}
				read.close();
				bw.flush();
				bw.close();
				File old = new File(file);
				old.delete();
				File tempFile = new File("temp.txt");
				File newFile = new File(file);
				tempFile.renameTo(newFile);
				System.out.println("Deletion was successful!");
			}
		catch(IOException e)
			{System.out.println("Error! Customer delete failed!");}
		}
	
	public void loadBedData(String filename, ArrayList<Bed> bedList)
		{
		try{
			Scanner read = new Scanner(new FileReader(filename));
			
			while(read.hasNextLine())
				{
				String str = read.nextLine();
				if(str.contains("#"))	//Skipping the line that contain '#'
					continue;	
				String[] token = str.split(", ");
				String id = token[0];
				String room = token[1];
				String date = token[2];
				double price = Double.parseDouble(token[3]);
				String currency = token[4];
				boolean booked = Boolean.parseBoolean(token[5]);
				Bed bed = new Bed(id, room, date, currency, price, booked);
				bedList.add(bed);
				}
			read.close();
			}
		catch(FileNotFoundException e)
		{System.out.println("File: " + filename + " was not found!");}
		}

	public void loadCustomerData(String filename, 
								ArrayList<Customer> custList)
		{
		try{
			Scanner read = new Scanner(new FileReader(filename));
			
			while(read.hasNextLine())
				{
				String str = read.nextLine();
				String[] token = str.split(", ");
				String id = token[0];
				String first = token[1];
				String last = token[2];
				String email = token[3];
				String cc = token[4];
				String cc_exp = token[5];
				String cc_code = token[6];
				String phone = token[7];
				String fb = token[8];
				String twit = token[9];
				Customer cust = new Customer(id, first, last, email,
											cc, cc_exp, cc_code, phone,
											fb, twit);
				custList.add(cust);
				}
			read.close();
			}
		catch(FileNotFoundException e)
			{System.out.println("File: customer.txt was not found!");}
		}
			
	public String getAddress(String txtFile)
		{
		try{
			Scanner read = new Scanner(new FileReader(txtFile));
			String address = read.nextLine().replaceFirst("# ", "");
			read.close();
			return address;
			}
		catch(FileNotFoundException e)
			{return "Error in method getAddress()" +
					" cannot find txt file";}
		}
	
	public String getAddresses(String[] files)
		{
		String address = "";
		for(int i = 0; i < files.length; i++)
			{
			try{
				Scanner read = new Scanner(new FileReader(files[i]));
				address += read.nextLine();
				read.close();
				}
			catch(FileNotFoundException e)
				{return "Error in method getAddresses()" +
						" cannot find txt file";}
			}
		return address;
		}
	
	public String getRestrictions(String txtFile)
		{
		try{
			Scanner read = new Scanner(new FileReader(txtFile));
			read.nextLine();
			read.nextLine();
			String restriction = read.nextLine().replaceFirst("# ", "");
			read.close();
			return restriction;
			}
		catch(FileNotFoundException e)
			{return "Error in method getAddress()" +
					" cannot find txt file";}
		}
	
	public String getContact(String txtFile)
		{
		try{
			Scanner read = new Scanner(new FileReader(txtFile));
			read.nextLine();
			String contact = read.nextLine().replaceFirst("# ", "");
			read.close();
			return contact;
			}
		catch(FileNotFoundException e)
			{return "Error in method getContact()" +
					" cannot find txt file";}
		}
			
			
			
			
			
			
			
			
			
			
			
			
}

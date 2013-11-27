import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
 
public class XMLParser {
	
	public String[] getAvailability(String filename)
		{
		String[] bedArr = new String[0];
	    try {
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("availability");
			bedArr = new String[nList.getLength()];
			
			for (int i = 0; i < nList.getLength(); i++) 
				{
				Node nNode = nList.item(i);
				String str = "";
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
					Element eElement = (Element) nNode;
					str += eElement.getElementsByTagName("bed")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("room")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("date")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("price")
									.item(0).getTextContent();
					bedArr[i] = str;
					}
				}
	    	} 
	    catch (Exception e) 
	    	{System.out.println("Error occured parsing availability from XML!");}
	    return bedArr;
		}
	
	public void loadAvailability(String filename, ArrayList<Bed> bedList)
		{
		String[] availArr = this.getAvailability(filename);
		for(int i = 0; i < availArr.length; i++)
			{
			String[] token = availArr[i].split(", ");
			String id = token[0];
			String room = token[1];
			String date = token[2];
			double price = Double.parseDouble(token[3]);
			String currency = "USD";
			boolean booked = false;
			Bed bed = new Bed(id, room, date, currency, price, booked);
			bedList.add(bed);
			}
		}
	
	
	public String getFullAddress(String filename)
		{
		String str = "";
	    try {
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("address");
				Node nNode = nList.item(0);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
					Element eElement = (Element) nNode;
					str += eElement.getElementsByTagName("street")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("city")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("state")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("postal_code")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("country")
							.item(0).getTextContent();
					}
	    	} 
	    catch (Exception e) 
	    	{System.out.println("Error occured parsing availability from XML!");}
	    return str;
		}
	
	public String getCity(String filename)
		{
		try{
			String str = this.getFullAddress(filename);
			String[] token = str.split(", ");
			return token[1].toLowerCase();
			}
		catch(IndexOutOfBoundsException e)
			{return "Error occured getting city from xml";}
		}
	
	
	public String getContact(String filename)
		{
		String str = "";
	    try {
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("contact");
				Node nNode = nList.item(0);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
					Element eElement = (Element) nNode;
					str += eElement.getElementsByTagName("phone")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("email")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("facebook")
									.item(0).getTextContent();
					str += ", " + eElement.getElementsByTagName("web")
									.item(0).getTextContent();	
					}
	    	} 
	    catch (Exception e) 
	    	{System.out.println("Error occured parsing availability from XML!");}
	    return str;
		}
	
	public String getName(String filename)
		{
		String str = "";
	    try {
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("name");
				Node nNode = nList.item(0);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
					{
					Element eElement = (Element) nNode;
					str = eElement.getTextContent();
					}
	    	} 
	    catch (Exception e) 
	    	{System.out.println("Error occured parsing availability from XML!");}
	    return str;
		}
	
	public String getRestrictions(String filename)
		{
		String str = "";
	    try {
			File xmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("restrictions");
			Node nNode = nList.item(0);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
				Element eElement = (Element) nNode;
				str += eElement.getElementsByTagName("check_in_time")
								.item(0).getTextContent();
				str += ", " + eElement.getElementsByTagName("check_out_time")
								.item(0).getTextContent();
				str += ", " + eElement.getElementsByTagName("smoking")
								.item(0).getTextContent();
				str += ", " + eElement.getElementsByTagName("alcohol")
								.item(0).getTextContent();
				str += ", " + eElement.getElementsByTagName("cancellation_deadline")
						.item(0).getTextContent();
				str += ", " + eElement.getElementsByTagName("cancellation_penalty")
						.item(0).getTextContent();
				}
	    	} 
	    catch (Exception e) 
	    	{System.out.println("Error occured parsing availability from XML!");}
	    return str;
		}
}
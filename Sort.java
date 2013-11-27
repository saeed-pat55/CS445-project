import java.util.ArrayList;


public class Sort {

	public ArrayList<Bed> listByDate(ArrayList<Bed> bedList)
		{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList<Bed> tempList = new ArrayList();
		tempList.add(bedList.get(0));
		for(int i = 1; i < bedList.size(); i++)
			{
			int j = 0;
			Bed bed = bedList.get(i);
			for(j = 0; j < tempList.size(); j++)
				{
				Bed temp = tempList.get(j);
				if(bed.getDate().compareTo(temp.getDate()) < 0 ||
					bed.getDate().compareTo(temp.getDate()) == 0)
					{
					tempList.add(j, bed);
					break;
					}
				}
			if(j == tempList.size())
				tempList.add(bed);
			}
		return tempList;
		}

	public ArrayList<Bed> listByPrice(ArrayList<Bed> bedList)
		{
		ArrayList<Bed> tempList = new ArrayList<Bed>();
		tempList.add(bedList.get(0));
		for(int i = 1; i < bedList.size(); i++)
			{
			int j = 0;
			Bed bed = bedList.get(i);
			for(j = 0; j < tempList.size(); j++)
				{
				Bed temp = tempList.get(j);
				if(bed.getPrice() <= temp.getPrice())
					{
					tempList.add(j, bed);
					break;
					}
				}
			if(j == tempList.size())
				tempList.add(bed);
			}
		return tempList;
		}
	
	public ArrayList<Result> resultListByTotal(ArrayList<Result> resultList)
		{
		ArrayList<Result> tempList = new ArrayList<Result>();
		tempList.add(resultList.get(0));
		for(int i = 1; i < resultList.size(); i++)
			{
			int j = 0;
			Result res = resultList.get(i);
			for(j = 0; j < tempList.size(); j++)
				{
				Result temp = tempList.get(j);
				if(res.getTotal() <= temp.getTotal())
					{
					tempList.add(j, res);
					break;
					}
				}
			if(j == tempList.size())
				tempList.add(res);
			}
		return tempList;
		}

}

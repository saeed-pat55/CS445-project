
import java.util.ArrayList;

import org.junit.Test;


public class TestSort {
	
	@Test
	public void test_bedListByDate()
		{
		System.out.println("\nTesting sorting ArrayList<Bed> " +
							"by date...");
		Sort sort = new Sort();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed("1", "3", "20121212","USD",  24.99, false);
		Bed bed1 = new Bed("1", "3", "20121210","USD",  24.99, false);
		Bed bed2 = new Bed("1", "3", "20121211","USD",  24.99, false);
		bedList.add(bed);
		bedList.add(bed1);
		bedList.add(bed2);
		System.out.println("=========================");
		System.out.println(bed.toString() + "\n" + bed1.toString() + 
							"\n" + bed2.toString());
		bedList = sort.listByDate(bedList);
		System.out.println("=========================");
		for(int i = 0; i < bedList.size(); i++)
			System.out.println(bedList.get(i).toString());
		}
	
	@Test
	public void test_bedListByPrice()
		{
		System.out.println("\nTesting sorting ArrayList<Bed> " +
							"by total...");
		Sort sort = new Sort();
		ArrayList<Bed> bedList = new ArrayList<Bed>();
		Bed bed = new Bed("1", "3", "20121212","USD",  32.99, false);
		Bed bed1 = new Bed("1", "3", "20121210","USD",  24.99, false);
		Bed bed2 = new Bed("1", "3", "20121211","USD",  19.99, false);
		bedList.add(bed);
		bedList.add(bed1);
		bedList.add(bed2);
		System.out.println("=========================");
		System.out.println(bed.toString() + "\n" + bed1.toString() + 
							"\n" + bed2.toString());
		bedList = sort.listByPrice(bedList);
		System.out.println("=========================");
		for(int i = 0; i < bedList.size(); i++)
			System.out.println(bedList.get(i).toString());
		}
	
	
	@Test
	public void test_resultListByTotal()
		{
		System.out.println("\nTesting sorting ArrayList<Result> " +
							"by total...");
		Sort sort = new Sort();
		ArrayList<Result> resList = new ArrayList<Result>();
		Result res1 = new Result("4564", "12", 33, "", 0);
		Result res2 = new Result("4564", "12", 11, "", 0);
		Result res3 = new Result("4564", "12", 19, "", 0);
		resList.add(res1);
		resList.add(res2);
		resList.add(res3);
		System.out.println("========================");
		for(int i = 0; i < resList.size(); i++)
			System.out.println(resList.get(i).toString());
		resList = sort.resultListByTotal(resList);
		System.out.println("========================");
		for(int i = 0; i < resList.size(); i++)
			System.out.println(resList.get(i).toString());
		}
}

package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	//Returning all the excel data
	@DataProvider(name="Data")
	public String[][]getAllData() throws IOException
	{
		//Take the path of the excel file from the project System.getProperty("user.dir") to get the current project location
		String path=System.getProperty("user.dir")+"//testData//userTestData.xlsx";
		
		//Create the object for the XLutility.java file
		XLutilities xl=new XLutilities(path);
		
		//Takeing the count of the row and column from utility function xl
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1",1);
		
		//Create a 2D array to store the data from the excel
		String apidata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1",i,j);
			}
		}
		return apidata;
	}
	
	//Returning only the username for the other apis
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		//Take the path of the excel file from the project System.getProperty("user.dir") to get the current project location
				String path=System.getProperty("user.dir")+"//testData//userTestData.xlsx";
				
				//Create the object for the XLutility.java file
				XLutilities xl=new XLutilities(path);
				
				int rownum=xl.getRowCount("Sheet1");
				
				String apidata[]=new String[rownum];
				for(int i=1;i<rownum;i++)
				{
					apidata[i-1]= xl.getCellData("Sheet1", i, 1);
				}
				return apidata;
	}
	
	
}

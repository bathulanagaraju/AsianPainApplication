package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//configurations.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getSheatName1() {
		String sheatName1 = properties.getProperty("sheatName1");
		if(sheatName1 != null) return sheatName1;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getMobileNumber() {
		String mobileNumber = properties.getProperty("mobileNumber");
		if(mobileNumber != null) return mobileNumber;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getSheatName2() {
		String sheatName2 = properties.getProperty("sheatName2");
		if(sheatName2 != null) return sheatName2;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public int getRow() {
		String rownum = properties.getProperty("rownum");
		if(rownum != null)  return Integer.parseInt(rownum);
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getExcelPath() {
		String excelPath = properties.getProperty("excelPath");
		if(excelPath != null) return excelPath;
		else throw new RuntimeException("excelPath not specified in the Configuration.properties file.");
	}
	public String getColume1() {
		String colume1 = properties.getProperty("colume1");
		if(colume1 != null) return colume1;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getColume2() {
		String colume2 = properties.getProperty("colume2");
		if(colume2 != null) return colume2;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getColume3() {
		String colume3 = properties.getProperty("colume3");
		if(colume3 != null) return colume3;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
   
}
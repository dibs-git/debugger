import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Properties;

public class PropertiesExample {
	
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:/Users/Dell/Desktop/ProjectVar.properties");
		
		Properties p = new Properties();
		p.load(reader);
		
		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("email"));
		
		p.setProperty("emp", "749635");
		p.setProperty("env", "local");
		
		p.store(new FileWriter("C:/Users/Dell/Desktop/ProjectVar.properties"), "Example of Properties File..");

		
		Properties pr = System.getProperties();
		
		for(Map.Entry en: pr.entrySet()) {
			System.out.println(en.getKey() + " = "+ en.getValue());
		}
		
		Properties pt = new Properties();
		pt.setProperty("emp", "749635");
		pt.setProperty("env", "local");
		
		//pt.store(new FileWriter("C:/Users/Dell/Desktop/ProjectVar.properties"), "Example of Properties File");
		
		
	}

}

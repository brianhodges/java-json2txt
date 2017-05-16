import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.List;

class json2txt
{  
	public static void main(String args[])
	{
		List<Person> people = new ArrayList<Person>();
		JSONParser parser = new JSONParser();
		System.out.println();
        try {
            Object json = parser.parse(new FileReader("data.json"));
            System.out.println(json);
            JSONArray a = (JSONArray) json;
            System.out.println();
            for (int i = 0; i < a.size(); i++) {
				JSONObject o = (JSONObject) a.get(i);
				Person p = new Person(o);
				people.add(p);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try (PrintWriter out = new PrintWriter("log.txt")) {
			out.println();
			for (int x = 0; x < people.size(); x++) {
				out.println("ID: " + people.get(x).id);
				out.println("Full Name: " + people.get(x).first_name + " " + people.get(x).last_name);
				out.println("Email: " + people.get(x).email);
				out.println("BTC Address: " + people.get(x).btc_address);
				out.println("IP Address: " + people.get(x).ip_address);
				out.println();
			}
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Done.");
		System.out.println();
	}
}

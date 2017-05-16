import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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

class Person {
	   String id;
	   String first_name;
	   String last_name;
	   String email;
	   String btc_address;
	   String ip_address;
	   Person(JSONObject p) {
		   this.id = String.valueOf(p.get("id"));
		   this.first_name = String.valueOf(p.get("first_name"));
		   this.last_name = String.valueOf(p.get("last_name"));
		   this.email = String.valueOf(p.get("email"));
		   this.btc_address = String.valueOf(p.get("btc_address"));
		   this.ip_address = String.valueOf(p.get("ip_address"));
	   }
}
